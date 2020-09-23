package com.mycmv.server.model.books.elastic;

import com.mycmv.server.model.books.entry.BookInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(indexName = "book_info", type = "doc")
public class BookInfoEs extends BookInfo {

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private  String   publisherName;
    /** 卷册 1 上册 2 下册 */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private  String  volumeName;
    /** 选修0和必修1 */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private  String   electiveName;
    /** 科目 */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private  String   subjectName;
    /** 年级 */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private  String   gradeName;
}
