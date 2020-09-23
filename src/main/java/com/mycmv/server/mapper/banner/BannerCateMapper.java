package com.mycmv.server.mapper.banner;

import com.mycmv.server.model.banner.entry.BannerCate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
@Mapper
public interface BannerCateMapper {

    /***
     * 列表
     * @return List
     */
    List<BannerCate> list(BannerCate t);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    BannerCate findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(BannerCate item);

    /***
     * update
     * @param item item
     */
    void update(BannerCate item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list") List<BannerCate> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(@Param("idList") List<Long> idList);
}
