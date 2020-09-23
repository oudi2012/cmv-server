package com.mycmv.server.model.article.vo;

import com.mycmv.server.model.article.entry.ArticleInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleInfoVo extends ArticleInfo {

    @Field(type = FieldType.Text)
    private String cateName;

}
