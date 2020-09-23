package com.mycmv.server.model.article.elastic;

import com.mycmv.server.model.article.vo.ArticleInfoVo;
import org.springframework.data.elasticsearch.annotations.Document;


/***
 * @author a
 */
@Document(indexName = "article_info", type = "doc")
public class ArticleInfoEs extends ArticleInfoVo {
}
