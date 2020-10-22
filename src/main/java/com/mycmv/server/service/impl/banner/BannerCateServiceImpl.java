package com.mycmv.server.service.impl.banner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.mapper.banner.BannerCateMapper;
import com.mycmv.server.model.banner.entry.BannerCate;
import com.mycmv.server.model.banner.vo.BannerCateVo;
import com.mycmv.server.service.banner.BannerCateService;
import org.springframework.beans.BeanUtils;
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
    /*@Resource
    private AdminInfoService adminInfoService;*/

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
    public PageInfo<BannerCate> pageList(BannerCate item, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BannerCate> list = bannerCateMapper.list(item);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<BannerCateVo> pageListVo(BannerCate item, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<BannerCate> pageInfo = this.pageList(item, pageIndex, pageSize);
        if (CollectionUtils.isEmpty(pageInfo.getList())) {
            return new PageInfo<>();
        }
        List<Long> userIds = pageInfo.getList().stream().filter(a -> a.getUserId() != null).distinct().map(BannerCate::getUserId).collect(Collectors.toList());
        //Map<Long, AdminInfo> mapAdminList = adminInfoService.mapByUserIdList(userIds);
        PageInfo<BannerCateVo> pageVoInfo = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, pageVoInfo);
        pageVoInfo.setList(pageInfo.getList().stream().map(bannerCate -> {
            BannerCateVo bannerCateVo = new BannerCateVo();
            BeanUtils.copyProperties(bannerCate, bannerCateVo);
            /*if (mapAdminList.containsKey(bannerCate.getUserId())) {
                bannerCateVo.setUserName(mapAdminList.get(bannerCate.getUserId()).getUserName());
            }*/
            return bannerCateVo;
        }).collect(Collectors.toList()));
        return pageVoInfo;
    }
}
