package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.WidgetsPage;
import co.com.sofka.page.components.ReactionWidgets;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.VALOR_ACCORDIAN;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccordianStepDefinition extends WebSetup {
    ReactionWidgets reactionWidgets = new ReactionWidgets(driver);

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
            reactionWidgets.selecionAccordian(10);
            System.err.println("Se ejecuta la funcion Accordian");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia moverse automaticamente")
    public void deberiaMoverseAutomaticamente() {
        try {
            assertThat(reactionWidgets.validarAccordian(),containsString(VALOR_ACCORDIAN));
            Assertions.assertTrue(reactionWidgets.estadoDesplegado(2));
            System.err.println("Asercion Acordian");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
