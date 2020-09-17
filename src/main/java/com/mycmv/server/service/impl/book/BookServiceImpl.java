package com.mycmv.server.service.impl.book;

import com.mycmv.server.mapper.books.BookInfoMapper;
import com.mycmv.server.model.books.entry.BookInfo;
import com.mycmv.server.service.book.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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
}
