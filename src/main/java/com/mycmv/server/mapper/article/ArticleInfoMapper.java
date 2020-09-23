package com.mycmv.server.mapper.article;


import com.mycmv.server.model.article.entry.ArticleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/***
 * @author a
 */
public interface ArticleInfoMapper {

    /***
     * 列表
     * @param item item
     * @return List
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
     * 添加
     * @param item item
     */
    void update(ArticleInfo item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list")List<ArticleInfo> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(@Param("idList") List<Long> idList);
}
