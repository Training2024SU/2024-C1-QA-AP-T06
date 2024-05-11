package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragabblePage extends FunctionsCommons {
    @CacheLookup
    @FindBy(xpath = "//div[contains(string(), \"Interactions\") and contains(@class, 'top-card')]")
    private WebElement seccionInteraccion;
    @CacheLookup
    @FindBy(xpath = "//li[contains(string(), \"Dragabble\") and contains(@class, 'btn-light')]")
    private WebElement seccionDragabble;
    @CacheLookup
    @FindBy(xpath = "//div[@id='dragBox']")
    public WebElement dragabbleSimpleElemento;
    @CacheLookup
    @FindBy(xpath = "//div[@id='restrictedX']")
    private WebElement dragabbleElementoAxisRetrictedX;
    @CacheLookup
    @FindBy(xpath = "//div[@id='restrictedY']")
    private WebElement dragabbleElementoAxisRetrictedY;
    @CacheLookup
    @FindBy(xpath = "//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']")
    private WebElement dragElementRestrictedUpside;
    @CacheLookup
    @FindBy(xpath = "//span[@class='ui-widget-header ui-draggable ui-draggable-handle']")
    private WebElement dragElementRestrictedDownSide;
    @CacheLookup
    @FindBy(xpath = "//div[@id='cursorCenter']")
    private WebElement dragElementRestrictedCenter;
    @CacheLookup
    @FindBy(xpath = "//div[@id='cursorTopLeft']")
    private WebElement dragElementRestrictedTopLeft;
    @CacheLookup
    @FindBy(xpath = "//div[@id='cursorBottom']")
    private WebElement dragElementRestrictedCursorBottom;
    private String selectorOpcionDragable = "//nav[@role='tablist']/a";
    
    public DragabblePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void ingresarASeccionDragabble(){
        scrollTo(seccionDragabble);
        clickSelection(seccionDragabble);
    }
    public void abrirDragableNavPorPosicion(int posicion){
        clickSelection(opcionDragable(posicion));
    }

    private WebElement opcionDragable(int posicion){
        return driver.findElement(By.xpath(selectorOpcionDragable + "[" + posicion + "]"));
    }
    protected void dragCoordinates(WebElement element, int targetX, int targetY){
        Actions action = new Actions(driver);
        action.clickAndHold(element)
                .moveToElement(element, targetX, targetY)
                .release()
                .build()
                .perform();
    }
    public void moverElElementoDraggableSimple(){
        dragabbleSimpleElemento.click();
        dragCoordinates(dragabbleSimpleElemento, 500, 500);
    }
    public void moverElElementoDraggableAxisRestricted(){
        dragabbleElementoAxisRetrictedX.click();
        dragCoordinates(dragabbleElementoAxisRetrictedX, 400, 0);
        dragabbleElementoAxisRetrictedY.click();
        dragCoordinates(dragabbleElementoAxisRetrictedY, 0, 400);
    }

    public void moverElementosContainerRestricted(){
        dragElementRestrictedUpside.click();
        dragCoordinates(dragElementRestrictedUpside, 350, 100);

        dragElementRestrictedDownSide.click();
        dragCoordinates(dragElementRestrictedDownSide, 10, 100);
    }
    public void moverElementosCursorStyle(){
        dragElementRestrictedCenter.click();
        dragCoordinates(dragElementRestrictedCenter, 350, 150);

        dragElementRestrictedTopLeft.click();
        dragCoordinates(dragElementRestrictedTopLeft, 300, 200);

        dragElementRestrictedCursorBottom.click();
        dragCoordinates(dragElementRestrictedCursorBottom, 200, 300);
    }
}
