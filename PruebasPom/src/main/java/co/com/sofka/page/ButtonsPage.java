package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonsPage extends FunctionsCommons {

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private final By homeBtn = By.xpath("//*[@id='item-4']");
    private final By doubleClickBtn = By.id("doubleClickBtn");
    private final By rightClickBtn = By.id("rightClickBtn");
    private final By clickBtn = By.xpath("(//button[normalize-space()='Click Me'])[1]");
    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By dynamicClickMessage = By.id("dynamicClickMessage");


    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void gohomeBoton(){
        scrollTo(homeBtn);
        clickSelection(homeBtn);
    }
    public void clickBoton(){
        clickSelection(clickBtn);
    }


    public void dblClickButton() {
        doubleClick(doubleClickBtn);
    }

    public Boolean returnMessageDoubleClick() {
        return (getText(doubleClickMessage).equals("You have done a double click"));
    }

    public void rightClickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(rightClickBtn));
        rightClick(rightClickBtn);
    }

    public Boolean returnMessageRightClick() {
        wait.until(ExpectedConditions.elementToBeClickable(rightClickMessage));
        return (getText(rightClickMessage).equals("You have done a right click"));

    }

    public void clickButton() {
        clickSelection(clickBtn);
    }

    public Boolean returnMessageClick() {
        return (getText(dynamicClickMessage).equals("You have done a dynamic click"));
    }

}

