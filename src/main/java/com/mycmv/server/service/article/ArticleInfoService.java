package com.mycmv.server.service.article;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.article.entry.ArticleInfo;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface ArticleInfoService {

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<ArticleInfo> pageList(ArticleInfo item, int pageIndex, int pageSize);

    /***
     * 列表
     * @param item item
     * @return
     */
    List<ArticleInfo> list(ArticleInfo item);

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    ArticleInfo findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(ArticleInfo item);

    /***
     * 编辑
     * @param item item
     */
    void update(ArticleInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<ArticleInfo> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(List<Long> idList);

}
