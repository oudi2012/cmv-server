package com.mycmv.server.service.impl.exam;


import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.AskQuestionMapper;
import com.mycmv.server.model.exam.entry.AskQuestion;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.AskQuestionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * AskQuestionService
 * @author a
 */
@Service
public class AskQuestionServiceImpl extends AbstractExamService<AskQuestion> implements AskQuestionService {

    @Resource
    private AskQuestionMapper askQuestionMapper;

    @Override
    public ExamInfoMapper<AskQuestion> getExamInfoMapper() {
        return askQuestionMapper;
    }
}
