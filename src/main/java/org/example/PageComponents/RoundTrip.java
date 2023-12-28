package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {

    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
        findElement(search).click();
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<RoundTrip> consumer) {
        System.out.println("I am inside round trip ");
        findElement(rdo).click();
        waitForElementAppear(from);

        // .accept is to accept any method of this class
        consumer.accept(this);
        System.out.println("I am done");
        // Common prerquest code
        // Execute actual function-Book/
        // Tear down method
    }
}
