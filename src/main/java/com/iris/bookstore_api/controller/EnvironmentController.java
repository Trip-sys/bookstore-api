package com.iris.bookstore_api.controller;

import com.iris.bookstore_api.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

    private final AppConfig appConfig;

    @Autowired
    public EnvironmentController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/environment")
    public String getEnvironment() {
        return "Current environment: " + appConfig.getAppEnv();
    }
}
