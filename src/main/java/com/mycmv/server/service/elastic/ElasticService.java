package com.mycmv.server.service.elastic;

import com.mycmv.server.model.elastic.entry.Elastic;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import java.util.List;

/***
 * @author a
 */
public interface ElasticService {

    /**
     * 创建索引
     * @param clazz clazz
     */
    void createIndex(Class<?> clazz);

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
    void insertOrUpdateOne(String idxName, Elastic elastic);

    /***
     * insertBatch
     * @param idxName idxName
     * @param list list
     */
    void insertBatch(String idxName, List<Elastic> list);

    /***
     * deleteBatch
     * @param idxName idxName
     * @param idList idList
     */
    void deleteBatch(String idxName, List<Long> idList);

    /**
     * search
     * @param idxName idxName
     * @param builder builder
     * @param clazz clazz
     * @return List
     */
    <T> List<T> search(String idxName, SearchSourceBuilder builder, Class<T> clazz);

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
