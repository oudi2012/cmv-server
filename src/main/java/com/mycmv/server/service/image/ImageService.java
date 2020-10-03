package com.mycmv.server.service.image;

import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/***
 * 图片处理
 * @author a
 */
public interface ImageService {


    /***
     * 上传图片
     * @param file file
     * @return String
     * @throws IOException IOException
     */
    String uploadImage(File file);

    /***
     * 读取图片
     * @param file file
     * @return BufferedImage
     * @throws IOException IOException
     */
    BufferedImage readImage(File file) throws IOException;

    /***
     * 读取图片
     * @param stream stream
     * @return BufferedImage
     * @throws IOException IOException
     */
    BufferedImage readImage(InputStream stream) throws IOException;

    /***
     * 读取图片
     * @param input input
     * @return BufferedImage
     * @throws IOException IOException
     */
    BufferedImage readImage(ImageInputStream input) throws IOException;
}
