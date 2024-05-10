package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsWindowsPage;
import co.com.sofka.page.NestedFramesPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.MENSAJE_ESPERADO_CHILD_FRAME;
import static co.com.sofka.Constantes.MENSAJE_ESPERADO_PARENT_FRAME;

public class NestedFramesStepDefinition extends WebSetup {
    PageFactoryMain pageFactoryMain;
    AlertsWindowsPage alertsWindowsPage;
    NestedFramesPage nestedFramesPage;
    String mensajeEsperadoParentFrame;
    String mensajeEsperadoChildFrame;

    @When("ingresa hasta el apartado de nested frames")
    public void ingresaHastaElApartadoDeNestedFrames() {
        try {
            pageFactoryMain = new PageFactoryMain(driver);
            alertsWindowsPage = new AlertsWindowsPage(driver);
            pageFactoryMain.navegarAAlertas();
            alertsWindowsPage.irANestedFrames();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("navega dentro de los iframe anidados")
    public void navegaDentroDeLosIframeAnidados() {
        try {
            nestedFramesPage = new NestedFramesPage(driver);
            nestedFramesPage.switchToParentFrame();
            mensajeEsperadoParentFrame = nestedFramesPage.obtenerMensajeDeParentFrame();
            nestedFramesPage.switchToChildFrame();
            mensajeEsperadoChildFrame = nestedFramesPage.obtenerMensajeDeChildFrame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("debería ver el mensaje dentro del iframe parent y iframe child")
    public void deberíaVerElMensajeDentroDelIframeParentYIframeChild() {
        try {
            Assertions.assertEquals(mensajeEsperadoParentFrame, MENSAJE_ESPERADO_PARENT_FRAME);
            Assertions.assertEquals(mensajeEsperadoChildFrame, MENSAJE_ESPERADO_CHILD_FRAME);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }
}
