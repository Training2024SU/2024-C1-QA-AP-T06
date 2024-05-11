package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends FunctionsCommons {
    @CacheLookup
    @FindBy(id = "frame1")
    private WebElement frame1;
    @CacheLookup
    @FindBy(id = "frame2")
    private WebElement frame2;
    @CacheLookup
    @FindBy(xpath = "//h1[@id='sampleHeading']")
    private WebElement mensajeIframe;

    public FramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void switchToFrame1(){
        scrollTo(frame1);
        switchToIframe(frame1);
    }
    public void switchToPaginaPrincipal(){
        driver.switchTo().defaultContent();
    }
    public void switchToFrame2(){
        scrollTo(frame2);
        switchToIframe(frame2);
    }
    public String obtenerMensajeDeFrame(){
        waitToBeVisible(mensajeIframe);
        return getText(mensajeIframe);
    }
}
