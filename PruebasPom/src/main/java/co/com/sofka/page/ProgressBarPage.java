package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends FunctionsCommons {

    @CacheLookup
    @FindBy(xpath = "//span[text()='Progress Bar']")
    WebElement PROGRESS_BAR_MENU;

    @CacheLookup
    @FindBy(id = "startStopButton")
    WebElement BOTON_START_STOP;

    @CacheLookup
    @FindBy(id = "resetButton")
    WebElement BOTON_RESET;

    @CacheLookup
    @FindBy(xpath = "//*[@role='progressbar']")
    WebElement PROGRESS_BAR_ASSERTION;


    public ProgressBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void abrirMenuProgressBar(){
        scrollTo(PROGRESS_BAR_MENU);
        clickSelection(PROGRESS_BAR_MENU);
    }

    public void esperarQueCargue(){
        waitToBeVisible(BOTON_RESET);
    }

    public void clickBotonStartStop(){
        waitToBeVisible(BOTON_START_STOP);
        clickSelection(BOTON_START_STOP);
    }

    public String recibirTextoBarra(){
        return getText(PROGRESS_BAR_ASSERTION);
    }

    public String recibirTextoReset(){
        return getText(BOTON_RESET);
    }
}
