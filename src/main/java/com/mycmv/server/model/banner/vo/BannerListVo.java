package com.mycmv.server.model.banner.vo;

import com.mycmv.server.model.banner.entry.Banner;
import lombok.Data;

import java.util.List;

/***
 * @author a
 */
@Data
public class BannerListVo {
    private List<Banner> bannerList;
}
