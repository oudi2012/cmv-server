package com.mycmv.server.service.impl.book;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.service.book.BookInfoElastic;
import com.mycmv.server.service.elastic.ElasticService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;


/***
 * @author a
 */
@Service
public class BookInfoElasticImpl implements BookInfoElastic {

    @Resource
    private ElasticService<BookInfoEs> elasticService;

    @Override
    public PageInfo<BookInfoEs> pageList(BookInfoEs item, int pageIndex, int pageSize) {
        PageInfo<BookInfoEs> pageInfo = new PageInfo<>();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<BookInfoEs> bookInfoEsPage = elasticService.search(queryBuilder, pageable);
        if (!CollectionUtils.isEmpty(bookInfoEsPage.getContent())) {
            pageInfo.setTotal(bookInfoEsPage.getTotalElements());
            pageInfo.setList(bookInfoEsPage.getContent());
            pageInfo.setPageNum(pageIndex);
            pageInfo.setPageSize(pageSize);
            pageInfo.setPages(bookInfoEsPage.getTotalPages());
        }
        return pageInfo;
    }

    @Override
    public List<BookInfoEs> list(BookInfoEs item) {
        return null;
    }

    @Override
    public BookInfoEs findById(int bookId) {
        return null;
    }

    @Override
    public void insert(BookInfoEs item) {

    }

    @Override
    public void update(BookInfoEs item) {

    }

    @Override
    public void batchInsert(List<BookInfoEs> list) {

    }

    @Override
    public int delete(List<Long> idList) {
        return 0;
    }
}
