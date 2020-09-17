package com.mycmv.server.model.students.vo;

import com.mycmv.server.model.students.entry.StudentInfo;
import lombok.Data;

import java.util.List;

/***
 * @author a
 */
@Data
public class StudentInfoListVo {
    private List<StudentInfo> studentInfoList;
}
