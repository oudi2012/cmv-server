package com.mycmv.server.configuration;

import com.obs.services.ObsClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @author a
 */
@Data
@Configuration
public class HwOssConfig {

    @Value("${upload.obs.endPoint}")
    private String endPoint;
    @Value("${upload.obs.accessKey}")
    private String accessKey;
    @Value("${upload.obs.secretKey}")
    private String secretKey;
    @Value("${upload.obs.bucketName}")
    private String bucketName;
    @Value("${upload.obs.showImageHost}")
    private String showImageHost;

    @Bean
    public ObsClient getObsClient() {
        return new ObsClient(accessKey, secretKey, endPoint);
    }
}
