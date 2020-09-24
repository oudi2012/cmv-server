package com.mycmv.server.service.book;

import com.mycmv.server.model.books.elastic.BookInfoEs;
import com.mycmv.server.model.books.entry.BookInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface BookInfoService {

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BookInfo> pageList(BookInfo item, int pageIndex, int pageSize);

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BookInfoEs> pageListEs(BookInfo item, int pageIndex, int pageSize);

    /***
     * 列表
     * @param item item
     * @return
     */
    List<BookInfo> list(BookInfo item);

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    BookInfo findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(BookInfo item);

    /***
     * 编辑
     * @param item item
     */
    void update(BookInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<BookInfo> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(List<Long> idList);

}
