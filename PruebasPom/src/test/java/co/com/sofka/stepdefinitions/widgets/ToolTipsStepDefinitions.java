package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.PageFactoryToolTips;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ToolTipsStepDefinitions extends WebSetup {
    PageFactoryToolTips pageFactoryToolTips;

    @When("se dirije a la pagina toolTips")
    public void seDirijeALaPaginaToolTips() {
        pageFactoryToolTips = new PageFactoryToolTips(driver);
        pageFactoryToolTips.irPaginaToolTisp();
    }
    @When("ingresa el texto {string} en el campo de texto")
    public void ingresaElTextoEnElCampoDeTexto(String text) {
        pageFactoryToolTips = new PageFactoryToolTips(driver);
        pageFactoryToolTips.ingresarTexto(text);
    }
    @Then("deberia ver el texto ingresado en el campo")
    public void deberiaVerElTextoIngresadoEnElCampo() {
        pageFactoryToolTips = new PageFactoryToolTips(driver);
        Assert.assertTrue(pageFactoryToolTips.contieneTexto().isEmpty());
    }
}
