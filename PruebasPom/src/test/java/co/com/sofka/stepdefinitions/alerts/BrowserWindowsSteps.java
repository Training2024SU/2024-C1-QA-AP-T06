package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsFrameWindowsPage;
import co.com.sofka.page.BrowserWindowsPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static co.com.sofka.Constantes.MENSAJE_PESTANIA_VENTANA;
import static co.com.sofka.Constantes.MENSAJE_VENTANA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BrowserWindowsSteps extends WebSetup {
    private BrowserWindowsPage browserWindowsPage;

    @Given("El usuario esta en la pagina de ventanas de navegador {int}")
    public void elUsuarioEstaEnLaPaginaDeVentanasDeNavegador(int browser) {
        try {
            generalSetup(browser);
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryMain.navegarAAlertas();
            AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
            alertsFrameWindowsPage.navegarABrowserWindowsPage();
            browserWindowsPage = new BrowserWindowsPage(driver);
        } catch (Exception e) {
            quiteDrive();
            Assert.fail();
        }

    }

    @When("abre una nueva pestaña")
    public void abreUnaNuevaPestana() {
        try {
            browserWindowsPage.abrirNuevaPestania();
        } catch (Exception e) {
            quiteDrive();
            Assert.fail();
        }
    }

    @Then("debería ver una nueva pestaña con un mensaje")
    public void deberiaVerUnaNuevaPestanaConUnMensaje() {
        try {
            assertThat(MENSAJE_PESTANIA_VENTANA,
                    is(equalTo(browserWindowsPage.obtenerMensajeDePestania())));
        } catch (Exception e) {
            Assert.fail();
        } finally {
            quiteDrive();
        }

    }

    @When("abre una nueva ventana")
    public void abreUnaNuevaVentana() {
        try {
            browserWindowsPage.abrirNuevaVentana();
        } catch (Exception e) {
            quiteDrive();
            Assert.fail();
        }

    }

    @Then("debería ver una nueva ventana con un mensaje")
    public void deberiaVerUnaNuevaVentanaConUnMensaje() {
        try {
            assertThat(MENSAJE_PESTANIA_VENTANA,
                    is(equalTo(browserWindowsPage.obtenerMensajeDeVentana())));
        } catch (Exception e) {
            Assert.fail();
        }finally {
            quiteDrive();
        }

    }

    @When("abre una nueva ventana de mensaje")
    public void abreUnaNuevaVentanaDeMensaje() {
        try {
            browserWindowsPage.abrirNuevaVentanaDeMensaje();
        } catch (Exception e) {
            quiteDrive();
            Assert.fail();
        }

    }

    @Then("debería ver una nueva ventana de mensaje")
    public void deberiaVerUnaNuevaVentanaDeMensaje() {
        try {
            assertThat(
                    MENSAJE_VENTANA,
                    is(equalTo(browserWindowsPage.obtenerMensajeDeNuevaVentanaDeMensaje()))
            );
        } catch (Exception e) {
            Assert.fail();
        }finally {
            quiteDrive();
        }

    }
}
