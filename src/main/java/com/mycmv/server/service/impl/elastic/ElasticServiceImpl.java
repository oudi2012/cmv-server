package com.mycmv.server.service.impl.elastic;

import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.service.elastic.ElasticService;
import org.elasticsearch.index.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @author a
 * @param <T>
 */
@Service
public class ElasticServiceImpl<T> implements ElasticService<T> {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.SYS_LOG);

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private ElasticsearchRepository<T, Long> elasticsearchRepository;

    @Override
    public void createIndex(Class<T> clazz) {
        if (elasticsearchRestTemplate.indexExists(clazz)) {
            logger.error(" idxName={} 已经存在", clazz.getAnnotation(Document.class));
            return;
        }
        elasticsearchRestTemplate.createIndex(clazz);
        elasticsearchRestTemplate.putMapping(clazz);
    }

    @Override
    public boolean isExistsIndex(Class<T> clazz) {
        return elasticsearchRestTemplate.indexExists(clazz);
    }

    @Override
    public void insertOrUpdateOne(T item) {
        elasticsearchRepository.save(item);
    }

    @Override
    public void insertBatch(List<T> list) {
        elasticsearchRepository.saveAll(list);
    }

    @Override
    public void deleteBatch(List<T> list) {
        elasticsearchRepository.deleteAll(list);
    }

    @Override
    public Page<T> search(QueryBuilder builder, Pageable pageable) {
        return elasticsearchRepository.search(builder, pageable);
    }

    @Override
    public void deleteIndex(Class<T> clazz) {
        elasticsearchRestTemplate.deleteIndex(clazz);
    }

    @Override
    public void delete(T item) {
        elasticsearchRepository.delete(item);
    }
}
