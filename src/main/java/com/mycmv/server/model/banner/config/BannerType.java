package com.mycmv.server.model.banner.config;

/***
 * @author a
 */
public enum BannerType {
    /** 内容类型 */
    PIC("pic", "图片"),
    VIDEO("video", "视频");

    private final String code;
    private final String title;

    BannerType(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
