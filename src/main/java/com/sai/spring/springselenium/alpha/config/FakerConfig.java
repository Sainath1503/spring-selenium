package com.sai.spring.springselenium.alpha.config;

import com.github.javafaker.Faker;
import com.sai.spring.springselenium.alpha.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker()
    {
        return new Faker();
    }
}
