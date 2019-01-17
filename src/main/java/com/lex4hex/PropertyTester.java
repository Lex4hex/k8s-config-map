package com.lex4hex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class PropertyTester {

    @Value("${test.property:NOT FOUND}")
    private String testProperty;

    @Value("${placeholder.property:PLACEHOLDER IS NOT FOUND}")
    private String placeHolderProperty;

    private final ReloadableProperties reloadableProperties;

    private final Environment env;

    @Autowired
    public PropertyTester(ReloadableProperties reloadableProperties, Environment env) {
        this.reloadableProperties = reloadableProperties;
        this.env = env;
    }

    @Scheduled(fixedDelay = 5000)
    public void testProperty() {
        log.info(testProperty);
        log.info(reloadableProperties.getProperty());
        log.info(placeHolderProperty);
        log.info(Arrays.toString(env.getActiveProfiles()));
    }

}
