package com.mycmv.server.service.elastic;

import com.mycmv.server.model.elastic.entry.Elastic;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.Collection;
import java.util.List;

/***
 * @author a
 */
public interface ElasticService<T> {

    /**
     * 创建索引
     * @param idxName idxName
     * @param idxSql idxSql
     */
    void createIndex(String idxName,String idxSql);

    /***
     * 判断索引是否存在
     * @param idxName idxName
     * @return boolean
     * @throws Exception Exception
     */
    boolean isExistsIndex(String idxName) throws Exception;

    /***
     * 设置分片
     * @param request request
     */
    void buildSetting(CreateIndexRequest request);

    /***
     * insertOrUpdateOne
     * @param idxName idxName
     * @param elastic elastic
     */
    void insertOrUpdateOne(String idxName, Elastic<T> elastic);

    /***
     * insertBatch
     * @param idxName idxName
     * @param list list
     */
    void insertBatch(String idxName, List<Elastic<T>> list);

    /***
     * deleteBatch
     * @param idxName idxName
     * @param idList idList
     */
    void deleteBatch(String idxName, Collection<T> idList);

    /**
     * search
     * @param idxName idxName
     * @param builder builder
     * @param clazz clazz
     * @return List
     */
    List<T> search(String idxName, SearchSourceBuilder builder, Class<T> clazz);

    /***
     * deleteIndex
     * @param idxName idxName
     */
    void deleteIndex(String idxName);

    /***
     * deleteByQuery
     * @param idxName idxName
     * @param builder builder
     */
    void deleteByQuery(String idxName, QueryBuilder builder);

}