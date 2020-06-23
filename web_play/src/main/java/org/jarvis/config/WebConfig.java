package org.jarvis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author:tennyson date:2020/6/22
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*handler中是服务器虚拟路径，jsp访问的目录，location中是相对应的本地路径*/
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/");
    }
}
