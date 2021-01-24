package com.bywlstudio.oss.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zl
 * @Date: Create in 2021/1/22 23:37
 * @Description:
 */
@Configuration
public class OSSConfiguration {


    @Bean
    public OSS oss(){
        return new OSSClientBuilder().build(OssInfo.OSS_ENDPOINT, OssInfo.OSS_ACCESS_KEY, OssInfo.OSS_ACCESS_KEY_SECRET);
    }

}
