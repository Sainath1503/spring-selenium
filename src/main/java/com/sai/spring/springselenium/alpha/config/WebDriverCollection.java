package com.sai.spring.springselenium.alpha.config;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WebDriverCollection {

   public static List<WebDriver> webDriverList = new ArrayList<>();

    public static List<WebDriver> getWebDriverList() {
        return webDriverList;
    }
}
