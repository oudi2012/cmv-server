package com.mycmv.server.service.impl.banner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.mapper.banner.BannerCateMapper;
import com.mycmv.server.model.banner.entry.BannerCate;
import com.mycmv.server.service.banner.BannerCateService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/***
 * @author a
 */
@Service
public class BannerCateServiceImpl implements BannerCateService {

    @Resource
    private BannerCateMapper bannerCateMapper;

    @Override
    public List<BannerCate> list(BannerCate item) {
        return bannerCateMapper.list(item);
    }

    @Override
    public List<BannerCate> listByCodes(List<String> cateCodes) {
        return bannerCateMapper.listByCodes(cateCodes);
    }

    @Override
    public Map<String, BannerCate> mapByCodes(List<String> cateCodes) {
        List<BannerCate> bannerCateList = listByCodes(cateCodes);
        if (CollectionUtils.isEmpty(bannerCateList)) {
            return new HashMap<>(0);
        }
        return bannerCateList.stream().collect(Collectors.toMap(BannerCate::getCateCode, Function.identity()));
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
