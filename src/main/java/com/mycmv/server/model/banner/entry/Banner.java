package com.mycmv.server.model.banner.entry;

import lombok.Data;

/***
 * "businessId": 0,
 * "dateAdd": "2019-02-26 08:31:40",
 * "dateUpdate": "2020-01-07 08:19:29",
 * "id": 19180,
 * "paixu": 10,
 * "picUrl": "https://dcdn.it120.cc/2020/01/07/c3183558-55e8-4589-9ea7-81670004941a.jpg",
 * "status": 0,
 * "statusStr": "显示",
 * "title": "启动图1",
 * "type": "app",
 * "userId": 951
 * @author a
 */
@Data
public class Banner {
    private Long id;
    private String cateCode;
    private Long userId;
    private String title;
    /** 内容类型 */
    private String cntType;
    /** 目标 */
    private String target;
    /** 超链接 */
    private String href;
    /** 地址 */
    private String srcUrl;
    /** 状态 */
    private Integer state;
    private Integer orderNo;
    private Integer createDate;
}
