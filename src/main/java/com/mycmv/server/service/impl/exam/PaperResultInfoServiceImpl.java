package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperResultInfoMapper;
import com.mycmv.server.model.exam.entry.PaperResultInfo;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperResultInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * PageResultInfoService
 * @author a
 */
@Service
public class PaperResultInfoServiceImpl extends AbstractExamService<PaperResultInfo> implements PaperResultInfoService {

    @Autowired
    private PaperResultInfoMapper pageResultInfoMapper;

    @Override
    public ExamInfoMapper<PaperResultInfo> getExamInfoMapper() {
        return pageResultInfoMapper;
    }
}
