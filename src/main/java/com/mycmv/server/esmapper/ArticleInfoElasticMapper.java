package com.mycmv.server.esmapper;

import com.mycmv.server.model.article.elastic.ArticleInfoEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleInfoElasticMapper extends ElasticsearchRepository<ArticleInfoEs, Long> {
}
