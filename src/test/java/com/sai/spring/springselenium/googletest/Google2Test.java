package com.sai.spring.springselenium.googletest;

import com.sai.spring.springselenium.SpringBaseTestNGTest;
import com.sai.spring.springselenium.alpha.annotation.LazyAutowired;
import com.sai.spring.springselenium.page.google.GooglePage;
import com.sai.spring.springselenium.alpha.service.ScreenShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenShotService screenShotService;



    @Test
    public void googleTest() throws IOException, InterruptedException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("selenium");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount()>2);
        this.screenShotService.takeScreenShot();
        this.googlePage.close();
    }

    /*@AfterSuite
    public void closure()
    {
        List<WebDriver> driverCol = WebDriverCollection.getWebDriverList();
        for (int i = 0; i < driverCol.size(); i++)
        {

            try
            {
                driverCol.get(i).close();
            }
            catch (Exception e)
            {
                continue;
            }

        }
    }*/



}
