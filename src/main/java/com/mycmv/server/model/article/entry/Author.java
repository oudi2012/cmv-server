package com.mycmv.server.model.article.entry;

import lombok.Data;

@Data
public class Author {
    private Integer id;
    private String name;
    private Integer dynasty;
    private String tags;
    private String detail;
}
