package com.mycmv.server.model.article.entry;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String name;
    private Integer orderNo;
    private String href;
}
