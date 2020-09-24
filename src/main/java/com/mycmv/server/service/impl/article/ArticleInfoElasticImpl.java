package com.mycmv.server.service.impl.article;

import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.esmapper.ArticleInfoElasticMapper;
import com.mycmv.server.model.article.elastic.ArticleInfoEs;
import com.mycmv.server.service.InfoElasticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/***
 * @author a
 */
@Service("articleInfoElastic")
public class ArticleInfoElasticImpl implements InfoElasticService<ArticleInfoEs> {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.SYS_LOG);

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private ArticleInfoElasticMapper articleInfoElasticMapper;

    @Override
    public void createIndex(Class<ArticleInfoEs> clazz) {
        if (elasticsearchRestTemplate.indexExists(clazz)) {
            logger.error(" idxName={} 已经存在", clazz.getAnnotation(Document.class));
            return;
        }
        elasticsearchRestTemplate.createIndex(clazz);
        elasticsearchRestTemplate.putMapping(clazz);
    }

    @Override
    public boolean isExistsIndex(Class<ArticleInfoEs> clazz) {
        return elasticsearchRestTemplate.indexExists(clazz);
    }

    @Override
    public void insertOrUpdateOne(ArticleInfoEs item) {
        articleInfoElasticMapper.save(item);
    }

    @Override
    public void insertBatch(List<ArticleInfoEs> list) {
        articleInfoElasticMapper.saveAll(list);
    }

    @Override
    public int deleteBatch(List<ArticleInfoEs> list) {
        articleInfoElasticMapper.deleteAll(list);
        return list.size();
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            articleInfoElasticMapper.deleteById(id);
        }
        return ids.size();
    }

    @Override
    public Page<ArticleInfoEs> search(ArticleInfoEs item, Pageable pageable) {
        return articleInfoElasticMapper.search(getElasticQuery(item), pageable);
    }

    @Override
    public void deleteIndex(Class<ArticleInfoEs> clazz) {
        elasticsearchRestTemplate.deleteIndex(clazz);
    }

    @Override
    public void delete(ArticleInfoEs item) {
        articleInfoElasticMapper.delete(item);
    }
}
