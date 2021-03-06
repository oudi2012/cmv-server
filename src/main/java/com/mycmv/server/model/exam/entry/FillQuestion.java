package com.mycmv.server.model.exam.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author a
 * 填空题
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FillQuestion extends ExamBean {
    private Integer id;
    private String title;
    private Integer subjectId;
    private Integer gradeId;
    private String examScope;
    private Long creatorId;
    private String answers;
    private Integer createTime;
    private Integer updateTime;
}
