package com.mycmv.server.service.student;

import com.mycmv.server.model.students.entry.GuardianInfo;
import com.mycmv.server.model.students.vo.GuardianStudentVo;

/***
 * 监护人
 * @author a
 */
public interface GuardianInfoService extends UserInfoService<GuardianInfo>{

    /***
     * 绑定监护人
     * @param guardianStudentVo guardianStudentVo
     * @return
     */
    int bindGuardianInfo(GuardianStudentVo guardianStudentVo);

}
