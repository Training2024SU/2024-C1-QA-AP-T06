package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends FunctionsCommons {
    @CacheLookup
    @FindBy(id = "showSmallModal")
    private WebElement botonSmallModal;
    @CacheLookup
    @FindBy(id = "showLargeModal")
    private WebElement botonLargeModal;
    @CacheLookup
    @FindBy(id = "closeSmallModal")
    private WebElement botonCerrarSmallModal;
    @CacheLookup
    @FindBy(id = "closeLargeModal")
    private WebElement botonCerrarLargeModal;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Small Modal']")
    private WebElement tituloSmallModal;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Large Modal']")
    private WebElement tituloLargeModal;


    public ModalDialogsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickSmallModal() {
        waitToBeVisible(botonSmallModal);
        clickSelection(botonSmallModal);
    }
    public void cerrarSmallModal() {
        waitToBeVisible(botonCerrarSmallModal);
        clickSelection(botonCerrarSmallModal);
    }
    public void clickLargeModal() {
        waitToBeVisible(botonLargeModal);
        clickSelection(botonLargeModal);
    }
    public void cerrarLargeModal() {
        waitToBeVisible(botonCerrarLargeModal);
        clickSelection(botonCerrarLargeModal);
    }
    public String obtenerTituloSmallModal() {
        waitToBeVisible(tituloSmallModal);
        return tituloSmallModal.getText();
    }
    public String obtenerTituloLargeModal() {
        waitToBeVisible(tituloLargeModal);
        return tituloLargeModal.getText();
    }
}
