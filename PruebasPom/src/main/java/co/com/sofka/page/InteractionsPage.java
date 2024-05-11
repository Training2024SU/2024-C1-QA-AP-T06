package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InteractionsPage extends FunctionsCommons {
    @CacheLookup
    @FindBy(xpath = "//span[text()='Selectable']/..")
    WebElement selectableLI;
    @CacheLookup
    @FindBy(xpath = "//span[text()='Droppable']")
    WebElement droppable;

    public InteractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarASelectablePage() {
        scrollTo(selectableLI);
        clickSelection(selectableLI);
    }
    public void navegarADroppablePage(){
        scrollTo(droppable);
        clickSelection(droppable);
    }
}
