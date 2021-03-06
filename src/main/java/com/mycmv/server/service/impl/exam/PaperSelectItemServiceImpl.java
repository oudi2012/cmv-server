package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.PaperSelectItemMapper;
import com.mycmv.server.model.exam.entry.PaperSelectItem;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.PaperSelectItemService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 * PageSelectItemService
 * @author a
 */
@Service
public class PaperSelectItemServiceImpl extends AbstractExamService<PaperSelectItem> implements PaperSelectItemService {

    @Resource
    private PaperSelectItemMapper pageSelectItemMapper;

    @Override
    public ExamInfoMapper<PaperSelectItem> getExamInfoMapper() {
        return pageSelectItemMapper;
    }
}
