package com.lex4hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = ReloadableProperty.class)
public class ConfigMapApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMapApplication.class, args);
    }
}