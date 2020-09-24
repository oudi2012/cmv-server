package com.mycmv.server.service.impl;

import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.mapper.InfoElasticMapper;
import com.mycmv.server.model.ElasticInfo;
import com.mycmv.server.service.InfoElasticService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

import static com.mycmv.server.constants.CmvConstants.ES_ANALYZER_01;

/***
 * @author a
 * @param <T>
 */
public abstract class AbstractElasticServiceImpl<T extends ElasticInfo> implements InfoElasticService<T> {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.SYS_LOG);

    /***
     * 获取 ElasticsearchRestTemplate
     * @return ElasticsearchRestTemplate
     */
    public abstract ElasticsearchRestTemplate getElasticsearchRestTemplate();

    /***
     * 获取ElasticMapper
     * @return InfoElasticMapper
     */
    public abstract InfoElasticMapper<T, Long> getInfoElasticMapper();

    @Override
    public void createIndex(Class<T> clazz) {
        if (getElasticsearchRestTemplate().indexExists(clazz)) {
            logger.error(" idxName={} 已经存在", clazz.getAnnotation(Document.class));
            return;
        }
        getElasticsearchRestTemplate().createIndex(clazz);
        getElasticsearchRestTemplate().putMapping(clazz);
    }

    @Override
    public boolean isExistsIndex(Class<T> clazz) {
        return getElasticsearchRestTemplate().indexExists(clazz);
    }

    @Override
    public void insertOrUpdateOne(T item) {
        getInfoElasticMapper().save(item);
    }

    @Override
    public void insertBatch(List<T> list) {
        getInfoElasticMapper().saveAll(list);
    }

    @Override
    public int deleteBatch(List<T> list) {
        getInfoElasticMapper().deleteAll(list);
        return list.size();
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            getInfoElasticMapper().deleteById(id);
        }
        return ids.size();
    }

    /***
     * 获取 BoolQueryBuilder
     * @param item item
     * @return BoolQueryBuilder
     */
    private BoolQueryBuilder getElasticQuery(T item) {
        Field[] arrField = item.getClass().getDeclaredFields();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        try {
            for (Field field : arrField) {
                field.setAccessible(true);
                org.springframework.data.elasticsearch.annotations.Field antField =
                        field.getAnnotation(org.springframework.data.elasticsearch.annotations.Field.class);
                if (antField.type().equals(FieldType.Text)) {
                    if (!StringUtils.isEmpty(field.get(item))) {
                        if (antField.analyzer().equals(ES_ANALYZER_01)) {
                            boolQueryBuilder.must(QueryBuilders.termQuery(field.getName(), field.get(item)));
                        } else {
                            boolQueryBuilder.should(QueryBuilders.termQuery(field.getName(), field.get(item)));
                        }
                    }
                } else {
                    if (!ObjectUtils.isEmpty(field.get(item))) {
                        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery(field.getName(), field.get(item)));
                    }
                }
            }
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return boolQueryBuilder;
    }

    @Override
    public Page<T> search(T item, Pageable pageable) {
        return getInfoElasticMapper().search(getElasticQuery(item), pageable);
    }

    @Override
    public void deleteIndex(Class<T> clazz) {
        getElasticsearchRestTemplate().deleteIndex(clazz);
    }

    @Override
    public void delete(T item) {
        getInfoElasticMapper().delete(item);
    }
}
