package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.QuestionTypeMapper;
import com.mycmv.server.model.exam.entry.QuestionType;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.QuestionTypeService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * QuestionTypeService
 * @author a
 */
@Service
public class QuestionTypeServiceImpl extends AbstractExamService<QuestionType> implements QuestionTypeService {

    @Resource
    private QuestionTypeMapper questionTypeMapper;

    @Override
    public ExamInfoMapper<QuestionType> getExamInfoMapper() {
        return questionTypeMapper;
    }
}
