package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.CheckRadioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.MENSAJE_ESPERADO_CHECK_BOX;
import static co.com.sofka.Constantes.MENSAJE_ESPERADO_RADIO;

public class RadioBotonStepDefinitions extends WebSetup {

    CheckRadioPage checkRadioPage;

    @Given("el usuario accede a la sección de botones de radio")
<<<<<<< HEAD
    public void elUsuarioAccedeALaSeccionDeBotonesDeRadio() {
        checkRadioPage = new CheckRadioPage(driver);
        checkRadioPage.seleccionarOpcionRadioButton();

=======
    public void elUsuarioAccedeALaSecciónDeBotonesDeRadio() {
        try {
            checkRadioPage = new CheckRadioPage(driver);
            checkRadioPage.seleccionarOpcionRadioButton();
        } catch (Exception e) {
            System.out.println("Error durante la seleccion de las opciones tipo radio: " + e.getMessage());
            quiteDrive(); // Quit driver session in case of error
            Assertions.fail("Fallo al intentar inicializar la pagina: " + e.getMessage());
        }
>>>>>>> solucion
    }

    @When("selecciona las opciones de radio")
    public void seleccionaLasOpcionesDeRadio() {
        try {
           checkRadioPage.seleccionarOpcionesRadio();
        } catch (Exception e) {
            System.out.println("Error durante la seleccion de botones tipo radio: " + e.getMessage());
            quiteDrive(); // Quit driver session in case of error
            Assertions.fail("Fallo al intentar seleccionar botones tipo radio: " + e.getMessage());
        }
    }

    @Then("debería ver un mensaje correspondiente al boton de radio seleccionado")
    public void deberíaVerUnMensajeCorrespondienteAlBotonDeRadioSeleccionado() {
        try {
            String mensajeActual = checkRadioPage.obtenerRadioBotonMensaje();
            Assert.assertEquals(MENSAJE_ESPERADO_RADIO, mensajeActual);
        } catch (Exception e) {
            System.out.println("Error durante la verificacion del mensaje esperado: " + e.getMessage());
            quiteDrive(); // Quit driver session in case of error
            Assertions.fail("Fallo al intentar verificar el mensaje: " + e.getMessage());
        }
        finally {
            quiteDrive();
        }
    }
}
