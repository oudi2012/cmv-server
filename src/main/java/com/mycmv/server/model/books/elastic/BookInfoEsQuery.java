package com.mycmv.server.model.books.elastic;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

import static com.mycmv.server.constants.CmvConstants.ES_ANALYZER_01;

/***
 * @author a
 */
public class BookInfoEsQuery extends BookInfoEs {

    /***
     * 获取 BoolQueryBuilder
     * @return BoolQueryBuilder
     */
    public BoolQueryBuilder getBookInfoEsQuery() {
        Field[] arrField = this.getClass().getDeclaredFields();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        try {
            for (Field field : arrField) {
                field.setAccessible(true);
                org.springframework.data.elasticsearch.annotations.Field antField =
                        field.getAnnotation(org.springframework.data.elasticsearch.annotations.Field.class);
                if (antField.type().equals(FieldType.Text)) {
                    if (!StringUtils.isEmpty(field.get(this))) {
                        if (antField.analyzer().equals(ES_ANALYZER_01)) {
                            boolQueryBuilder.must(QueryBuilders.termQuery(field.getName(), field.get(this)));
                        } else {
                            boolQueryBuilder.should(QueryBuilders.termQuery(field.getName(), field.get(this)));
                        }
                    }
                } else {
                    if (!ObjectUtils.isEmpty(field.get(this))) {
                        boolQueryBuilder.must(QueryBuilders.matchPhraseQuery(field.getName(), field.get(this)));
                    }
                }
            }
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return boolQueryBuilder;
    }

}
