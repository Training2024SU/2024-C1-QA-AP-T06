package co.com.sofka.page.function;

import co.com.sofka.model.TextboxModel;
import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TextboxPage extends FunctionsCommons {

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'TextBox']")
    private WebElement TB;


    //Localizadores
    private final By CAMPO_FULLNAME = By.id("userName");
    private final By CAMPO_EMAIL = By.id("userEmail");
    private final By CAMPO_CURRENT = By.id("currentAddress");
    private final By CAMPO_PERMANET = By.id("permanentAddress");
    private final By BTN_SUBMIT = By.id("submit");
    private final By BTN_ELEMENTS = By.xpath( "//h5[contains(text(), 'Elements')]");
    private final By BTN_TEXTBOX = By.xpath("//span[text()='Text Box']");
    private final By CAJA_SALIDA = By.id("output");


    public TextboxPage(WebDriver driver) {
        super(driver);
    }


    // funciones
    public void formularioTextbox(TextboxModel textboxModel){

        typeInto(CAMPO_FULLNAME, textboxModel.getFullname());
        typeInto(CAMPO_EMAIL, textboxModel.getEmail());
        typeInto(CAMPO_CURRENT, textboxModel.getCurrent());
        typeInto(CAMPO_PERMANET, textboxModel.getPermanet());
        //scrollTo(BTN_SUBMIT);
        clickSelection(BTN_SUBMIT);
        waitSeconds(10);

    }
    public void goToTB() {

       // waitSeconds(1000);
        clickSelection(BTN_TEXTBOX);
      //  waitSeconds(100);

    }
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean verificarPresenciaDeRecuadroDeSalida() {
        return isElementPresent(CAJA_SALIDA);
    }




}
