package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenPage extends FunctionsCommons {

    //Localizadores
    @CacheLookup
    @FindBy(xpath = "(//*[@id='item-6'])[1]")
    private WebElement BROKEN_LINKS;

    @CacheLookup
    @FindBy(xpath = "(//*[@src='/images/Toolsqa.jpg'])[2]")
    private WebElement IMAGEN_FUNCIONAL;

    @CacheLookup
    @FindBy(xpath = "(//*[@src='/images/Toolsqa_1.jpg'])")
    private WebElement BROKEN_IMAGE;

    @CacheLookup
    @FindBy(xpath = "(//*[text()='Click Here for Valid Link'])")
    private WebElement LINK_FUNCIONAL;

    @CacheLookup
    @FindBy(xpath = "(//*[text()='Click Here for Broken Link'])")
    private WebElement LINK_ROTO;


    //constructor
    public BrokenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    //Funciones
    public void abrirBrokenLinksImages() {
        scrollTo(BROKEN_LINKS);
        clickSelection(BROKEN_LINKS);
    }

    public boolean validarImageneFuncional() {
        try {
            scrollTo(IMAGEN_FUNCIONAL);
            waitToBeVisible(IMAGEN_FUNCIONAL);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean validarImageneNoFuncional() {
        try {
            scrollTo(BROKEN_IMAGE);
            waitToBeVisible(BROKEN_IMAGE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void goToImagenValido() {
        scrollTo(BROKEN_IMAGE);

    }

    public void goToImagenInvalido() {
        scrollTo(BROKEN_IMAGE);

    }

    public void goToLinkInvalido() {
        scrollTo(LINK_ROTO);
        clickSelection(LINK_ROTO);
    }

    public void goToLinkValido() {
        scrollTo(LINK_FUNCIONAL);
        clickSelection(LINK_FUNCIONAL);
    }

}
