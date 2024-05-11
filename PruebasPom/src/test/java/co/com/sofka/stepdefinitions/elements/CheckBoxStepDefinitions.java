package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.CheckRadioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import static co.com.sofka.Constantes.MENSAJE_ESPERADO_CHECK_BOX;

public class CheckBoxStepDefinitions extends WebSetup {

    CheckRadioPage checkRadioPage;


    @Given("el usuario accede a la sección de casillas de verificación")
<<<<<<< HEAD
    public void elUsuarioAccedeALaSeccionDeCasillasDeVerificacion() {
=======
>>>>>>> 070c1d8af0f4b93da838ff5fa4e3950bc6a1f6a7

    public void elUsuarioAccedeALaSecciónDeCasillasDeVerificación() {
        try {
            checkRadioPage = new CheckRadioPage(driver);
            checkRadioPage.seleccionarOpcionCheckBox();
        } catch (Exception e) {
            System.out.println("Error durante la configuración de casillas de verificación: " + e.getMessage());
            quiteDrive();
            Assertions.fail("Falló al inicializar la página de casillas de verificación: " + e.getMessage());
        }
    }

    @When("expande selecciona y reduce las casillas de verificación")
<<<<<<< HEAD
    public void expandeSeleccionaYReduceLasCasillasDeVerificacion() {

=======
    public void expandeSeleccionaYReduceLasCasillasDeVerificación() {
        try {
           checkRadioPage.expandirSeleccionarDisminuir();
        } catch (Exception e) {
            System.out.println("Error durante la manipulacion de las cajas de seleccion: " + e.getMessage());
            quiteDrive();
            Assertions.fail("Fallo en la manipulacion de las cajas: " + e.getMessage());
        }
>>>>>>> 070c1d8af0f4b93da838ff5fa4e3950bc6a1f6a7
    }

    @Then("debería ver un mensaje con la cantidad de casillas seleccionadas")
<<<<<<< HEAD
    public void deberiaVerUnMensajeConLaCantidadDeCasillasSeleccionadas() {
=======
    public void deberíaVerUnMensajeConLaCantidadDeCasillasSeleccionadas() {
        try {
            String mensajeActual = checkRadioPage.obtenerCheckBoxMensaje();
            Assert.assertEquals(MENSAJE_ESPERADO_CHECK_BOX, mensajeActual);
        } catch (Exception e) {
            System.out.println("Error durante la verifiacion de las cajas de seleccion: " + e.getMessage());
            quiteDrive();
            Assertions.fail("Fallo al verificar las cajas de seleccion: " + e.getMessage());
        }
        finally {
            quiteDrive();
        }
>>>>>>> 070c1d8af0f4b93da838ff5fa4e3950bc6a1f6a7
    }
}
