package com.sai.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleClass {

    @Value("${Salary:1000}")
    private String value;

    public String getValue() {
        return value;
    }
}
