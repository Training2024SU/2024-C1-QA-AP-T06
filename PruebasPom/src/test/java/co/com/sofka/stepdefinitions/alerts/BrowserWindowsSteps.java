package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsFrameWindowsPage;
import co.com.sofka.page.BrowserWindowsPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.Constantes.MENSAJE_PESTANIA_VENTANA;
import static co.com.sofka.Constantes.MENSAJE_VENTANA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BrowserWindowsSteps extends WebSetup {
    private BrowserWindowsPage browserWindowsPage;

    @Given("El usuario esta en la pagina de ventanas de navegador {int}")
    public void elUsuarioEstaEnLaPaginaDeVentanasDeNavegador(int browser) {
        generalSetup(browser);
        PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
        pageFactoryMain.navegarAAlertas();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        alertsFrameWindowsPage.navegarABrowserWindowsPage();
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    @When("abre una nueva pestaña")
    public void abreUnaNuevaPestana() {
        browserWindowsPage.abrirNuevaPestania();
    }

    @Then("debería ver una nueva pestaña con un mensaje")
    public void deberiaVerUnaNuevaPestanaConUnMensaje() {
        assertThat(MENSAJE_PESTANIA_VENTANA,
                is(equalTo(browserWindowsPage.obtenerMensajeDePestania())));
    }

    @When("abre una nueva ventana")
    public void abreUnaNuevaVentana() {
        browserWindowsPage.abrirNuevaVentana();
    }

    @Then("debería ver una nueva ventana con un mensaje")
    public void deberiaVerUnaNuevaVentanaConUnMensaje() {
        assertThat(MENSAJE_PESTANIA_VENTANA,
                is(equalTo(browserWindowsPage.obtenerMensajeDeVentana())));
    }

    @When("abre una nueva ventana de mensaje")
    public void abreUnaNuevaVentanaDeMensaje() {
        browserWindowsPage.abrirNuevaVentanaDeMensaje();
    }

    @Then("debería ver una nueva ventana de mensaje")
    public void deberiaVerUnaNuevaVentanaDeMensaje() {
        assertThat(
                MENSAJE_VENTANA,
                is(equalTo(browserWindowsPage.obtenerMensajeDeNuevaVentanaDeMensaje()))
        );
    }
}
