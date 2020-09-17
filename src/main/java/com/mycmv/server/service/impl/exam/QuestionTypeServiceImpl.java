package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.QuestionTypeMapper;
import com.mycmv.server.model.exam.entry.QuestionType;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * QuestionTypeService
 * @author a
 */
@Service
public class QuestionTypeServiceImpl extends AbstractExamService<QuestionType> implements QuestionTypeService {

    @Autowired
    private QuestionTypeMapper questionTypeMapper;

    @Override
    public ExamInfoMapper<QuestionType> getExamInfoMapper() {
        return questionTypeMapper;
    }
}
