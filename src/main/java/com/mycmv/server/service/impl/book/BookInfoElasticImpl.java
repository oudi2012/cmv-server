package com.mycmv.server.service.impl.book;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.model.books.elastic.BookInfoEsQuery;
import com.mycmv.server.service.book.BookInfoElastic;
import com.mycmv.server.service.elastic.ElasticService;
import org.springframework.beans.BeanUtils;
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
        BookInfoEsQuery bookInfoEsQuery = new BookInfoEsQuery();
        BeanUtils.copyProperties(item, bookInfoEsQuery);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<BookInfoEs> bookInfoEsPage = elasticService.search(bookInfoEsQuery.getBookInfoEsQuery(), pageable);
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
        return pageList(item, 1, 20).getList();
    }

    @Override
    public void insert(BookInfoEs item) {
        elasticService.insertOrUpdateOne(item);
    }

    @Override
    public void update(BookInfoEs item) {
        elasticService.insertOrUpdateOne(item);
    }

    @Override
    public void batchInsert(List<BookInfoEs> list) {
        elasticService.insertBatch(list);
    }

    @Override
    public int delete(List<BookInfoEs> list) {
        return elasticService.deleteBatch(list);
    }
}
