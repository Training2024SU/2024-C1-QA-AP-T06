package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CheckRadioPage extends FunctionsCommons {
    private WebDriverWait wait;

    @FindBy(id = "item-1")
    @CacheLookup
    private WebElement checkBoxButton;

    @FindBy(id = "item-2")
    @CacheLookup
    private WebElement radioButton;

    @FindBy(xpath = "//button[@aria-label='Expand all']")
    @CacheLookup
    private WebElement botonExpandir;

    @FindBy(xpath = "//button[@aria-label='Collapse all']")
    @CacheLookup
    private WebElement botonColapsar;

    @FindBy(xpath = "//span[@class='rct-checkbox']")
    @CacheLookup
    private WebElement checkboxExpandir;

    @FindBy(xpath = "//span[text()='You have selected :']")
    private WebElement selectedMessageCheckBox;

    @FindBy(css = "span.text-success")
    private WebElement impressiveSpan;

    @FindBy(css = "label.custom-control-label[for='yesRadio']")
    private WebElement botonYes;

    @FindBy(css = "label.custom-control-label[for='impressiveRadio']")
    private WebElement botonImpressive;

    public CheckRadioPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void seleccionarOpcionCheckBox() {
        clickSelection(checkBoxButton);
    }

    public void seleccionarOpcionRadioButton() {
        clickSelection(radioButton);
    }

    public void mostrarCarpetas() {
        clickSelection(botonExpandir);
    }

    public void ocultarCarpetas() {
        clickSelection(botonColapsar);
    }

    public void seleccionarCajaHome() {
        clickSelection(checkboxExpandir);
    }

    public void expandirSeleccionarDisminuir() {
        mostrarCarpetas();
        seleccionarCajaHome();
        ocultarCarpetas();
    }

    public String obtenerCheckBoxMensaje() {
        return getText(selectedMessageCheckBox);

    }

    public String obtenerRadioBotonMensaje() {
        return getText(impressiveSpan);
    }

    public void seleccionarRadioYes(){
        clickSelection(botonYes);
    }

    public void seleccionarRadioImpressive(){
        clickSelection(botonImpressive);
    }

    public void seleccionarOpcionesRadio(){
        seleccionarRadioYes();
        seleccionarRadioImpressive();
    }

}
