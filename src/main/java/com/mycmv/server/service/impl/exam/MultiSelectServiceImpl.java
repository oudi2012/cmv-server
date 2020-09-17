package com.mycmv.server.service.impl.exam;

import com.mycmv.server.mapper.ExamInfoMapper;
import com.mycmv.server.mapper.exam.MultiSelectMapper;
import com.mycmv.server.model.books.entry.SubjectInfo;
import com.mycmv.server.model.exam.entry.MultiSelectQuestion;
import com.mycmv.server.model.exam.vo.MultiSelectVo;
import com.mycmv.server.model.exam.vo.SelectQuestionVo;
import com.mycmv.server.model.students.entry.GradeInfo;
import com.mycmv.server.service.book.SubjectInfoService;
import com.mycmv.server.service.exam.AbstractExamService;
import com.mycmv.server.service.exam.MultiSelectService;
import com.mycmv.server.service.exam.SelectQuestionService;
import com.mycmv.server.service.student.GradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/****
 * MultiSelectService
 * @author a
 */
@Service("multiSelectService")
public class MultiSelectServiceImpl extends AbstractExamService<MultiSelectQuestion> implements MultiSelectService {

    @Resource
    private MultiSelectMapper multiSelectMapper;
    @Resource
    private SelectQuestionService selectQuestionService;
    @Resource
    private SubjectInfoService subjectInfoService;
    @Resource
    private GradeService gradeService;

    @Override
    public ExamInfoMapper<MultiSelectQuestion> getExamInfoMapper() {
        return multiSelectMapper;
    }

    @Override
    public MultiSelectVo itemToVo(MultiSelectQuestion multiSelectQuestion) {
        SubjectInfo subjectInfo = subjectInfoService.findById(multiSelectQuestion.getSubjectId());
        GradeInfo gradeInfo = gradeService.findById(multiSelectQuestion.getGradeId());
        MultiSelectVo multiSelectVo = new MultiSelectVo();
        BeanUtils.copyProperties(multiSelectQuestion, multiSelectVo);
        multiSelectVo.setGradeName(gradeInfo.getName());
        multiSelectVo.setSubjectName(subjectInfo.getTitle());
        if (!CollectionUtils.isEmpty(multiSelectQuestion.getSelectQuestionList())) {
            List<SelectQuestionVo> selectQuestionVoList = selectQuestionService.listToVo(multiSelectQuestion.getSelectQuestionList());
            if (!CollectionUtils.isEmpty(selectQuestionVoList)) {
                multiSelectVo.setSelectQuestionVoList(selectQuestionVoList);
            }
        }
        return multiSelectVo;
    }

    @Override
    public List<MultiSelectVo> listToVo(List<MultiSelectQuestion> multiSelectQuestionList) {
        if (CollectionUtils.isEmpty(multiSelectQuestionList)) {
            return null;
        }
        return multiSelectQuestionList.stream().map(this::itemToVo).collect(Collectors.toList());
    }
}
