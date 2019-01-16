package com.lex4hex;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "test")
@Data
public class ReloadableProperties {

    private String property;
}
