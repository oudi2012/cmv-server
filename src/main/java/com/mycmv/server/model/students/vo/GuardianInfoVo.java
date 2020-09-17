package com.mycmv.server.model.students.vo;

import com.mycmv.server.model.students.entry.GuardianInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GuardianInfoVo extends GuardianInfo {
    private String roleName;
    private Integer province;
    private Integer city;
    private Integer town;
}
