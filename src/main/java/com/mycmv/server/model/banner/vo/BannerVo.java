package com.mycmv.server.model.banner.vo;

import com.mycmv.server.model.banner.entry.Banner;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BannerVo extends Banner {
    private String userName;
    private String cateName;
    private String cntTypeName;
    private String targetName;
    private String stateName;
}
