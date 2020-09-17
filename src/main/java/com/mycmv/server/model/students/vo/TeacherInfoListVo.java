package com.mycmv.server.model.students.vo;

import com.mycmv.server.model.students.entry.TeacherInfo;
import lombok.Data;

import java.util.List;

/***
 * @author a
 */
@Data
public class TeacherInfoListVo {
    private List<TeacherInfo> teacherInfoList;
}
