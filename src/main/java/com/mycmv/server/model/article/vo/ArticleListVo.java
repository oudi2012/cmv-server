package com.mycmv.server.model.article.vo;

import com.mycmv.server.model.article.entry.ArticleInfo;
import lombok.Data;

import java.util.List;

/***
 * @author a
 */
@Data
public class ArticleListVo {
    private List<ArticleInfo> articleInfoList;
}
