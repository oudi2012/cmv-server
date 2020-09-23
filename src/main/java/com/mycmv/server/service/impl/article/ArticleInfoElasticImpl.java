package com.mycmv.server.service.impl.article;

import com.github.pagehelper.PageInfo;
import com.mycmv.server.model.article.elastic.ArticleInfoEs;
import com.mycmv.server.model.article.elastic.ArticleInfoEsQuery;
import com.mycmv.server.service.article.ArticleInfoElastic;
import com.mycmv.server.service.elastic.ElasticService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;


/***
 * @author a
 */
@Service
public class ArticleInfoElasticImpl implements ArticleInfoElastic {

    @Resource
    private ElasticService<ArticleInfoEs> elasticService;

    @Override
    public PageInfo<ArticleInfoEs> pageList(ArticleInfoEs item, int pageIndex, int pageSize) {
        PageInfo<ArticleInfoEs> pageInfo = new PageInfo<>();
        ArticleInfoEsQuery articleInfoEsQuery = new ArticleInfoEsQuery();
        BeanUtils.copyProperties(item, articleInfoEsQuery);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<ArticleInfoEs> infoEsPage = elasticService.search(articleInfoEsQuery.getElasticQuery(), pageable);
        if (!CollectionUtils.isEmpty(infoEsPage.getContent())) {
            pageInfo.setTotal(infoEsPage.getTotalElements());
            pageInfo.setList(infoEsPage.getContent());
            pageInfo.setPageNum(pageIndex);
            pageInfo.setPageSize(pageSize);
            pageInfo.setPages(infoEsPage.getTotalPages());
        }
        return pageInfo;
    }

    @Override
    public List<ArticleInfoEs> list(ArticleInfoEs item) {
        return pageList(item, 1, 20).getList();
    }

    @Override
    public void insert(ArticleInfoEs item) {
        elasticService.insertOrUpdateOne(item);
    }

    @Override
    public void update(ArticleInfoEs item) {
        elasticService.insertOrUpdateOne(item);
    }

    @Override
    public void batchInsert(List<ArticleInfoEs> list) {
        elasticService.insertBatch(list);
    }

    @Override
    public int delete(List<ArticleInfoEs> list) {
        return elasticService.deleteBatch(list);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return elasticService.deleteByIds(ids);
    }
}
