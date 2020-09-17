package com.mycmv.server.service.impl;

import com.mycmv.server.mapper.books.VersionTypeMapper;
import com.mycmv.server.model.books.entry.VersionType;
import com.mycmv.server.service.VersionTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wanghaikuo
 * @Date 2020/7/6
 **/
@Service
public class VersionTypeServiceImpl implements VersionTypeService {

    @Resource
    private VersionTypeMapper versionTypeMapper;

    @Override
    public PageInfo<VersionType> pageList(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" verId desc");
        List<VersionType> list = versionTypeMapper.list();
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }

    @Override
    public List<VersionType> list() {
        return versionTypeMapper.list();
    }

    @Override
    public VersionType findById(int id) {
        return versionTypeMapper.findById(id);
    }

    @Override
    public void insert(VersionType item) {
        versionTypeMapper.insert(item);
    }

    @Override
    public void update(VersionType item) {
        versionTypeMapper.update(item);
    }

    @Override
    public void batchInsert(List<VersionType> list) {
        versionTypeMapper.batchInsert(list);
    }

    @Override
    public int delete(List<Long> idList) {
        return versionTypeMapper.delete(idList);
    }
}
