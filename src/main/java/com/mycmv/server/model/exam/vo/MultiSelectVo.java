package com.mycmv.server.model.exam.vo;

import com.mycmv.server.model.exam.entry.MultiSelectQuestion;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MultiSelectVo extends MultiSelectQuestion {
    private String subjectName;
    private String gradeName;
    private List<SelectQuestionVo> selectQuestionVoList;
}
