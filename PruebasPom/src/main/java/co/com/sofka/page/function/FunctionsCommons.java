package co.com.sofka.page.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FunctionsCommons {
    protected final WebDriver driver;

    public FunctionsCommons(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);

    }
}
