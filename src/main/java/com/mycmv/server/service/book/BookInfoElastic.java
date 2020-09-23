package com.mycmv.server.service.book;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.books.elastic.BookInfoEs;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface BookInfoElastic {

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BookInfoEs> pageList(BookInfoEs item, int pageIndex, int pageSize);

    /***
     * 列表
     * @param item item
     * @return
     */
    List<BookInfoEs> list(BookInfoEs item);

    /***
     * 添加
     * @param item item
     */
    void insert(BookInfoEs item);

    /***
     * 编辑
     * @param item item
     */
    void update(BookInfoEs item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<BookInfoEs> list);

    /***
     * 删除
     * @param list list
     * @return int
     */
    int delete(List<BookInfoEs> list);

}
