package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightAvail;
import org.example.AbstractComponents.StrategyFactory;
import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By navBarSection = By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, navBarSection);
    }

    public FooterNav getFooterNav(){
        return new FooterNav(driver, sectionElement);
    }

    // In this way we are breaking the SRP, hence it is not correct
//    public void getLinksCount(String algo) {
//        if(algo.equalsIgnoreCase("footer")){
//            new FooterNav().getLinkCount();
//        }
//    }

    public void setBookingStrategy(String strategyType){
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        searchFlightAvail = strategyFactory.createStrategy(strategyType);
    }

    public void checkAvail(HashMap<String, String> reservationDetails){
        searchFlightAvail.checkAvail(reservationDetails);
    }

    public String getTitle() {
        System.out.println("Hello");
        return driver.getTitle();
    }
}
