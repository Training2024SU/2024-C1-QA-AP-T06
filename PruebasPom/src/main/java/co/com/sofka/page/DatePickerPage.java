package co.com.sofka.page;

import co.com.sofka.page.components.ReactDatePicker;
import co.com.sofka.page.components.ReactDateTimePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DatePickerPage {
    private final WebDriver driver;
    private final By datePopupLocator = By.cssSelector(".react-datepicker-popper");

    @CacheLookup
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement dateInput;

    @CacheLookup
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateTimeInput;

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pickDate(LocalDate date) {
        dateInput.click();
        WebElement datePickerPopup = driver.findElement(datePopupLocator);
        ReactDatePicker datePicker = new ReactDatePicker(datePickerPopup);
        datePicker.setDate(date);
    }

    public String getDateText() {
        return dateInput.getDomProperty("value");
    }

    public void pickDateTime(LocalDateTime dateTime) {
        dateTimeInput.click();
        WebElement datePickerPopup = driver.findElement(datePopupLocator);
        ReactDateTimePicker dateTimePicker = new ReactDateTimePicker(datePickerPopup,
                (JavascriptExecutor) driver);
        dateTimePicker.setDateTime(dateTime);
    }

    public String getDateTimeText() {
        return dateTimeInput.getDomProperty("value");
    }
}
