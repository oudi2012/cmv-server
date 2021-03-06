package com.mycmv.server.model.exam.entry;


import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author a
 * id, examPageId, score, userId, state, createTime
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PaperUser extends ExamBean {
    private Integer id;
    private Integer examPageId;
    private Long userId;
    private Integer score;
    private Integer state;
    private Integer createTime;
}
