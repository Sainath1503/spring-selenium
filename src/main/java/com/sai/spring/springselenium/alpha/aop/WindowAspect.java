package com.sai.spring.springselenium.alpha.aop;

import com.sai.spring.springselenium.alpha.annotation.Window;
import com.sai.spring.springselenium.alpha.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {



    @Autowired
    private WindowSwitchService service;

    @Before("@target(window) && within(com.sai.spring.springselenium..*)")
    public void before(Window window)
    {
        this.service.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.sai.spring.springselenium..*)")
    public void after(Window window)
    {
        this.service.switchByIndex(0);
    }

}
