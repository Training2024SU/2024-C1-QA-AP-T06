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

public class MenuStepDefinition extends WebSetup {
    ReactionWidgets reactionWidgets = new ReactionWidgets(driver);

    @Given("el usuario se dirige a la página widget menu")
    public void elUsuarioSeDirigeALaPáginaWidgetMenu() {
        try {
            WidgetsPage widgetsPage = new WidgetsPage(driver);
            widgetsPage.navegarMenu();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("quiere navegar por el menu")
    public void quiereNavegarPorElMenu() {
        try {
            reactionWidgets.navegarPorMenu();
            System.err.println("Se ejecuta la funcionalidad del Menu");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia visualizarse el menu correcto")
    public void deberiaVisualizarseElMenuCorrecto() {
        try {

            System.err.println("Asercion Menu");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
