package com.lex4hex;

import com.lex4hex.property.DatabaseAuthProperty;
import com.lex4hex.property.ExampleProperty;
import com.lex4hex.property.ReloadableProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {ReloadableProperty.class, DatabaseAuthProperty.class, ExampleProperty.class})
public class ConfigMapApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMapApplication.class, args);
    }
}