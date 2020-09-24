package com.mycmv.server.service.impl.article;

import com.mycmv.server.mapper.InfoElasticMapper;
import com.mycmv.server.mapper.article.ArticleInfoElasticMapper;
import com.mycmv.server.model.article.elastic.ArticleInfoEs;
import com.mycmv.server.service.impl.AbstractElasticServiceImpl;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/***
 * @author a
 */
@Service("articleInfoElastic")
public class ArticleInfoElasticImpl extends AbstractElasticServiceImpl<ArticleInfoEs> {

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private ArticleInfoElasticMapper articleInfoElasticMapper;

    @Override
    public ElasticsearchRestTemplate getElasticsearchRestTemplate() {
        return elasticsearchRestTemplate;
    }

    @Override
    public InfoElasticMapper<ArticleInfoEs, Long> getInfoElasticMapper() {
        return articleInfoElasticMapper;
    }
}
