package co.com.sofka.page.components;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public String validarAccordian(){
        return getText(mensajeAccordian);
    }
    public boolean estadDesplegado(int indice){
        WebElement carta = cartas.get(indice);
        WebElement contenido = carta.findElement(By.xpath("./following-sibling::div"));
        wait.until(d -> contenido.getAttribute("class").contains("show"));
        return contenido.getAttribute("class").contains("show");
    }
}
