package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.CheckRadioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RadioBotonStepDefinitions extends WebSetup {
    CheckRadioPage checkRadioPage;

    @Given("el usuario accede a la sección de botones de radio")
    public void elUsuarioAccedeALaSecciónDeBotonesDeRadio() {
        checkRadioPage = new CheckRadioPage(driver);
        checkRadioPage.seleccionarOpcionRadioButton();

    }
    @When("selecciona las opciones de radio")
    public void seleccionaLasOpcionesDeRadio() {

    }
    @Then("debería ver un mensaje correspondiente al boton de radio seleccionado")
    public void deberíaVerUnMensajeCorrespondienteAlBotonDeRadioSeleccionado() {
    }
}
