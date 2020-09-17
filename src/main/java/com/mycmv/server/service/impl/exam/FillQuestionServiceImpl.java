package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.FillQuestionMapper;
import com.mycmv.server.model.exam.entry.FillQuestion;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.FillQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * FillQuestionService
 * @author a
 */
@Service
public class FillQuestionServiceImpl extends AbstractExamService<FillQuestion> implements FillQuestionService {

    @Autowired
    private FillQuestionMapper fillQuestionMapper;

    @Override
    public ExamInfoMapper<FillQuestion> getExamInfoMapper() {
        return fillQuestionMapper;
    }
}
