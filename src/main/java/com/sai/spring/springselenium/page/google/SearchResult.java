package com.sai.spring.springselenium.page.google;

import com.sai.spring.springselenium.alpha.annotation.PageFragment;
import com.sai.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends Base {

 @FindBy(xpath = "//*[@id='rso']/div")
 private List<WebElement> results;

 public int getCount()

 {

     return this.results.size();
 }


    @Override
    public boolean isAt()
    {
        return this.wait.until((d)-> !this.results.isEmpty());
    }
}
