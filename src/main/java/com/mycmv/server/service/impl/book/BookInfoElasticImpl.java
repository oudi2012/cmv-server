package com.mycmv.server.service.impl.book;

import com.mycmv.server.mapper.InfoElasticMapper;
import com.mycmv.server.mapper.books.BookInfoElasticMapper;
import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.service.impl.AbstractElasticServiceImpl;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/***
 * @author a
 */
@Service("bookInfoElastic")
public class BookInfoElasticImpl extends AbstractElasticServiceImpl<BookInfoEs> {

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Resource
    private BookInfoElasticMapper bookInfoElasticMapper;

    @Override
    public ElasticsearchRestTemplate getElasticsearchRestTemplate() {
        return elasticsearchRestTemplate;
    }

    @Override
    public InfoElasticMapper<BookInfoEs, Long> getInfoElasticMapper() {
        return bookInfoElasticMapper;
    }
}
