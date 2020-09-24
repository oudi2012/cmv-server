package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.FillQuestionOptionMapper;
import com.mycmv.server.model.exam.entry.FillQuestionOption;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.FillQuestionOptionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


/***
 * @author a
 */
@Service
public class FillQuestionOptionServiceImpl extends AbstractExamService<FillQuestionOption> implements FillQuestionOptionService {

    @Resource
    private FillQuestionOptionMapper fillQuestionOptionMapper;

    @Override
    public ExamInfoMapper<FillQuestionOption> getExamInfoMapper() {
        return fillQuestionOptionMapper;
    }
}
