package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.HardLevelMapper;
import com.mycmv.server.model.exam.entry.HardLevel;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.HardLevelService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * HardLevelService
 * @author a
 */
@Service
public class HardLevelServiceImpl extends AbstractExamService<HardLevel> implements HardLevelService {

    @Resource
    private HardLevelMapper hardLevelMapper;

    @Override
    public ExamInfoMapper<HardLevel> getExamInfoMapper() {
        return hardLevelMapper;
    }
}
