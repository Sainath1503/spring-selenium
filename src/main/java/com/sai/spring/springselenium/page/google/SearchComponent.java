package com.sai.spring.springselenium.page.google;

import com.sai.spring.springselenium.alpha.annotation.PageFragment;
import com.sai.spring.springselenium.page.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[5]/center/input[1]")
    private List<WebElement> searchBtn;

    @Lazy
    @Autowired
    private JavascriptExecutor js;

    public void search(final String keyword) throws InterruptedException {

        this.searchBox.click();
        this.searchBox.sendKeys(keyword);
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,750)", "");
        this.searchBtn.stream()
                .filter(e->e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }
    @Override
    public boolean isAt() {

        return this.wait.until((d)->this.searchBox.isDisplayed());
    }
}
