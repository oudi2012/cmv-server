package com.mycmv.server.service.banner;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.banner.entry.BannerCate;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface BannerCateService {

    /***
     * 分页显示
     * @param t t
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BannerCate> pageList(BannerCate t, int pageIndex, int pageSize);

    /***
     * 列表
     * @param t t
     * @return
     */
    List<BannerCate> list(BannerCate t);

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    BannerCate findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(BannerCate item);

    /***
     * 编辑
     * @param item item
     */
    void update(BannerCate item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<BannerCate> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(List<Long> idList);

}
