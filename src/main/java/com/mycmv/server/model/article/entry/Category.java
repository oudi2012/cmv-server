package com.mycmv.server.model.article.entry;

import lombok.Data;

/**
 * @author a
 */
@Data
public class Category {
    private Integer id;
    private String name;
    private Integer orderNo;
    private String href;
}
