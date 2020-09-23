package com.mycmv.server.model.books.elastic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.util.StringUtils;

/***
 * @author a
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookInfoEsQuery extends BookInfoEs {

    public BoolQueryBuilder getBookInfoEsQuery() {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (null != getBookId()) {
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("bookId", getBookId()));
        }
        if (!StringUtils.isEmpty(getBookName())) {
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("bookName", getBookName()));
        }
        if (!StringUtils.isEmpty(getShortName())) {
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("shortName", getShortName()));
        }
        if (!StringUtils.isEmpty(getPinYin())) {
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("pinYin", getPinYin()));
        }
        return boolQueryBuilder;
    }

}
