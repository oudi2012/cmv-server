package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperProctorMapper;
import com.mycmv.server.model.exam.entry.PaperProctor;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperProctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageProctorService
 * @author a
 */
@Service
public class PaperProctorServiceImpl extends AbstractExamService<PaperProctor> implements PaperProctorService {

    @Autowired
    private PaperProctorMapper pageProctorMapper;

    @Override
    public ExamInfoMapper<PaperProctor> getExamInfoMapper() {
        return pageProctorMapper;
    }
}
