package com.mycmv.server.mapper.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.model.exam.entry.SelectQuestionOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * SelectQuestionOption
 * @author oudi
 */
public interface SelectQuestionOptionMapper extends ExamInfoMapper<SelectQuestionOption> {

    /***
     * 获取列表
     * @param questionId questionId
     * @return List
     */
    List<SelectQuestionOption> listByQuestionId(Long questionId);

    /***
     * 获取列表
     * @param questionIds questionIds
     * @return List
     */
    List<SelectQuestionOption> listByQuestionIds(@Param("idList") List<Long> questionIds);

    /***
     * 根据问题编号，删除选择项
     * @param questionId questionId
     * @return int
     */
    int deleteByQuestionId(Long questionId);
}
