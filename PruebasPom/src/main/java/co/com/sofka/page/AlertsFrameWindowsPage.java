package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindowsPage extends FunctionsCommons {
    @FindBy(xpath = "//span[text()='Browser Windows']/..")
    WebElement browserWindowsLI;

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarABrowserWindowsPage() {
        scrollTo(browserWindowsLI);
        clickSelection(browserWindowsLI);
    }
}
