package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResizablePage extends FunctionsCommons {

    private final int minSizeX = -50;

    private final int minSizey = -50;

    private final int maxSizeX = 400;

    private final int maxSizey = 200;

    private final int maxSizeNotLimity = 100;


    public ResizablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // localizadores
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Interactions')]/ancestor::div[@class='element-group'] //li[@id='item-2']")
    private WebElement resizable;

    @CacheLookup
    @FindBy(className = "constraint-area")
    private WebElement bigBox;

    @CacheLookup
    @FindBy(id = "resizableBoxWithRestriction")
    private WebElement limitBox;

    @CacheLookup
    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']//span")
    private WebElement resizableHandleLimit;

    @CacheLookup
    @FindBy(xpath = "//div[@id='resizable']//span")
    private WebElement resizableHandle;
    @CacheLookup
    @FindBy(id = "resizable")
    private WebElement notLimitBox;




    //funciones
    public void irARedimensionar(){
        scrollTo(resizable);
        clickSelection(resizable);
    }

    //funciones
    public void minSizeLimitBox(){
        scrollTo(bigBox);
        ewait.until(ExpectedConditions.elementToBeClickable(resizableHandleLimit));
        moveByOffset(resizableHandleLimit,minSizeX,minSizey);
    }

    public void maxSizeLimitBox(){
        scrollTo(bigBox);
        ewait.until(ExpectedConditions.elementToBeClickable(resizableHandleLimit));
        moveByOffset(resizableHandleLimit,maxSizeX,maxSizey);
    }

    public void minNotLimitBox(){
        scrollTo(notLimitBox);
        ewait.until(ExpectedConditions.elementToBeClickable(resizableHandle));
        moveByOffset(resizableHandle,minSizeX,minSizey);
    }

    public void maxNotLimitBox(){
        ewait.until(ExpectedConditions.elementToBeClickable(resizableHandle));
        moveByOffset(resizableHandle, maxSizeX,maxSizeNotLimity);
    }

    public int getWidthLimitBoxSixe(){
        return getElementWidth(limitBox);
    }

    public int getHeightLimitBoxSixe(){
        return getElementHeight(limitBox);
    }

    public int getWidthNotLimitBoxSixe(){
        return getElementWidth(notLimitBox);
    }

    public int getHeighNotLimitBoxSixe(){
        return getElementHeight(notLimitBox);
    }

}
