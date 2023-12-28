package org.maps182.tests;

import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavigationBar;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp(){
        driver = intilizeDriver();
        travelHomePage = new TravelHomePage(driver);

    }

    @Test(dataProvider = "getData")
    public void flighTest(HashMap<String, String> reservationDetails) {
        travelHomePage.goTo();
        FooterNav footerNav = travelHomePage.getFooterNav();
        footerNav.getFlightAttribute();
        footerNav.getLinkCount();
        Assert.assertEquals(footerNav.getLinkCount(), 14);

        NavigationBar navigationBar = travelHomePage.getNavigationBar();
        navigationBar.getFlightAttribute();
        navigationBar.getLinkCount();

        Assert.assertEquals(navigationBar.getLinkCount(), 6);

        //One way, round trip, multi trip - checkAvailability(origin, destination)
//        travelHomePage.roundTrip().checkAvailability();
//        travelHomePage.multiTrip().checkAvailability();

        // checkAvailability
        // create an interface
//        travelHomePage.setBookingStrategy(new MultiTrip());
//        travelHomePage.setBookingStrategy(new RoundTrip(driver, sectionElement));

        // Bad way to create this
        // travelHomePage.setBookingStrategy(new MultiTrip(driver, sectionElement));

        // Factory will create a new object
        travelHomePage.setBookingStrategy("multitrip");

        travelHomePage.checkAvail(reservationDetails); //Strategy Design Pattern
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData("reservationDetails.json");
        return new Object[][]
                {
                        {data.get(0)},
                        {data.get(0)}
                };
    }
}
