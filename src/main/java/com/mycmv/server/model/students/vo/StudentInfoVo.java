package com.mycmv.server.model.students.vo;

import com.mycmv.server.model.students.entry.StudentInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentInfoVo extends StudentInfo {
    private Integer province;
    private Integer city;
    private Integer town;
}
