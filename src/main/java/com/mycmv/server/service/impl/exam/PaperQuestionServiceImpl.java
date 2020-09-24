package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperQuestionMapper;
import com.mycmv.server.model.exam.entry.PaperQuestion;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperQuestionService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


/***
 * PageQuestionService
 * @author a
 */
@Service
public class PaperQuestionServiceImpl extends AbstractExamService<PaperQuestion> implements PaperQuestionService {

    @Resource
    private PaperQuestionMapper pageQuestionMapper;

    @Override
    public ExamInfoMapper<PaperQuestion> getExamInfoMapper() {
        return pageQuestionMapper;
    }
}
