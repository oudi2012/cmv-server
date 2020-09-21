package com.mycmv.server.service.impl.book;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.books.entry.BookInfo;
import com.mycmv.server.service.book.BookInfoElastic;
import org.springframework.stereotype.Service;

import java.util.List;


/***
 * @author a
 */
@Service
public class BookInfoElasticImpl implements BookInfoElastic {

    @Override
    public PageInfo<BookInfo> pageList(BookInfo t, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public List<BookInfo> list(BookInfo t) {
        return null;
    }

    @Override
    public BookInfo findById(int bookId) {
        return null;
    }

    @Override
    public void insert(BookInfo item) {

    }

    @Override
    public void update(BookInfo item) {

    }

    @Override
    public void batchInsert(List<BookInfo> list) {

    }

    @Override
    public int delete(List<Long> idList) {
        return 0;
    }
}
