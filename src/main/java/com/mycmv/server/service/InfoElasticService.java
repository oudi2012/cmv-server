package com.mycmv.server.service;

import com.mycmv.server.model.ElasticInfo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

import static com.mycmv.server.constants.CmvConstants.ES_ANALYZER_01;

/***
 * @author a
 */
public interface InfoElasticService<T extends ElasticInfo> {

    /***
     * 获取 BoolQueryBuilder
     * @param item item
     * @return BoolQueryBuilder
     */
    default BoolQueryBuilder getElasticQuery(T item) {
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

    /**
     * 创建索引
     * @param clazz clazz
     */
    void createIndex(Class<T> clazz);

    /***
     * 判断索引是否存在
     * @param clazz clazz
     * @return boolean
     */
    boolean isExistsIndex(Class<T> clazz);

    /***
     * insertOrUpdateOne
     * @param t t
     */
    void insertOrUpdateOne(T t);

    /***
     * insertBatch
     * @param list list
     */
    void insertBatch(List<T> list);

    /***
     * deleteBatch
     * @param list list
     * @return int
     */
    int deleteBatch(List<T> list);

    /***
     * deleteByIds
     * @param ids ids
     * @return int
     */
    int deleteByIds(List<Long> ids);

    /**
     * search
     * @param item item
     * @param pageable pageable
     * @return Page
     */
    Page<T> search(T item, Pageable pageable);

    /***
     * deleteIndex
     * @param clazz clazz
     */
    void deleteIndex(Class<T> clazz);

    /***
     * deleteByQuery
     * @param item item
     */
    void delete(T item);

}
