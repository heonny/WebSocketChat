package com.chang.socketchat.config;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServerConfigure implements WebMvcConfigurer {

    private static final List<String> URL_PATTERNS = Collections.singletonList("/**/*");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInterceptor()).addPathPatterns(URL_PATTERNS);
    }
}
