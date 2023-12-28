package org.example.AbstractComponents;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }
    public SearchFlightAvail createStrategy(String strategyType) {
        if(strategyType.trim().equalsIgnoreCase("multitrip")){
            return new MultiTrip(driver, sectionElement);
        }
        if (strategyType.trim().equalsIgnoreCase("roundtrip")){
            return new RoundTrip(driver, sectionElement);
        }
        return null;
    }
}
