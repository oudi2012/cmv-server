package com.mycmv.server.service.banner;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.banner.entry.BannerCate;
import com.mycmv.server.model.banner.vo.BannerCateVo;

import java.util.List;
import java.util.Map;

/***
 * 课本接口
 * @author oudi
 */
public interface BannerCateService {

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BannerCate> pageList(BannerCate item, int pageIndex, int pageSize);

    /***
     * 分页显示
     * @param item item
     * @param pageIndex pageIndex
     * @param pageSize pageSize
     * @return PageInfo
     */
    PageInfo<BannerCateVo> pageListVo(BannerCate item, int pageIndex, int pageSize);

    /***
     * 列表
     * @param item item
     * @return List
     */
    List<BannerCate> list(BannerCate item);

    /***
     * 根据类别编号，获取类型
     * @param cateCodes cateCodes
     * @return List
     */
    List<BannerCate> listByCodes(List<String> cateCodes);

    /***
     * 根据类别编号，获取类型
     * @param cateCodes cateCodes
     * @return Map
     */
    Map<String, BannerCate> mapByCodes(List<String> cateCodes);

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
