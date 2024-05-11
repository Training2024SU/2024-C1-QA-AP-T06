package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsWindowsPage;
import co.com.sofka.page.FramesPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.MENSAJE_ESPERADO_FRAME;

public class FramesStepDefinition extends WebSetup {
    PageFactoryMain pageFactoryMain;
    AlertsWindowsPage alertsWindowsPage;
    FramesPage framesPage;

    @Given("El usuario esta en la pagina de inicio {int}")
    public void elUsuarioEstaEnLaPaginaDeInicio(Integer driverType) {
        try {
            generalSetup(driverType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("ingresa hasta el apartado de frames")
    public void ingresaHastaElApartadoDeFrames() {
        try {
            pageFactoryMain = new PageFactoryMain(driver);
            alertsWindowsPage = new AlertsWindowsPage(driver);
            pageFactoryMain.navegarAAlertas();
            alertsWindowsPage.irAFrames();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("navega dentro de los iframe presentes")
    public void navegaDentroDeLosIframePresentes() {
        try {
            framesPage = new FramesPage(driver);
            framesPage.switchToFrame1();
            framesPage.switchToPaginaPrincipal();
            framesPage.switchToFrame2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }

    @Then("debería ver el mensaje dentro de los iframe")
    public void deberíaVerElMensajeDentroDeLosIframe() {
        try {
            String mensajeActual = framesPage.obtenerMensajeDeFrame();
            Assertions.assertEquals(MENSAJE_ESPERADO_FRAME, mensajeActual);
            System.out.println(mensajeActual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
