package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.DatePickerPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.page.function.FunctionsCommons;
import co.com.sofka.page.function.WidgetsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimePickersSteps extends WebSetup {
    private DatePickerPage datePickerPage;

    @Given("El usuario esta en la pagina web de widgets demoqa {int}")
    public void elUsuarioEstaEnLaPaginaWebDeWidgetsDemoqa(int browser) {
        generalSetup(browser);
        PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
        pageFactoryMain.navegarAWidgets();
    }

    @Given("El usuario accede a los widgets de fecha y hora")
    public void elUsuarioAccedeALosWidgetsDeFechaYHora() {
        try {
            WidgetsPage widgetsPage = new WidgetsPage(driver);
            widgetsPage.navegarADatePickerPage();
            datePickerPage = new DatePickerPage(driver);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("selecciona la fecha: {string}")
    public void seleccionaLaFecha(String fecha) {
        try {
            LocalDate localDate = LocalDate.parse(fecha);
            datePickerPage.pickDate(localDate);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("debería ver el campo de fecha llenado con {string}")
    public void deberiaVerElCampoDeFechaLlenadoCon(String textoFecha) {
        try {
            Assertions.assertEquals(textoFecha, datePickerPage.getDateText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }

    @When("selecciona la fecha y hora: {string}")
    public void seleccionaLaFechaYHora(String dateTime) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
            datePickerPage.pickDateTime(localDateTime);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("debería ver el campo de fechaHora llenado con {string}")
    public void deberiaVerElCampoDeFechaHoraLlenadoCon(String textoFechaHora) {
        try {
            Assertions.assertEquals(textoFechaHora, datePickerPage.getDateTimeText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
