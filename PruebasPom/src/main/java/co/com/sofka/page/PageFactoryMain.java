package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryMain extends FunctionsCommons {

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text() , 'Forms')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement forms;

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Interactions')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement interacciones;

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Alerts')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement alertas;

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Widgets')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement widgets;

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Elements')]/ancestor::div[@class = 'card mt-4 top-card']")
    private WebElement elementos;

    @CacheLookup
    @FindBy(xpath = "//h5[contains(text(), 'Book Store Application')]")
    private WebElement bookStoreApplication;


    public PageFactoryMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarAForms() {
        clickSelection(forms);
    }

    public void navegarAInteracciones() {
        clickSelection(interacciones);
    }

    public void navegarAAlertas() {
        scrollTo(alertas);
        clickSelection(alertas);
    }

    public void navegarAWidgets() {
        clickSelection(widgets);
    }

    public void navegarAElements() {
        clickSelection(elementos);
    }

    public void navegarBookStoreApplication(){
        scrollTo(bookStoreApplication);
        clickSelection(bookStoreApplication);}

}
