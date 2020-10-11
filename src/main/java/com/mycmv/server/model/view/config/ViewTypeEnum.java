package com.mycmv.server.model.view.config;


/***
 * @author a
 */
public enum ViewTypeEnum {

    PHONE(10, ""),
    PAD(20, ""),
    (),
    PHONE();

    private final int code;
    private final String name;

    ViewTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ViewTypeEnum getByCode(int code) {
        for (ViewTypeEnum item : ViewTypeEnum.values()) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }

}
