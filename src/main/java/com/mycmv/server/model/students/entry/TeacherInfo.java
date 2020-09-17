package com.mycmv.server.model.students.entry;

import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * TeacherInfo
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TeacherInfo extends UserInfo{
    /** 所属学校 */
    private Long schoolId;
}
