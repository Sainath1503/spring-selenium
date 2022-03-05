package com.sai.spring.springselenium.alpha.config;

import com.sai.spring.springselenium.alpha.annotation.LazyConfiguration;
import com.sai.spring.springselenium.alpha.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {






    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser",havingValue = "firefox" )
    public WebDriver firefoxDriver()
    {
        try
        {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser",havingValue = "chrome")
    public WebDriver chromeDriver()
    {
        try
        {

            WebDriverManager.chromedriver().version("97.0.4692.71").setup();
            WebDriver driver = new ChromeDriver();
            WebDriverCollection.webDriverList.add(driver);
            return driver;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver InternetExpDriver()
    {
        try
        {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }



}
