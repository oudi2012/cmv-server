package com.mycmv.server.service.elastic;

import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/***
 * @author a
 */
public interface ElasticService<T> {

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
     */
    void deleteBatch(List<T> list);

    /**
     * search
     * @param builder builder
     * @param pageable pageable
     * @return Page
     */
    Page<T> search(QueryBuilder builder, Pageable pageable);

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
