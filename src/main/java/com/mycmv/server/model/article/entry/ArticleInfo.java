package com.mycmv.server.model.article.entry;

import com.mycmv.server.model.ElasticInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

import static com.mycmv.server.constants.CmvConstants.ES_ANALYZER_01;

/***
 * 文章
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ArticleInfo extends ElasticInfo {
    @Id
    private Long id;
    @Field(type = FieldType.Text, analyzer = ES_ANALYZER_01)
    private String title;
    @Field(type = FieldType.Text, analyzer = ES_ANALYZER_01)
    private String author;
    @Field(type = FieldType.Text, analyzer = ES_ANALYZER_01)
    private String content;
    @Field(type = FieldType.Long)
    private Long userId;
    @Field(type = FieldType.Long)
    private Long cateId;
    @Field(type = FieldType.Text)
    private String tags;
    @Field(type = FieldType.Date)
    private Date createDate;
    @Field(type = FieldType.Integer)
    private Integer dynasty;
    @Field(type = FieldType.Integer)
    private Integer grade;
    @Field(type = FieldType.Integer)
    private Integer styleId;
    /** 排序编号 */
    @Field(type = FieldType.Integer)
    private Integer orderNo;
    /** 收藏次数 */
    @Field(type = FieldType.Integer)
    private Integer totalCollect;
    /** 点赞次数 */
    @Field(type = FieldType.Integer)
    private Integer totalZan;
    /** 评论条数 */
    @Field(type = FieldType.Integer)
    private Integer totalComment;
    private String href;
}
