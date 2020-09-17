package com.mycmv.server.service.html;

import com.mycmv.server.model.books.entry.BookInfo;

import java.util.List;

/***
 * 科目
 * @author oudi
 */
public interface HtmlSubjectService {

    /***
     * income
     * @param d
     * @return String
     */
    String synAccountIncome(int d);

    /***
     * outcome
     * @param d d
     */
    void synAccountOutcome(int d);

    /***
     * 获取课本信息
     * @param verType
     * @param subType
     * @return
     */
    List<? extends BookInfo> listSubjectInfo(String verType, String subType);
}
