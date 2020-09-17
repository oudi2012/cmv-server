package com.mycmv.server.model.books.vo;

import com.mycmv.server.model.books.entry.BookInfo;
import lombok.Data;

import java.util.List;

/**
 * @author a
 */
@Data
public class BookListVo {
    private List<BookInfo> bookInfoList;
}
