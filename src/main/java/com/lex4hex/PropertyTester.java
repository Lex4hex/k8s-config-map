package com.lex4hex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class PropertyTester {

    @Value("${test.property}")
    private String testProperty;

    @PostConstruct
    public void init() {
        log.info(testProperty);
    }
}
