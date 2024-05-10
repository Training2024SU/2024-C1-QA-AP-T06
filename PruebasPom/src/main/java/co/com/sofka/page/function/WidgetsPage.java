package co.com.sofka.page.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage extends FunctionsCommons {
    @FindBy(xpath = "//span[text()='Date Picker']/..")
    WebElement datePickerLI;

    public WidgetsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarADatePickerPage() {
        scrollTo(datePickerLI);
        clickSelection(datePickerLI);
    }
}
