package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.AskQuestionOptionMapper;
import com.mycmv.server.model.exam.entry.AskQuestionOption;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.AskQuestionOptionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * AskQuestionOptionService
 * @author a
 */
@Service
public class AskQuestionOptionServiceImpl extends AbstractExamService<AskQuestionOption> implements AskQuestionOptionService {

    @Resource
    private AskQuestionOptionMapper askQuestionOptionMapper;

    @Override
    public ExamInfoMapper<AskQuestionOption> getExamInfoMapper() {
        return askQuestionOptionMapper;
    }
}
