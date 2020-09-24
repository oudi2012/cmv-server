package com.mycmv.server.esmapper;

import com.mycmv.server.model.books.elastic.BookInfoEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookInfoElasticMapper extends ElasticsearchRepository<BookInfoEs, Long> {
}
