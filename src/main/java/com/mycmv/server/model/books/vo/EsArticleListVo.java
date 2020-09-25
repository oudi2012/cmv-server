package com.mycmv.server.model.books.vo;

import com.mycmv.server.model.article.elastic.ArticleInfoEs;
import lombok.Data;

import java.util.List;

/**
 * @author a
 */
@Data
public class EsArticleListVo {
    private List<ArticleInfoEs> articleInfoEsList;
}
