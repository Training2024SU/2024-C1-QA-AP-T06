package co.com.sofka.page.function;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FunctionsCommons {
    protected final WebDriver driver;

    public FunctionsCommons(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void typeInto(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickSelection(By locator) {
        driver.findElement(locator).click();
    }

    protected void clickSelection(WebElement element) {
        element.click();
    }

    protected void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    protected void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void cleanField(WebElement element) {
        element.clear();
    }

    protected void scrollTo(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getText(Alert alert) {
        return alert.getText();
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void limpiarCampo(By locator) {
        driver.findElement(locator).clear();
    }

    protected void limpiarCampo(WebElement locator) {
        locator.clear();
    }

    public void waitSeconds(int seconds) {
        // NO FUNCIONA CON MÓDULOS WEBS CON ALERTAS
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            // Manejar la excepción, si es necesario
        }
    }

    protected void waitToBeClickeable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
    }
    protected void waitToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    protected void clickHolding(By draggable, By droppable) {
        WebElement sourceElement = driver.findElement(draggable);
        WebElement targetElement = driver.findElement(droppable);
        Point targetLocation = targetElement.getLocation();
        int targetX = targetLocation.getX();
        int targetY = targetLocation.getY();
        int xOffset = targetX - sourceElement.getLocation().getX() + 10;
        int yOffset = targetY - sourceElement.getLocation().getY() + 10;

        new Actions(driver)
                .clickAndHold(sourceElement)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build()
                .perform();

        //new Actions(driver).dragAndDrop(sourceElement,targetElement).perform();

    }

    protected void moveElementsBy(By dragLocator, By dropLocator) {
        WebElement dragElement = driver.findElement(dragLocator);
        WebElement dropZone = driver.findElement(dropLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(dragElement).clickAndHold().moveToElement(dropZone).release().perform();
    }

    protected void dragAndDropBy(By locator, int ejeX, int ejeY) {
        WebElement draggable = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, ejeX, ejeY).perform();
    }

    protected void dragAndDrop(By dragLocator, By dropLocator) {
        WebElement dragElement = driver.findElement(dragLocator);
        WebElement dropZone = driver.findElement(dropLocator);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement, dropZone).perform();
    }

    public void switchToIframe(WebElement locator) {
        driver.switchTo().frame(locator);
    }

    public void switchToPagina(WebElement locator) {
        driver.switchTo().defaultContent();
    }

    public void moverElementoEnEjeX(WebElement locator, int pixeles) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(locator).moveByOffset(pixeles, 0).release().perform();
    }
    public void moverElementoEnEjeX(By locator, int pixeles) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(locator)).moveByOffset(pixeles, 0).release().perform();
    }

    protected void typeKey(WebElement webElement, Keys value) {
        webElement.sendKeys(value);
    }

    protected void typeKey(By locator, Keys value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearInput(By locator) {
        driver.findElement(locator).clear();
    }

    protected void clearInput(WebElement webElement) {
        webElement.clear();
    }

    protected void clickHoldAndMoveVertically(WebElement element, int yOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element)
                .moveByOffset(0, yOffset)
                .release()
                .perform();
    }

    protected void moveToElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement, webElement.getLocation().getX(), webElement.getLocation().getY()).perform();
    }

    protected void clickAndHold(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(webElement).perform();
    }

    protected void moveByOffset(WebElement webElement, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(webElement).moveByOffset(xOffset, yOffset).release().build().perform();
    }

    protected void clickAndHoldMoveToElement(By dragLocator, By dropLocator) {
        WebElement dragElement = driver.findElement(dragLocator);
        WebElement dropElement = driver.findElement(dropLocator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragElement)
                .moveToElement(dropElement)
                .release()
                .build()
                .perform();
    }

    public int getElementWidth(WebElement element) {
        return element.getSize().getWidth();
    }

    public int getElementHeight(WebElement element) {
        return element.getSize().getHeight();
    }

    protected void doubleClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    protected void rightClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
}

