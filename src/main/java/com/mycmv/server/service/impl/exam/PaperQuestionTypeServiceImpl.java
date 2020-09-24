package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperQuestionTypeMapper;
import com.mycmv.server.model.exam.entry.PaperQuestionType;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperQuestionTypeService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


/***
 * PageQuestionTypeService
 * @author a
 */
@Service
public class PaperQuestionTypeServiceImpl extends AbstractExamService<PaperQuestionType> implements PaperQuestionTypeService {

    @Resource
    private PaperQuestionTypeMapper pageQuestionTypeMapper;

    @Override
    public ExamInfoMapper<PaperQuestionType> getExamInfoMapper() {
        return pageQuestionTypeMapper;
    }
}
