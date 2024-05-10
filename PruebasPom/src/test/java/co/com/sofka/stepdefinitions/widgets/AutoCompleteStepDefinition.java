package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.function.WidgetsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AutoCompleteStepDefinition extends WebSetup {

    @Given("el usuario se dirige a la página widget Auto complete")
    public void elUsuarioSeDirigeALaPáginaWidgetAutoComplete() {
        try {
            WidgetsPage widgetsPage = new WidgetsPage(driver);
            widgetsPage.navegarAutoComplete();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("quiere utilizar el auto complete")
    public void quiereUtilizarElAutoComplete() {
        try {
            System.err.println("Se llama a la funcion seleccion");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("deberia completarse automaticamente")
    public void deberiaCompletarseAutomaticamente() {
        try {
            System.err.println("Asercion Autocomplete");
            //Assertions.assertEquals(textoFecha, datePickerPage.getDateText());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
