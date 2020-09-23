package com.mycmv.server.model.elastic.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author a
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elastic {

    /**
     * 主键标识，用户ES持久化
     */
    private String id;

    /**
     * JSON对象，实际存储数据
     */
    private Object data;

}
