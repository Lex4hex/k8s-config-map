package com.lex4hex.controller;

import com.lex4hex.property.DatabaseAuthProperty;
import com.lex4hex.property.ExampleProperty;
import com.lex4hex.property.ReloadableProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController("/")
public class PropertyTesterController {

    @Value("${EXAMPLE_ENV_PROPERTY:NOT FOUND}")
    private String environmentProperty;

    private final ReloadableProperty reloadableProperty;

    private final ExampleProperty exampleProperty;

    private final DatabaseAuthProperty databaseAuthProperty;

    private Environment environment;

    public PropertyTesterController(ReloadableProperty reloadableProperty, ExampleProperty exampleProperty,
            DatabaseAuthProperty databaseAuthProperty, Environment environment) {
        this.reloadableProperty = reloadableProperty;
        this.exampleProperty = exampleProperty;
        this.databaseAuthProperty = databaseAuthProperty;
        this.environment = environment;
    }

    @GetMapping("/get-properties")
    public String getProperties() {
        StringBuilder propertyString =
                new StringBuilder().append("SPRING PROFILE: ").append(Arrays.toString(environment.getActiveProfiles()))
                        .append("\n");

        if (exampleProperty.getProperty() != null) {
            propertyString
                    .append("\n").append("EXAMPLE PROPERTY: ").append(exampleProperty.getProperty()).append("\n");
        }

        if (reloadableProperty.getProperty() != null) {
            propertyString.append("RELOADABLE PROPERTY: ").append(reloadableProperty.getProperty()).append("\n");
        }

        if (!environmentProperty.equals("NOT FOUND")) {
            propertyString.append("ENVIRONMENT PROPERTY:").append(environmentProperty);
        }

        if (databaseAuthProperty.getPassword() != null && databaseAuthProperty.getUsername() != null) {
            propertyString.append("SECRET: username=").append(databaseAuthProperty.getUsername()).append(" password=")
                    .append(databaseAuthProperty.getPassword());
        }

        return propertyString.toString();
    }

}
