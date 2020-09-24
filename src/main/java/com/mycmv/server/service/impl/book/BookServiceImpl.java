package com.mycmv.server.service.impl.book;

import com.mycmv.server.mapper.books.BookInfoMapper;
import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.model.books.entry.BookInfo;
import com.mycmv.server.service.book.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * 课本服务接口
 * @author a
 */
@Service
public class BookServiceImpl implements BookInfoService {

    @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> list(BookInfo t) {
        return bookInfoMapper.list(t);
    }

    @Override
    public BookInfo findById(int bookId) {
        return bookInfoMapper.findById(bookId);
    }

    @Override
    public void insert(BookInfo item) {
        bookInfoMapper.insert(item);
    }

    @Override
    public void update(BookInfo item) {
        bookInfoMapper.update(item);
    }

    @Override
    public void batchInsert(List<BookInfo> list) {
        bookInfoMapper.batchInsert(list);
    }

    @Override
    public int delete(List<Long> idList) {
        return bookInfoMapper.delete(idList);
    }

    @Override
    public PageInfo<BookInfo> pageList(BookInfo t, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BookInfo> list = bookInfoMapper.list(t);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<BookInfoEs> pageListEs(BookInfo item, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BookInfo> list = bookInfoMapper.list(item);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        PageInfo<BookInfo> bookInfoPageInfo = new PageInfo<>(list);
        PageInfo<BookInfoEs> bookInfoEsPageInfo = new PageInfo<>();
        List<BookInfoEs> bookInfoEsList = new ArrayList<>();
        bookInfoPageInfo.getList().forEach(bookInfo -> {
            BookInfoEs bookInfoEs = new BookInfoEs();
            BeanUtils.copyProperties(bookInfo, bookInfoEs);
            bookInfoEsList.add(bookInfoEs);
        });
        BeanUtils.copyProperties(bookInfoPageInfo, bookInfoEsPageInfo);
        bookInfoEsPageInfo.setList(bookInfoEsList);
        return bookInfoEsPageInfo;
    }
}
