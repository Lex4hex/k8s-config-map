package com.lex4hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(value = ReloadableProperties.class)
public class ConfigMapApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMapApplication.class, args);
    }
}