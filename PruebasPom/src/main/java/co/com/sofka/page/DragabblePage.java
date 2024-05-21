package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragabblePage extends FunctionsCommons {
    //Localizadores
    @CacheLookup
    @FindBy(xpath = "//div[contains(string(), 'Interactions') and contains(@class, 'top-card')]")
    private WebElement seccionInteraccion;
    @CacheLookup
    @FindBy(xpath = "//li[contains(string(), 'Dragabble') and contains(@class, 'btn-light')]")
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

    //Constructor
    public DragabblePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Funciones
    public void ingresarASeccionDragabble(){
        scrollTo(seccionDragabble);
        clickSelection(seccionDragabble);
    }
    public void abrirDragableNavPorPosicion(int posicion){
        clickSelection(opcionDragable(posicion));
    }

    private WebElement opcionDragable(int posicion){
        String selectorOpcionDragable = "//nav[@role='tablist']/a";
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
        scrollTo(dragabbleSimpleElemento);
        dragabbleSimpleElemento.click();
        dragCoordinates(dragabbleSimpleElemento, 100, 50);
    }
    public void moverElElementoDraggableAxisRestricted(){
        scrollTo(dragabbleElementoAxisRetrictedX);
        dragabbleElementoAxisRetrictedX.click();
        dragCoordinates(dragabbleElementoAxisRetrictedX, 50, 0);
        dragabbleElementoAxisRetrictedY.click();
        dragCoordinates(dragabbleElementoAxisRetrictedY, 0, 50);
    }
    public void moverElementosContainerRestricted(){
        scrollTo(dragElementRestrictedUpside);
        dragElementRestrictedUpside.click();
        dragCoordinates(dragElementRestrictedUpside, 100, 50);
        scrollTo(dragElementRestrictedDownSide);
        dragElementRestrictedDownSide.click();
        dragCoordinates(dragElementRestrictedDownSide, 10, 50);
    }
    public void moverElementosCursorStyle(){
        scrollTo(dragElementRestrictedCenter);
        dragElementRestrictedCenter.click();
        dragCoordinates(dragElementRestrictedCenter, 100, 50);

        scrollTo(dragElementRestrictedTopLeft);
        dragElementRestrictedTopLeft.click();
        dragCoordinates(dragElementRestrictedTopLeft, 100, 50);

        scrollTo(dragElementRestrictedCursorBottom);
        dragElementRestrictedCursorBottom.click();
        dragCoordinates(dragElementRestrictedCursorBottom, 100, 50);
    }
}
