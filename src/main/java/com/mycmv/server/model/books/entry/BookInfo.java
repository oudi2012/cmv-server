package com.mycmv.server.model.books.entry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import static com.mycmv.server.constants.CmvConstants.ES_ANALYZER_01;

/***
 * 书籍基类
 * @author oudi
 *
 */
@Data
public class BookInfo implements java.io.Serializable{

	@Id
	private Long bookId;
	/** 书名 */
	@Field(type = FieldType.Text, analyzer = ES_ANALYZER_01)
	private  String bookName;
	/** 简称 */
	@Field(type = FieldType.Text, analyzer = ES_ANALYZER_01)
	private  String shortName;
	/** 拼音 */
	@Field(type = FieldType.Text, analyzer = ES_ANALYZER_01)
	private  String pinYin;
	/** 出版社 */
	@Field(type = FieldType.Integer)
	private  Integer  publisher;
	/** 版本 */
	@Field(type = FieldType.Integer)
	private  Integer  version;
	/** 年份 */
	@Field(type = FieldType.Integer)
	private  int    theYear;
	/** 封面 */
	@Field(type = FieldType.Text)
	private  String coverImage;
	/** cip图片 */
	@Field(type = FieldType.Text)
	private  String cipImage;
	/** 卷册 1 上册 2 下册 */
	@Field(type = FieldType.Integer)
	private Integer  volume;
	/** 选修0和必修1 */
	@Field(type = FieldType.Integer)
	private Integer  elective;
	/** 科目 */
	@Field(type = FieldType.Integer)
	private Integer  subjectId;
	/** 年级 */
	@Field(type = FieldType.Integer)
	private Integer  gradeId;
	/** 创建时间 */
	@Field(type = FieldType.Long)
	private Long     createDate;
}
