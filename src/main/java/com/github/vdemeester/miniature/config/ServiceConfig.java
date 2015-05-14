package com.github.vdemeester.miniature.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {
        "com.github.vdemeester.miniature.service",
        "com.github.vdemeester.miniature.repository"
})
public class ServiceConfig {

    @Bean
    public Config config() {
        return ConfigFactory.load();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
