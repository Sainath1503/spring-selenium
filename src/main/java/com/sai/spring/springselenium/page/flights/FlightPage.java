package com.sai.spring.springselenium.page.flights;

import com.sai.spring.springselenium.alpha.annotation.TakeScreenshot;
import com.sai.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FlightPage extends Base {


    @FindBy(xpath = "//*[@jsname='iSelEd']")
    private List<WebElement> elements;

    public void goTo(final String url)
    {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    public void close()
    {
        this.driver.close();
    }

    @TakeScreenshot
    public List<String> getLabels()
    {
        //System.out.println("Get Labels - "+elements.toString());
       return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

    }

    @Override
    public boolean isAt() {
        //System.out.println("Labels - "+this.elements.stream().map(WebElement::getText));

        return this.wait.until((d)-> !this.elements.isEmpty());
    }
}
