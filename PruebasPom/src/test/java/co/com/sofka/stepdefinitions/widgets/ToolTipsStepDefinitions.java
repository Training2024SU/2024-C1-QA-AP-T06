package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.PageFactoryToolTips;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class ToolTipsStepDefinitions extends WebSetup {
    PageFactoryToolTips pageFactoryToolTips;

    @When("se dirije a la pagina toolTips")
    public void seDirijeALaPaginaToolTips() {
        try {
            pageFactoryToolTips = new PageFactoryToolTips(driver);
            pageFactoryToolTips.irPaginaToolTisp();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("ingresa el texto {string} en el campo de texto")
    public void ingresaElTextoEnElCampoDeTexto(String text) {
        try {
            pageFactoryToolTips = new PageFactoryToolTips(driver);
            pageFactoryToolTips.ingresarTexto(text);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia ver el texto ingresado en el campo")
    public void deberiaVerElTextoIngresadoEnElCampo() {
        try {
            pageFactoryToolTips = new PageFactoryToolTips(driver);
            Assert.assertTrue(pageFactoryToolTips.contieneTexto().isEmpty());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
