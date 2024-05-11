package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.CheckRadioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CheckBoxStepDefinitions extends WebSetup {
        CheckRadioPage checkRadioPage;

    @Given("el usuario accede a la sección de casillas de verificación")
    public void elUsuarioAccedeALaSeccionDeCasillasDeVerificacion() {
        checkRadioPage = new CheckRadioPage(driver);
        checkRadioPage.seleccionarOpcionCheckBox();


    }
    @When("expande selecciona y reduce las casillas de verificación")
    public void expandeSeleccionaYReduceLasCasillasDeVerificacion() {

    }
    @Then("debería ver un mensaje con la cantidad de casillas seleccionadas")
    public void deberíaVerUnMensajeConLaCantidadDeCasillasSeleccionadas() {
    }
}
