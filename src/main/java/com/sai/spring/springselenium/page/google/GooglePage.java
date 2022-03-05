package com.sai.spring.springselenium.page.google;

import com.sai.spring.springselenium.alpha.annotation.Page;
import com.sai.spring.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;


    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void goTo()
    {

        this.driver.get(url);
        this.driver.manage().window().maximize();
        System.out.println("Page Launched - "+this.driver.getCurrentUrl());
    }

    public void close()
    {
        System.out.println("Entering Closure Method");
        this.driver.quit();
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
