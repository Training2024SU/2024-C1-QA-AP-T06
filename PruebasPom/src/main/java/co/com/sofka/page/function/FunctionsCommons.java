package co.com.sofka.page.function;

import org.openqa.selenium.*;
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

    protected void limpiarCampo(By locator){driver.findElement(locator).clear();}

    protected void limpiarCampo(WebElement locator){locator.clear();}

    public void waitSeconds(int seconds) {
        //NO FUNCIONA CON MODULOS WEBS CON ALERTAS
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);
        try{
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (Exception e){
        }
    }
    protected void waitToBeVisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void switchToIframe(WebElement locator){
        driver.switchTo().frame(locator);
    }
    public void switchToPagina(WebElement locator){
        driver.switchTo().defaultContent();
    }
}
