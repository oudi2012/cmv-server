package com.mycmv.server.service.impl.userlog;

import com.alibaba.fastjson.JSON;
import com.mycmv.server.constants.LogConstants;
import com.mycmv.server.mapper.userlogs.HomeWorkMapper;
import com.mycmv.server.model.userlogs.entry.HomeWork;
import com.mycmv.server.service.userlog.HomeWorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/***
 * @author a
 */
@Service
public class HomeWorkServiceImpl implements HomeWorkService {

    private static final Logger logger = LoggerFactory.getLogger(LogConstants.OPE_LOG);

    private static final String LOG_LIST_PARAM = "list param {},{},{}";
    private static final String LOG_LIST_RESULT = "list result {}";
    private static final String LOG_FIND_ID = "findById param {}";
    private static final String LOG_FIND_ID_RESULT = "findById result {}";
    private static final String LOG_FIND_PHONE = "findByPhone param {}";
    private static final String LOG_FIND_PHONE_RESULT = "findByPhone result {}";
    private static final String LOG_FIND_USERNAME = "userName param {}";
    private static final String LOG_FIND_USERNAME_RESULT = "userName result {}";
    private static final String LOG_INSERT = "insert param {}";
    private static final String LOG_INSERT_LIST = "batchInsert param {}";
    private static final String LOG_EDIT = "edit param {}";
    private static final String LOG_REMOVE = "delete param {}";

    @Autowired
    private HomeWorkMapper termMapper;

    @Override
    public PageInfo<HomeWork> list(HomeWork termInfo, int pageIndex, int pageSize) {
        logger.info(LOG_LIST_PARAM, JSON.toJSONString(termInfo), pageIndex, pageSize);
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" homeWorkId desc");
        List<HomeWork> termTeachersList = termMapper.list(termInfo);
        logger.info(LOG_LIST_RESULT, JSON.toJSONString(termTeachersList));
        if (CollectionUtils.isEmpty(termTeachersList)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(termTeachersList);
    }

    @Override
    public HomeWork findById(int id) {
        logger.info(LOG_FIND_ID, id);
        return termMapper.findById(id);
    }

    @Override
    public void insert(HomeWork termInfo) {
        logger.info(LOG_INSERT, JSON.toJSONString(termInfo));
        termMapper.insert(termInfo);
    }

    @Override
    public void batchInsert(List<HomeWork> list) {
        logger.info(LOG_INSERT, JSON.toJSONString(list));
        termMapper.batchInsert(list);
    }

}
