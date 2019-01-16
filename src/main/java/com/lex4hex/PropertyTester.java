package com.lex4hex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class PropertyTester {

    @Value("${test.property:NOT FOUND}")
    private String testProperty;

    private final ReloadableProperties reloadableProperties;

    @Autowired
    public PropertyTester(ReloadableProperties reloadableProperties) {
        this.reloadableProperties = reloadableProperties;
    }

    @Scheduled(fixedDelay = 5000)
    public void testProperty() {
        log.info(testProperty);
        log.info(reloadableProperties.getProperty());
    }

}
