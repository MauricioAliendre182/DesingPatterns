package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {
    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); // When you inherit parent class - you should invoke parent class constructor
        // in your own child constructor
    }
    // method to handle flights
    // when selenium executes any method in this class - scope of selenium
    // should be in the footer only

    public void getFlightAttribute() {
        //findElement
        System.out.println(findElement(flights).getAttribute("class"));
//        driver.findElement(flights).click();
    }

    public int getLinkCount() {
        System.out.println(findElements(links).size());
        return findElements(links).size();
    }
}
