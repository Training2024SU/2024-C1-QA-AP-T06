package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.DynamicPropertiesPage;
import co.com.sofka.page.ElementsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DynamicPropertiesStep extends WebSetup {
    DynamicPropertiesPage dynamicPropertiesPage;

    @When("El usuario accede a la opción de propiedades dinámicas")
    public void elUsuarioAccedeALaOpcionDePropiedadesDinamicas() {
        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.navegarADynamicProperties();
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @And("Espera a que las propiedades de los elementos cambien")
    public void esperaAQueLasPropiedadesDeLosElementosCambien() {
        dynamicPropertiesPage.esperarSegundoBotonEsRojo();
    }

    @Then("debería ver los elementos actualizarse")
    public void deberiaVerLosElementosActualizarse() {
        Assertions.assertTrue(dynamicPropertiesPage.isPrimerBotonHabilitado());
        Assertions.assertTrue(dynamicPropertiesPage.isSegundoBotonRojo());
        Assertions.assertTrue(dynamicPropertiesPage.isTercerBotonVisible());
    }
}
