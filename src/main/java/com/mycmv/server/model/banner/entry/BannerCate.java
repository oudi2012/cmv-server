package com.mycmv.server.model.banner.entry;

import lombok.Data;

/***
 * @author a
 */
@Data
public class BannerCate {
    private Long   id;
    private String cateCode;
    private String codeTitle;
    private Long   userId;
    private Integer orderNo;
    private Integer createDate;
}
