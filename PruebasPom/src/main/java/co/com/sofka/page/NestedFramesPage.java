package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends FunctionsCommons {
    @CacheLookup
    @FindBy(id = "frame1")
    private WebElement parentFrame;
    @CacheLookup
    @FindBy(xpath = "//body[text()='Parent frame']")
    private WebElement mensajeParentFrame;
    @CacheLookup
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame;
    @CacheLookup
    @FindBy(xpath = "//p[text()='Child Iframe']")
    private WebElement mensajeChildFrame;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void switchToParentFrame(){
        scrollTo(parentFrame);
        waitToBeVisible(parentFrame);
        switchToIframe(parentFrame);
    }
    public void switchToChildFrame(){
        scrollTo(childFrame);
        waitToBeVisible(childFrame);
        switchToIframe(childFrame);
    }
    public String obtenerMensajeDeParentFrame(){
        waitToBeVisible(mensajeParentFrame);
        return getText(mensajeParentFrame);
    }
    public String obtenerMensajeDeChildFrame(){
        waitToBeVisible(mensajeChildFrame);
        return getText(mensajeChildFrame);
    }
}
