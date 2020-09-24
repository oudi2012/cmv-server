package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperUserMapper;
import com.mycmv.server.model.exam.entry.PaperUser;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * PageUserService
 * @author a
 */
@Service
public class PaperUserServiceImpl extends AbstractExamService<PaperUser> implements PaperUserService {

    @Resource
    private PaperUserMapper pageUserMapper;

    @Override
    public ExamInfoMapper<PaperUser> getExamInfoMapper() {
        return pageUserMapper;
    }
}
