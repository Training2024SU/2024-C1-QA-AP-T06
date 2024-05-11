package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class AlertsPage extends FunctionsCommons {


    @CacheLookup
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement FORMS_LINK;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']")
    private WebElement CLICK_AFW;

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Alerts']")
    private WebElement ALERTS_PRACTICE_LI;

    // Basic alert interaction
    @CacheLookup
    @FindBy(id = "alertButton")
    private WebElement CLICK_ALERT;

    // Timer alert
    @CacheLookup
    @FindBy(id = "timerAlertButton")
    private WebElement RETARDED_ALERT;

    // Confirm alert
    @CacheLookup
    @FindBy(id = "confirmButton")
    private WebElement CONFIRMACION_ALERT;

    @CacheLookup
    @FindBy(id = "confirmResult")
    private WebElement CONFIRM_ALERT_MSG;

    // Prompt alert
    @CacheLookup
    @FindBy(id = "promtButton")
    private WebElement PROMPT_ALERT;
    @CacheLookup
    @FindBy(id = "promptResult")
    private WebElement ESTE;
    private String promptAlertMessage;


    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToAlerts(){
        scrollTo(FORMS_LINK);
        clickSelection(FORMS_LINK);

        scrollTo(CLICK_AFW);
        clickSelection(CLICK_AFW);

        scrollTo(ALERTS_PRACTICE_LI);
        clickSelection(ALERTS_PRACTICE_LI);
    }

    public Alert clickAlert(){
        clickSelection(CLICK_ALERT);
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public Alert timerAlert() {
        scrollTo(RETARDED_ALERT);
        clickSelection(RETARDED_ALERT);
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(8))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public Alert confirmacionAlert() {
        clickSelection(CONFIRMACION_ALERT);
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public Alert promptAlert() {
        clickSelection(PROMPT_ALERT);
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(3))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;

    }
}
