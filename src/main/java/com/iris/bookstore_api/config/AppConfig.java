package com.iris.bookstore_api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppConfig {

    @Value("${APP_ENV}")
    private String appEnv;

    public String getAppEnv() {
        return appEnv;
    }
}
