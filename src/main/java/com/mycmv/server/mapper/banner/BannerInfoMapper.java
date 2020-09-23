package com.mycmv.server.mapper.banner;

import com.mycmv.server.model.banner.entry.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * ClassInfo
 * @author oudi
 */
@Mapper
public interface BannerInfoMapper {

    /***
     * 列表
     * @param t t
     * @return
     */
    List<Banner> list(Banner t);

    /***
     * 详细
     * @param id id
     * @return obj
     */
    Banner findById(int id);

    /***
     * 添加
     * @param item item
     */
    void insert(Banner item);

    /***
     * update
     * @param item item
     */
    void update(Banner item);

    /***
     * 批量添加
     * @param list list
     */
    void batchInsert(@Param("list") List<Banner> list);

    /***
     * 删除
     * @param idList idList
     * @return int
     */
    int delete(@Param("idList") List<Long> idList);
}
