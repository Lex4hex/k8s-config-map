package com.lex4hex;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "reloadable")
@Data
public class ReloadableProperty {

    private String property;
}
