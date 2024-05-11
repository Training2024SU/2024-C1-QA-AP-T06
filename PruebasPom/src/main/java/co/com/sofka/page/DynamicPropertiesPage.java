package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DynamicPropertiesPage extends FunctionsCommons {
    private final By visibleAfterBtnLocator = By.id("visibleAfter");
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    @CacheLookup
    @FindBy(id = "colorChange")
    private WebElement enableAfterBtn;
    @CacheLookup
    @FindBy(id = "colorChange")
    private WebElement colorChangeBtn;


    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPrimerBotonHabilitado() {
        return wait.until(d -> enableAfterBtn.isEnabled());
    }

    public boolean isSegundoBotonRojo() {
        return colorChangeBtn.getAttribute("class").contains("text-danger");
    }

    public void esperarSegundoBotonEsRojo() {
        wait.until(d -> isSegundoBotonRojo());
    }

    public boolean isTercerBotonVisible() {
        WebElement boton = wait.until(visibilityOfElementLocated(visibleAfterBtnLocator));
        return boton.isDisplayed();
    }
}
