package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.WidgetsPage;
import co.com.sofka.page.components.ReactionWidgets;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.VALOR_AQUA;
import static co.com.sofka.Constantes.VALOR_BLACK;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AutoCompleteStepDefinition extends WebSetup {
    ReactionWidgets reactionWidgets = new ReactionWidgets(driver);

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

    @When("quiere utilizar el auto complete {string} {string}")
    public void quiereUtilizarElAutoComplete(String aqua, String black) {
        try {
            reactionWidgets.llenarAutoComplete(aqua,black);
            System.err.println("Se ejecuta la funcion AutoComplete");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia completarse automaticamente")
    public void deberiaCompletarseAutomaticamente() {
        try {
            assertThat(reactionWidgets.validarMultiAutoComplete(),containsString(VALOR_AQUA));
            assertThat(reactionWidgets.validarSingleAutoComplete(),containsString(VALOR_BLACK));
            System.err.println("Asercion Autocomplete");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
