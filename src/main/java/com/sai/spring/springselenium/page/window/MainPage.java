package com.sai.spring.springselenium.page.window;

import com.sai.spring.springselenium.alpha.annotation.Page;
import com.sai.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Page
public class MainPage extends Base {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo()
    {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void launchAllWindows()
    {
        try {
            for (int i = 0; i < links.size(); i++) {
                links.get(i).click();
                Thread.sleep(2500);
                this.wait.until(ExpectedConditions.numberOfWindowsToBe(i + 2));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAt() {
            return this.wait.until((d)->!this.links.isEmpty());
    }
}
