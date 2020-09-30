package com.mycmv.server.service.banner;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.banner.entry.Banner;
import com.mycmv.server.model.banner.vo.BannerVo;

import java.util.List;

/***
 * 课本接口
 * @author oudi
 */
public interface BannerInfoService {

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<Banner> pageList(Banner item, int pageIndex, int pageSize);

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BannerVo> pageListVo(Banner item, int pageIndex, int pageSize);

    /***
     * 列表
     * @param t t
     * @return
     */
    List<Banner> list(Banner t);

    /***
     * 详细
     * @param bookId id
     * @return obj
     */
    Banner findById(int bookId);

    /***
     * 添加
     * @param item item
     */
    void insert(Banner item);

    /***
     * 编辑
     * @param item item
     */
    void update(Banner item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(List<Banner> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(List<Long> idList);

}
