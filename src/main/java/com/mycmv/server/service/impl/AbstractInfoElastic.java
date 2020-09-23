package com.mycmv.server.service.impl;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.ElasticInfo;
import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.model.books.elastic.BookInfoEsQuery;
import com.mycmv.server.service.InfoElastic;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * @author a
 */
public abstract class AbstractInfoElastic<T extends ElasticInfo> implements InfoElastic<T> {

    @Override
    public PageInfo<T> pageList(T item, int pageIndex, int pageSize) {
        PageInfo<T> pageInfo = new PageInfo<>();
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
    public List<T> list(T item) {
        return pageList(item, 1, 20).getList();
    }

    @Override
    public void insert(T item) {
        elasticService.insertOrUpdateOne(item);
    }

    @Override
    public void update(T item) {
        elasticService.insertOrUpdateOne(item);
    }

    @Override
    public void batchInsert(List<T> list) {
        elasticService.insertBatch(list);
    }

    @Override
    public int delete(List<T> list) {
        return elasticService.deleteBatch(list);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return elasticService.deleteByIds(ids);
    }

}
