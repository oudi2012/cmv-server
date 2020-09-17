package com.mycmv.server.service.exam;

import com.mycmv.server.model.exam.entry.MultiSelectQuestion;
import com.mycmv.server.model.exam.vo.MultiSelectVo;
import java.util.List;

/***
 * SelectQuestion
 * @author oudi
 */
public interface MultiSelectService extends ExamService<MultiSelectQuestion> {

    /***
     * 格式化单条
     * @param multiSelectQuestion multiSelectQuestion
     * @return List
     */
    MultiSelectVo itemToVo(MultiSelectQuestion multiSelectQuestion);

    /***
     * 格式化列表
     * @param multiSelectQuestionList multiSelectQuestionList
     * @return List
     */
    List<MultiSelectVo> listToVo(List<MultiSelectQuestion> multiSelectQuestionList);

}
