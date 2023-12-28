package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

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
