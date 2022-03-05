package com.sai.spring.springselenium.page.window;

import com.sai.spring.springselenium.alpha.annotation.Page;
import com.sai.spring.springselenium.alpha.annotation.Window;
import com.sai.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class PageB extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg)
    {
        this.textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.textArea.isDisplayed());
    }

}
