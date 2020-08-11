package com.debugf.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuxiang
 * @date 2020/8/11 16:19
 * @Email 905364660@qq.com
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTmplate(){
        return new RestTemplate();
    }
}
