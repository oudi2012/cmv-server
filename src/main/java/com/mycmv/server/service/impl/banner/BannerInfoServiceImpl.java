package com.mycmv.server.service.impl.banner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.mapper.banner.BannerInfoMapper;
import com.mycmv.server.model.banner.config.BannerType;
import com.mycmv.server.model.banner.config.TargetEnum;
import com.mycmv.server.model.banner.entry.Banner;
import com.mycmv.server.model.banner.entry.BannerCate;
import com.mycmv.server.model.banner.vo.BannerVo;
import com.mycmv.server.service.banner.BannerCateService;
import com.mycmv.server.service.banner.BannerInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author a
 */
@Service
public class BannerInfoServiceImpl implements BannerInfoService {

    @Resource
    private BannerInfoMapper bannerInfoMapper;
    @Resource
    private BannerCateService bannerCateService;

    @Override
    public List<Banner> list(Banner item) {
        return bannerInfoMapper.list(item);
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
    public PageInfo<Banner> pageList(Banner item, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Banner> list = bannerInfoMapper.list(item);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<BannerVo> pageListVo(Banner item, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Banner> list = bannerInfoMapper.list(item);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        PageInfo<Banner> bannerPageInfo = new PageInfo<>(list);
        PageInfo<BannerVo> bannerVoPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(bannerPageInfo, bannerVoPageInfo);
        Stream<Banner> bannerStream = list.stream();
        List<String> cateCodeList = bannerStream.map(Banner::getCateCode).collect(Collectors.toList());
        Map<String, BannerCate> bannerCateMap = bannerCateService.mapByCodes(cateCodeList);
        List<BannerVo> bannerVoList = new ArrayList<>();
        list.forEach(banner -> {
            BannerVo bannerVo = new BannerVo();
            BeanUtils.copyProperties(banner, bannerVo);
            if (bannerCateMap.containsKey(banner.getCateCode())) {
                bannerVo.setCateName(bannerCateMap.get(banner.getCateCode()).getCodeTitle());
            }
            if (!StringUtils.isEmpty(banner.getCntType())) {
                bannerVo.setCntTypeName(BannerType.getTitleByCode(banner.getCntType()));
            }
            if (!StringUtils.isEmpty(banner.getTarget())) {
                bannerVo.setTargetName(TargetEnum.getTitleByCode(banner.getTarget()));
            }
            bannerVoList.add(bannerVo);
        });
        bannerVoPageInfo.setList(bannerVoList);
        return bannerVoPageInfo;
    }
}
