package com.mycmv.server.model.books.vo;

import com.mycmv.server.model.books.elastic.BookInfoEs;
import lombok.Data;

import java.util.List;

/**
 * @author a
 */
@Data
public class EsBookListVo {
    private List<BookInfoEs> esBookInfoList;
}
