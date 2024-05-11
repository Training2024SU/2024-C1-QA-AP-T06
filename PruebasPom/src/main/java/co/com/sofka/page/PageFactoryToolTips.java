package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryToolTips extends FunctionsCommons {
    Actions actions = new Actions(driver);
    @CacheLookup
    @FindBy(xpath = "//span[text()='Tool Tips']")
    private WebElement botonToolTips;
    @CacheLookup
    @FindBy(id = "toolTipTextField")
    private WebElement campoTexto;
    @CacheLookup
    @FindBy(id = "toolTipButton")
    private WebElement botonHover;

    public PageFactoryToolTips(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void irPaginaToolTisp(){
        scrollTo(botonToolTips);
        clickSelection(botonToolTips);
    }

    public void ingresarTexto(String text){
        scrollTo(campoTexto);
        typeInto(campoTexto,text);
        actions.moveToElement(botonHover).perform();
    }

    public String contieneTexto(){
        String mensaje = campoTexto.getText();
        return mensaje;
    }

}
