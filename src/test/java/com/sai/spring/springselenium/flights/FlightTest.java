package com.sai.spring.springselenium.flights;

import com.sai.spring.springselenium.SpringBaseTestNGTest;
import com.sai.spring.springselenium.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FlightTest extends SpringBaseTestNGTest {


    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest()
    {
       this.flightPage.goTo(this.appDetails.getUrl());
        Assert.assertTrue(this.flightPage.isAt());
        System.out.println("Labels Actual- "+this.flightPage.getLabels());
        System.out.println("Labels Expected - "+this.appDetails.getLabels());
        Assert.assertEquals(this.flightPage.getLabels(),this.appDetails.getLabels());
        this.flightPage.close();
    }

}
