package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckRadioPage extends FunctionsCommons {

    @FindBy(id = "item-1")
    @CacheLookup
    private WebElement checkBoxButton;

    @FindBy(id = "item-2")
    @CacheLookup
    private WebElement radioButton;

    public CheckRadioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void seleccionarOpcionCheckBox() {
        clickSelection(checkBoxButton);
    }

    public void seleccionarOpcionRadioButton() {
        clickSelection(radioButton);
    }
}
