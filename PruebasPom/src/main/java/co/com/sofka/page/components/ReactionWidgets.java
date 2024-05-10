package co.com.sofka.page.components;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReactionWidgets extends FunctionsCommons {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // constructor
    public ReactionWidgets(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // localizadores
    @FindBy(className = "card-header")
    private List<WebElement> cartas;
    @FindBy(xpath = "//p[contains(text(),'is a long')]")
    private WebElement mensajeAccordian;

    @FindBy(css = "#autoCompleteMultipleInput")
    private WebElement multipleColor;
    @FindBy(css = "[class='css-12jo7m5 auto-complete__multi-value__label']")
    private WebElement multipleColorValue;
    @FindBy(id = "autoCompleteSingleInput")
    private WebElement singleColor;
    @FindBy(css = "div[class*='single-value']")
    private WebElement singleColorValue;

    // funciones
    public void selecionAccordian(int repeticiones) {
        for (int y = 0; y < repeticiones; y++) {
            for (int i = 0; i < cartas.size(); i++) {
                WebElement carta = cartas.get(i);
                scrollTo(carta);
                wait.until(d -> carta.isDisplayed());
                carta.click();
            }
        }
    }

    public String validarAccordian() {
        return getText(mensajeAccordian);
    }

    public boolean estadoDesplegado(int indice) {
        WebElement carta = cartas.get(indice);
        WebElement contenido = carta.findElement(By.xpath("./following-sibling::div"));
        wait.until(d -> contenido.getAttribute("class").contains("show"));
        return contenido.getAttribute("class").contains("show");
    }

    public void llenarAutoComplete(String color1, String color2) throws InterruptedException {
        scrollTo(multipleColor);
        typeInto(multipleColor, color1);
        multipleColor.sendKeys(Keys.TAB);
        typeInto(multipleColor, color2);
        multipleColor.sendKeys(Keys.TAB);
        typeInto(singleColor, color2);
        singleColor.sendKeys(Keys.TAB);
        Thread.sleep(3000);
    }

    public String validarMultiAutoComplete() {
        return getText(multipleColorValue);
    }

    public String validarSingleAutoComplete() {
        return getText(singleColorValue);
    }
}
