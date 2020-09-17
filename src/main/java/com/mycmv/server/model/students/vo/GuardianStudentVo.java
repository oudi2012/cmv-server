package com.mycmv.server.model.students.vo;


import com.mycmv.server.model.students.entry.GuardianInfo;
import com.mycmv.server.model.students.entry.StudentInfo;
import lombok.Data;

/***
 * @author a
 */
@Data
public class GuardianStudentVo {
    private GuardianInfo guardianInfo;
    private StudentInfo studentInfo;
}
