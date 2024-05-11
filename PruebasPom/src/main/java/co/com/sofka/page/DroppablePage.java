package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DroppablePage extends FunctionsCommons {

    //Localizadores
    private final By FORMS_LINK = By.xpath("//h5[text()='Forms']");
    private final By INTERACTIONS_LIST = By.xpath("//div[text()='Interactions']");
    private final By DROPPABLE_LINK = By.xpath("//span[contains(@class, 'text') and contains(text(),'Droppable')]");
    private final By DRAGGABLE_BOX = By.id("draggable");
    private final By DROPPABLE_BOX = By.id("droppable");
    private final By DROPPABLE_BOX2 = By.cssSelector("#acceptDropContainer #droppable");
    private final By ACCEPTABLE_BOX = By.id("acceptable");
    private final By ACEPT_CASE = By.id("droppableExample-tab-accept");
    private final By PREVENT_PROPAGATION_BOTON = By.xpath("//a[@id='droppableExample-tab-preventPropogation']");
    private final By DRAG_BOX = By.id("dragBox");
    private final By DROP_ZONE = By.id("notGreedyInnerDropBox");
    private final By DROP_ZONE_GREDDY = By.id("greedyDropBoxInner");
    private final By REVERT_DRAGGABLE_BOTON = By.xpath("//a[@id='droppableExample-tab-revertable']");
    private final By WILL_REVERT_DRAG = By.id("revertable");
    private final By NOT_REVERT_DRAG = By.xpath("//div[@id='notRevertable']");
    private final By DROPPABLE_REVERT = By.cssSelector("#revertableDropContainer #droppable");
    private final By DROPPABLE_BOX_TEXT = By.xpath("//p[text()='Dropped!']");

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    // Funciones
    public void goToDroppable() {
        scrollTo(FORMS_LINK);
        clickSelection(FORMS_LINK);
        scrollTo(INTERACTIONS_LIST);
        clickSelection(INTERACTIONS_LIST);
        waitToBeVisible(driver.findElement(DROPPABLE_LINK));
        scrollTo(DROPPABLE_LINK);
        clickSelection(DROPPABLE_LINK);
    }

    public void holdClick() {
        scrollTo(DRAGGABLE_BOX);
        clickHolding(DRAGGABLE_BOX, DROPPABLE_BOX);
    }

    public void holdClickA() throws InterruptedException {
        scrollTo(ACEPT_CASE);
        clickSelection(ACEPT_CASE);
        scrollTo(ACCEPTABLE_BOX);
        scrollTo(DROPPABLE_BOX2);

        clickHolding(ACCEPTABLE_BOX, DROPPABLE_BOX2);
    }

    public String getMensaje() {
        WebElement droppableElement = driver.findElement(DROPPABLE_BOX);
        System.out.println(droppableElement.getText());
        return droppableElement.getText();
    }

    public String getMensajeA() {
        WebElement droppableElement = driver.findElement(DROPPABLE_BOX2);
        System.out.println(droppableElement.getText());
        return droppableElement.getText();
    }

    protected void dragCoordinates(WebElement element, int targetX, int targetY) {
        Actions action = new Actions(driver);
        action.clickAndHold(element)
                .moveToElement(element, targetX, targetY)
                .release()
                .build()
                .perform();
    }

    public void irAPreventPropagation() {
        clickSelection(PREVENT_PROPAGATION_BOTON);
    }

    public void irARevertDraggable() {
        clickSelection(REVERT_DRAGGABLE_BOTON);
    }

    public void dragHastaInnerDrop() {
        moveElementsBy(DRAG_BOX, DROP_ZONE);
    }

    public void dragHastaGreedyInnerDrop() {
        moveElementsBy(DRAG_BOX, DROP_ZONE_GREDDY);
    }

    public String mensajeDropZone() {
        WebElement dropZone = driver.findElement(DROP_ZONE);
        return dropZone.getText();
    }

    public String mensajeGreedyDropZone() {
        WebElement dropZoneGreedy = driver.findElement(DROP_ZONE_GREDDY);
        return dropZoneGreedy.getText();
    }

    public void dragWillRevertADropZone() {
        dragAndDropBy(WILL_REVERT_DRAG, 300, 0);
    }

    public void dragNotRevertADropZone() {
        waitToBeVisible(driver.findElement(NOT_REVERT_DRAG));
        waitToBeClickeable(NOT_REVERT_DRAG);
        moveElementsBy(NOT_REVERT_DRAG, DROPPABLE_REVERT);
    }

    public String obtenerTexto() {
        return driver.findElement(DROPPABLE_REVERT).getText();
    }
}
