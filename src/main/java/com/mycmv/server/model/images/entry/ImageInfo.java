package com.mycmv.server.model.images.entry;

import lombok.Data;
import java.util.Date;

/**
 * 图片信息
 * @author wanghaikuo
 * @date 2020/6/25
 **/
@Data
public class ImageInfo {

    private Long        imageId;
    /** 上传人 */
    private Long        userId;
    /** 图片类型，业务类型 */
    private Integer     imageCate;
    /** 业务编号 **/
    private Long        bussId;
    /**  图片地址 */
    private String      imageSrc;
    private Integer     orderNo;
    /** 创建日期 */
    private Date        createDate;
}
