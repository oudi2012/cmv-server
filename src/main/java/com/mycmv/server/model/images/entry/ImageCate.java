package com.mycmv.server.model.images.entry;

import lombok.Data;

/**
 * 图片业务类型
 * @author wanghaikuo
 * @date 2020/6/26
 **/
@Data
public class ImageCate {
    private Integer cateId;
    private String name;
    private Integer type;
}