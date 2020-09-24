package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperSelectMapper;
import com.mycmv.server.model.exam.entry.PaperSelect;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperSelectService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * PageSelectService
 * @author a
 */
@Service
public class PaperSelectServiceImpl extends AbstractExamService<PaperSelect> implements PaperSelectService {

    @Resource
    private PaperSelectMapper pageSelectMapper;

    @Override
    public ExamInfoMapper<PaperSelect> getExamInfoMapper() {
        return pageSelectMapper;
    }
}
