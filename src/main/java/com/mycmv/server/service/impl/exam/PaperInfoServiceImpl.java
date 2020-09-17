package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperInfoMapper;
import com.mycmv.server.model.exam.entry.PaperInfo;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/***
 * @author a
 */
@Service
public class PaperInfoServiceImpl extends AbstractExamService<PaperInfo> implements PaperInfoService {

    @Resource
    private PaperInfoMapper paperInfoMapper;

    @Override
    public ExamInfoMapper<PaperInfo> getExamInfoMapper() {
        return paperInfoMapper;
    }
}
