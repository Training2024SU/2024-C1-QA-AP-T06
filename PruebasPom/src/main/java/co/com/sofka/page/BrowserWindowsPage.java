package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class BrowserWindowsPage extends FunctionsCommons {
    private final String originalWindow;
    private final By mensajePestaniaOVentana = By.id("sampleHeading");
    private final By mensajeVentanaMensaje = By.tagName("body");
    @CacheLookup
    private WebElement tabButton;
    @CacheLookup
    private WebElement windowButton;
    @CacheLookup
    private WebElement messageWindowButton;


    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        originalWindow = driver.getWindowHandle();
    }

    public void abrirNuevaPestania() {
        tabButton.click();
    }

    public void abrirNuevaVentana() {
        windowButton.click();
    }

    public void abrirNuevaVentanaDeMensaje() {
        messageWindowButton.click();
    }

    public String obtenerMensajeDePestania() {
        irANuevaPestaniaOVentana();
        return getText(mensajePestaniaOVentana);
    }

    public String obtenerMensajeDeVentana() {
        irANuevaPestaniaOVentana();
        return getText(mensajePestaniaOVentana);
    }

    public String obtenerMensajeDeNuevaVentanaDeMensaje() {
        irANuevaPestaniaOVentana();
        return getText(mensajeVentanaMensaje);
    }

    private void irANuevaPestaniaOVentana() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
