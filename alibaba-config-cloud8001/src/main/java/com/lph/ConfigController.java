package com.lph;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lph
 **/
@RestController
@RefreshScope //支持Nacos的动态刷新功能。
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config")
    public String getConfigInfo(){
        return configInfo;
    }

}
