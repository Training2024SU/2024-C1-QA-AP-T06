package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends FunctionsCommons {
    @CacheLookup
    @FindBy(xpath = "//input[@type='range']")
    private WebElement slider;

    public SliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void moverSlider(int pixeles) throws InterruptedException {
        moverElementoEnEjeX(slider, pixeles);
    }
    public int numeroInput(){
        return Integer.parseInt(slider.getAttribute("value"));
    }
}
