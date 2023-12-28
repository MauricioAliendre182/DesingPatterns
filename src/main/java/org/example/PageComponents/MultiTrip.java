package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");
    private By multicity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopup = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        // This will ensure that the operations in the method makeStateReady
        // will be executed before selectOriginCity
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination1"));
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination){
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination){
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer) {
        System.out.println("I am inside multi trip ");
        findElement(multicity_rdo).click();
        findElement(modalPopup).click();
        waitForElementToDissapear(modalPopup);
        // .accept is to accept any method of this class
        consumer.accept(this);
        System.out.println("I am done");
        // Common prerquest code
        // Execute actual function-Book/
        // Tear down method
    }

}
