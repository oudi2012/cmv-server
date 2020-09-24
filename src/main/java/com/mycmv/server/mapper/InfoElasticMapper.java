package com.mycmv.server.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface InfoElasticMapper<T, Long> extends ElasticsearchRepository<T, Long> {
}
