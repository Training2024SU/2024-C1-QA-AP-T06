package co.com.sofka.page.function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage extends FunctionsCommons {
    @FindBy(xpath = "//span[text()='Date Picker']/..")
    WebElement datePickerLI;
    @FindBy(xpath = "//span[text()='Accordian']/..")
    WebElement accordian;
    @FindBy(xpath = "//span[text()='Auto Complete']/..")
    WebElement autoComplete;

    public WidgetsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarADatePickerPage() {
        scrollTo(datePickerLI);
        clickSelection(datePickerLI);
    }

    public void navegarAccordian() {
        scrollTo(accordian);
        clickSelection(accordian);
    }

    public void navegarAutoComplete() {
        scrollTo(autoComplete);
        clickSelection(autoComplete);
    }

}
