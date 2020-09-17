package com.mycmv.server.model.students.vo;

import com.mycmv.server.model.students.entry.GuardianInfo;
import lombok.Data;

import java.util.List;

/***
 * @author a
 */
@Data
public class GuardianInfoListVo {
    private List<GuardianInfo> guardianInfoList;
}
