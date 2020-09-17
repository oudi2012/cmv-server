package com.mycmv.server.service.exam;

import com.mycmv.server.model.exam.entry.SelectQuestionOption;

import java.util.List;
import java.util.Map;


/***
 * SelectQuestionOption
 * @author oudi
 */
public interface SelectQuestionOptionService extends ExamService<SelectQuestionOption> {

    /***
     * 获取列表
     * @param questionId questionId
     * @return List
     */
    List<SelectQuestionOption> listByQuestionId(Long questionId);

    /***
     * 获取列表
     * @param questionIdList questionIdList
     * @return List
     */
    List<SelectQuestionOption> listByQuestionIds(List<Long> questionIdList);

    /***
     * 获取列表
     * @param questionIdList questionIdList
     * @return Map
     */
    Map<Long, List<SelectQuestionOption>> mapByQuestionIds(List<Long> questionIdList);

    /***
     * 根据问题编号，删除选择项
     * @param questionId questionId
     * @return int
     */
    int deleteByQuestionId(Long questionId);
}
