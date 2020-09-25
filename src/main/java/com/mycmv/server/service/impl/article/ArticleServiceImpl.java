package com.mycmv.server.service.impl.article;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mycmv.server.mapper.article.ArticleInfoMapper;
import com.mycmv.server.model.article.entry.ArticleInfo;
import com.mycmv.server.service.article.ArticleInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/***
 * 课本服务接口
 * @author a
 */
@Service
public class ArticleServiceImpl implements ArticleInfoService {

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleInfo> list(ArticleInfo item) {
        return articleInfoMapper.list(item);
    }

    @Override
    public ArticleInfo findById(int bookId) {
        return articleInfoMapper.findById(bookId);
    }

    @Override
    public void insert(ArticleInfo item) {
        articleInfoMapper.insert(item);
    }

    @Override
    public void update(ArticleInfo item) {
        articleInfoMapper.update(item);
    }

    @Override
    public void batchInsert(List<ArticleInfo> list) {
        articleInfoMapper.batchInsert(list);
    }

    @Override
    public int delete(List<Long> idList) {
        return articleInfoMapper.delete(idList);
    }

    @Override
    public PageInfo<ArticleInfo> pageList(ArticleInfo t, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize).setOrderBy(" id desc ");
        List<ArticleInfo> list = articleInfoMapper.list(t);
        if (CollectionUtils.isEmpty(list)) {
            return new PageInfo<>();
        }
        return new PageInfo<>(list);
    }
}
