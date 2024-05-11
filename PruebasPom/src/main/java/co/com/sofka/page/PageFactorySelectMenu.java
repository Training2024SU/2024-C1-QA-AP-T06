package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import io.cucumber.junit.CucumberOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class PageFactorySelectMenu extends FunctionsCommons {
    public static final String SELECT_GROUP = "Group 1, option 1";
    public static final String SELECT_ONE = "Dr.";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Random random = new Random();
    String num = ((String.valueOf(random.nextInt(10) + 1)));
    String n = ((String.valueOf(random.nextInt(4) + 1)));
    String selectMenu = "//*[@id='oldSelectMenu']/option[" + num + "]";
    String selectAuto = "//*[@id='cars']/option["+n+"]";

    @CacheLookup
    @FindBy(xpath = "//span[text()='Select Menu']")
    private WebElement botonSelectMenu;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Select Option']")
    private WebElement campoValue;
    @CacheLookup
    @FindBy(id = "react-select-2-input")
    private WebElement insertInput;
    @CacheLookup
    @FindBy(xpath = "//div[text()='Select Title']")
    private WebElement campoSelecOne;
    @CacheLookup
    @FindBy(id = "react-select-3-input")
    private WebElement insertInputSelectOne;
    @CacheLookup
    @FindBy(id = "oldSelectMenu")
    private WebElement campoOldStyleSelectMenu;
    public By opcionColor = By.xpath(selectMenu);
    public By opcionCar = By.xpath(selectAuto);
    @CacheLookup
    @FindBy(xpath = "//div[text()='Select...']")
    private WebElement campoMultiSelect;
    @CacheLookup
    @FindBy(id = "react-select-4-input")
    private WebElement campoColor;
    @CacheLookup
    @FindBy(css = "h1[class='text-center']")
    private WebElement texto;

    public PageFactorySelectMenu(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void irPaginaSelectMenu() {
        scrollTo(botonSelectMenu);
        clickSelection(botonSelectMenu);
    }

    public void llenarCampos() {
        scrollTo(campoValue);
        clickSelection(campoValue);
        typeInto(insertInput, SELECT_GROUP);
        insertInput.sendKeys(Keys.ENTER);
        clickSelection(campoSelecOne);
        typeInto(insertInputSelectOne, SELECT_ONE);
        insertInputSelectOne.sendKeys(Keys.ENTER);
        clickSelection(campoOldStyleSelectMenu);
        wait.until(ExpectedConditions.elementToBeClickable(opcionColor));
        clickSelection(opcionColor);
        clickSelection(opcionColor);
        clickSelection(campoMultiSelect);
        campoColor.sendKeys(Keys.ENTER);
        campoColor.sendKeys(Keys.ENTER);
        campoColor.sendKeys(Keys.ENTER);
        scrollTo(campoColor);
        clickSelection(opcionCar);
    }

    public String camposTexto(){
        String mensaje = texto.getText();
        return mensaje;
    }
}
