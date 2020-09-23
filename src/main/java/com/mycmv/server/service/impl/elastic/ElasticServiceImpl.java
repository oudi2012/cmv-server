package com.mycmv.server.service.impl.elastic;

import com.alibaba.fastjson.JSON;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.model.elastic.entry.Elastic;
import com.mycmv.server.service.elastic.ElasticService;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @author a
 */
@Service
public class ElasticServiceImpl implements ElasticService {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.SYS_LOG);

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Override
    public void createIndex(Class<?> clazz) {
        if (elasticsearchRestTemplate.indexExists(clazz)) {
            logger.error(" idxName={} 已经存在",clazz.getAnnotation(Document.class));
            return;
        }
        elasticsearchRestTemplate.createIndex(clazz);
        elasticsearchRestTemplate.putMapping(clazz);
    }

    @Override
    public boolean isExistsIndex(String idxName) throws Exception {
        return elasticsearchRestTemplate.indexExists(idxName);
    }

    @Override
    public void buildSetting(CreateIndexRequest request) {
        request.settings(Settings.builder().put("index.number_of_shards",3)
                .put("index.number_of_replicas",2));
    }

    @Override
    public void insertOrUpdateOne(String idxName, Elastic elastic) {
        IndexRequest request = new IndexRequest(idxName);
        logger.error("Data : id={},entity={}",elastic.getId(), JSON.toJSONString(elastic.getData()));
        request.id(elastic.getId());
        request.source(elastic.getData(), XContentType.JSON);
        try {
            restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void insertBatch(String idxName, List<Elastic> list) {
        BulkRequest request = new BulkRequest();
        list.forEach(item -> request.add(new IndexRequest(idxName).id(item.getId())
                .source(item.getData(), XContentType.JSON)));
        try {
            restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBatch(String idxName, List<Long> idList) {
        BulkRequest request = new BulkRequest();
        idList.forEach(item -> request.add(new DeleteRequest(idxName, item.toString())));
        try {
            restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> search(String idxName, SearchSourceBuilder builder, Class<T> clazz) {
        SearchRequest request = new SearchRequest(idxName);
        request.source(builder);
        try {
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            List<T> res = new ArrayList<>(hits.length);
            for (SearchHit hit : hits) {
                res.add(JSON.parseObject(hit.getSourceAsString(), clazz));
            }
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteIndex(String idxName) {
        try {
            if (elasticsearchRestTemplate.indexExists(idxName)) {
                logger.error(" idxName={} 已经存在",idxName);
                return;
            }
            restHighLevelClient.indices().delete(new DeleteIndexRequest(idxName), RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByQuery(String idxName, QueryBuilder builder) {
        DeleteByQueryRequest request = new DeleteByQueryRequest(idxName);
        request.setQuery(builder);
        //设置批量操作数量,最大为10000
        request.setBatchSize(10000);
        request.setConflicts("proceed");
        try {
            restHighLevelClient.deleteByQuery(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
