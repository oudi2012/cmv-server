package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.SelectQuestionOptionMapper;
import com.mycmv.server.model.exam.entry.SelectQuestionOption;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.SelectQuestionOptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * SelectQuestionOptionService
 * @author a
 */
@Service
public class SelectQuestionOptionServiceImpl extends AbstractExamService<SelectQuestionOption> implements SelectQuestionOptionService {

    @Resource
    private SelectQuestionOptionMapper questionOptionMapper;

    @Override
    public ExamInfoMapper<SelectQuestionOption> getExamInfoMapper() {
        return questionOptionMapper;
    }

    @Override
    public List<SelectQuestionOption> listByQuestionId(Long questionId) {
        return questionOptionMapper.listByQuestionId(questionId);
    }

    @Override
    public List<SelectQuestionOption> listByQuestionIds(List<Long> questionIdList) {
        return questionOptionMapper.listByQuestionIds(questionIdList);
    }

    @Override
    public Map<Long, List<SelectQuestionOption>> mapByQuestionIds(List<Long> questionIdList) {
        return questionOptionMapper.listByQuestionIds(questionIdList).stream().collect(Collectors.groupingBy(SelectQuestionOption::getQuestionId));
    }

    @Override
    public int deleteByQuestionId(Long questionId) {
        return questionOptionMapper.deleteByQuestionId(questionId);
    }
}
