package com.mycmv.server.service.impl.banner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.mapper.banner.BannerInfoMapper;
import com.mycmv.server.model.banner.entry.Banner;
import com.mycmv.server.service.banner.BannerInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/***
 * @author a
 */
@Service
public class BannerInfoServiceImpl implements BannerInfoService {

    @Resource
    private BannerInfoMapper bannerInfoMapper;

    @Override
    public List<Banner> list(Banner t) {
        return bannerInfoMapper.list(t);
    }

    @Override
    public Banner findById(int bookId) {
        return bannerInfoMapper.findById(bookId);
    }

    @Override
    public void insert(Banner item) {
        bannerInfoMapper.insert(item);
    }

    @Override
    public void update(Banner item) {
        bannerInfoMapper.update(item);
    }

    @Override
    public void batchInsert(List<Banner> list) {
        bannerInfoMapper.batchInsert(list);
    }

    @Override
    public int delete(List<Long> idList) {
        return bannerInfoMapper.delete(idList);
    }

    @Override
    public PageInfo<Banner> pageList(Banner t, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Banner> list = bannerInfoMapper.list(t);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }
}
