package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryTabs extends FunctionsCommons {
public static String INTEREACION = "Tabs";
public static String EXPECTED = "Select Menu";


    @CacheLookup
    @FindBy(xpath = "//span[text()='Tabs']")
    private WebElement botonTaps;
    @CacheLookup
    @FindBy(id = "demo-tab-what")
    private WebElement tap1;
    @CacheLookup
    @FindBy(id = "demo-tab-origin")
    private WebElement tap2;
    @CacheLookup
    @FindBy(id = "demo-tab-use")
    private WebElement tap3;
    @CacheLookup
    @FindBy(css = "h1[class='text-center']")
    private WebElement titulo;


    public PageFactoryTabs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void irPaginaTabs(){
        scrollTo(botonTaps);
        clickSelection(botonTaps);
    }

    public void interactuarTabs(){
        scrollTo(tap1);
        clickSelection(tap1);
        clickSelection(tap2);
        clickSelection(tap3);
    }

    public String mensajeActual(){
        String mensaje = titulo.getText();
        return mensaje;
    }
}
