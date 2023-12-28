package org.example.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class AbstractComponent {

    WebElement sectionElement;
    WebDriver driver;

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement);
        this.driver = driver;
    }

    public WebElement findElement(By findElementBy){
        return sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementBy){
        return sectionElement.findElements(findElementBy);
    }

    public void waitForElementToDissapear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void waitForElementAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }
}
