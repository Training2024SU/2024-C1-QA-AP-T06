package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends FunctionsCommons {
    @FindBy(xpath = "//span[text()='Dynamic Properties']/..")
    WebElement dynamicPropertiesLI;

    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarADynamicProperties() {
        scrollTo(dynamicPropertiesLI);
        clickSelection(dynamicPropertiesLI);
    }
}
