package com.mycmv.server.service.article;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.article.elastic.ArticleInfoEs;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface ArticleInfoElastic {

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<ArticleInfoEs> pageList(ArticleInfoEs item, int pageIndex, int pageSize);

    /***
     * 列表
     * @param item item
     * @return
     */
    List<ArticleInfoEs> list(ArticleInfoEs item);

    /***
     * 添加
     * @param item item
     */
    void insert(ArticleInfoEs item);

    /***
     * 编辑
     * @param item item
     */
    void update(ArticleInfoEs item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<ArticleInfoEs> list);

    /***
     * 删除
     * @param list list
     * @return int
     */
    int delete(List<ArticleInfoEs> list);

    /***
     * deleteByIds
     * @param ids ids
     * @return int
     */
    int deleteByIds(List<Long> ids);

}
