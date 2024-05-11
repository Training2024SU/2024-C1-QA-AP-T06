package co.com.sofka.page.components;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @FindBy(xpath = ".//a[contains(text(),'Main Item 2')]")
    private WebElement menuOption;
    @FindBy(xpath = ".//a[contains(text(),'SUB SUB LIST »')]")
    private WebElement subMenuOption;
    @FindBy(xpath = ".//a[contains(text(),'Sub Sub Item 1')]")
    private WebElement subSubMenuOption1;
    @FindBy(xpath = ".//a[contains(text(),'Sub Sub Item 2')]")
    private WebElement subSubMenuOption2;


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
        //Adding wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public String validarMultiAutoComplete() {
        return getText(multipleColorValue);
    }

    public String validarSingleAutoComplete() {
        return getText(singleColorValue);
    }

    public void navegarPorMenu() {
        //Instanciar clase acción
        Actions actions = new Actions(driver);
        //Esperar a que el menu este mostrado
        wait.until(d -> menuOption.isDisplayed());
        //ir al WebElement 'Main' para realizar mouse hover
        scrollTo(menuOption);
        //Mouse hover menuOption 'Main'
        actions.moveToElement(menuOption).perform();
        System.out.println("Done Mouse hover on 'Main Item 2' from Menu");

        //Ahora seleccione "Submenú" del submenú que se muestra al pasar el ratón por encima del "submenú".
        //Mouse hover menuOption 'sub menu'
        actions.moveToElement(subMenuOption).perform();
        System.out.println("Done Mouse hover on 'SUB SUB LIST »' from Menu");
        //Ahora, finalmente, se muestra la lista de menús deseada de la que hay que seleccionar la opción deseada.

        //Luego selecciona intercaladamente 'sub sub menu' del sub menu
        for (int i = 0; i < 30; i++) {
            wait.until(d -> subSubMenuOption1.isDisplayed());
            actions.moveToElement(subSubMenuOption1).perform();
            wait.until(d -> subSubMenuOption2.isDisplayed());
            actions.moveToElement(subSubMenuOption2).perform();
        }

        System.out.println("Selected 'Sub Sub Item 1' from Menu");
        System.out.println("Selected 'Sub Sub Item 2' from Menu");
    }
}
