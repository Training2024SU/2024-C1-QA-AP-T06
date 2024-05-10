package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.DatePickerPage;
import co.com.sofka.page.function.WidgetsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class AccordianStepDefinition extends WebSetup {

    @Given("el usuario se dirige a la página widget Accordian")
    public void elUsuarioSeDirigeALaPáginaWidgetAccordian() {
        try {
            WidgetsPage widgetsPage = new WidgetsPage(driver);
            widgetsPage.navegarAccordian();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("quiere utilizar el Accordian")
    public void quiereUtilizarElAccordian() {
        try {
            System.err.println("Se llama a la funcion seleccion");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia moverse automaticamente")
    public void deberiaMoverseAutomaticamente() {
        try {
            System.err.println("Asercion Acordian");
            //Assertions.assertEquals(textoFecha, datePickerPage.getDateText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
