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
    private BannerCateMapper bannerCateMapper;

    @Override
    public List<BannerCate> list(BannerCate t) {
        return bannerCateMapper.list(t);
    }

    @Override
    public BannerCate findById(int bookId) {
        return bannerCateMapper.findById(bookId);
    }

    @Override
    public void insert(BannerCate item) {
        bannerCateMapper.insert(item);
    }

    @Override
    public void update(BannerCate item) {
        bannerCateMapper.update(item);
    }

    @Override
    public void batchInsert(List<BannerCate> list) {
        bannerCateMapper.batchInsert(list);
    }

    @Override
    public int delete(List<Long> idList) {
        return bannerCateMapper.delete(idList);
    }

    @Override
    public PageInfo<BannerCate> pageList(BannerCate t, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BannerCate> list = bannerCateMapper.list(t);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }

}
