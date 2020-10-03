package com.mycmv.server.model.banner.vo;

import com.mycmv.server.model.banner.entry.BannerCate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerCateVo extends BannerCate {
    private String userName;
}
