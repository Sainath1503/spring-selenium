package com.sai.spring.springselenium.alpha.aop;

import com.sai.spring.springselenium.alpha.annotation.TakeScreenshot;
import com.sai.spring.springselenium.alpha.service.ScreenShotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenShotService screenShotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException
    {
        this.screenShotService.takeScreenShot();
    }

}
