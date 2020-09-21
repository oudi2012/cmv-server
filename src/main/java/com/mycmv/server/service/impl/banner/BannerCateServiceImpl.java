package com.mycmv.server.service.impl.banner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.mapper.banner.BannerCateMapper;
import com.mycmv.server.model.banner.entry.BannerCate;
import com.mycmv.server.service.banner.BannerCateService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/***
 * @author a
 */
@Service
public class BannerCateServiceImpl implements BannerCateService {

    @Resource
    private BannerCateMapper bannerInfoMapper;

    @Override
    public List<BannerCate> list(BannerCate t) {
        return bannerInfoMapper.list(t);
    }

    @Override
    public BannerCate findById(int bookId) {
        return bannerInfoMapper.findById(bookId);
    }

    @Override
    public void insert(BannerCate item) {
        bannerInfoMapper.insert(item);
    }

    @Override
    public void update(BannerCate item) {
        bannerInfoMapper.update(item);
    }

    @Override
    public void batchInsert(List<BannerCate> list) {
        bannerInfoMapper.batchInsert(list);
    }

    @Override
    public int delete(List<Long> idList) {
        return bannerInfoMapper.delete(idList);
    }

    @Override
    public PageInfo<BannerCate> pageList(BannerCate t, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BannerCate> list = bannerInfoMapper.list(t);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }

}
