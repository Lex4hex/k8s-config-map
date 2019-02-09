package com.lex4hex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController("/")
public class PropertyTesterController {

    @Value("${value.property:NOT FOUND}")
    private String valueProperty;

    private final ReloadableProperty reloadableProperty;

    @Value("${EXAMPLE_ENV_PROPERTY:NOT FOUND}")
    private String environmentProperty;

    private Environment environment;

    public PropertyTesterController(ReloadableProperty reloadableProperty,
            Environment environment) {
        this.reloadableProperty = reloadableProperty;
        this.environment = environment;
    }

    @GetMapping("/get-properties")
    public String getProperties() {
        StringBuilder propertyString =
                new StringBuilder().append("SPRING PROFILE: ").append(Arrays.toString(environment.getActiveProfiles()))
                        .append("\n");

        if (!valueProperty.equals("NOT FOUND")) {
            propertyString
                    .append("\n").append("VALUE PROPERTY: ").append(valueProperty).append("\n");
        }

        if (reloadableProperty.getProperty() != null) {
            propertyString.append("RELOADABLE PROPERTY: ").append(reloadableProperty.getProperty()).append("\n");
        }

        if (!environmentProperty.equals("NOT FOUND")) {
            propertyString.append("ENVIRONMENT PROPERTY:").append(environmentProperty);
        }

        return propertyString.toString();
    }

}
