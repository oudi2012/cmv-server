package com.mycmv.server.service.exam;

import com.mycmv.server.model.exam.entry.SelectQuestion;
import com.mycmv.server.model.exam.vo.SelectQuestionVo;

import java.util.List;

/***
 * SelectQuestion
 * @author oudi
 */
public interface SelectQuestionService extends ExamService<SelectQuestion> {

    /***
     * 格式化单条
     * @param selectQuestion selectQuestion
     * @return List
     */
    SelectQuestionVo itemToVo(SelectQuestion selectQuestion);

    /***
     * 格式化列表
     * @param selectQuestionList selectQuestionList
     * @return List
     */
    List<SelectQuestionVo> listToVo(List<SelectQuestion> selectQuestionList);

    /***
     * 根据问题组编号，删除选择项
     * @param multiIds multiIds
     * @return int
     */
    int deleteByMultiIds(List<Long> multiIds);

}
