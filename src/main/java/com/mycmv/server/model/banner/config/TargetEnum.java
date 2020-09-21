package com.mycmv.server.model.banner.config;

/***
 * @author a
 */
public enum TargetEnum {
    /** 全部 */
    ALL("all", "全部"),
    WECHAT("wechat", "微信小程序"),
    APP("app", "app");

    private final String code;
    private final String title;

    TargetEnum(String code, String title) {
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
