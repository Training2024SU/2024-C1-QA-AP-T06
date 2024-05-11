package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsWindowsPage;
import co.com.sofka.page.ModalDialogsPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ModalDialogsStepDefinition extends WebSetup {
    PageFactoryMain pageFactoryMain;
    AlertsWindowsPage alertsWindowsPage;
    ModalDialogsPage modalDialogsPage;
    String tituloSmallDialag;
    String tituloLargeModal;

    @Given("El usuario esta en la pagina de inicio de demoqa {int}")
    public void elUsuarioEstaEnLaPaginaDeInicioDeDemoqa(Integer driverType) {
        try {
            generalSetup(driverType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("Navega hasta el apartado de modal dialogs")
    public void navegaHastaElApartadoDeModalDialogs() {
        try {
            pageFactoryMain = new PageFactoryMain(driver);
            alertsWindowsPage = new AlertsWindowsPage(driver);
            pageFactoryMain.navegarAAlertas();
            alertsWindowsPage.irAModalDialogs();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("hace clic sobre los tipo de modal dialog")
    public void haceClicSobreLosTipoDeModalDialog() {
        try {
            modalDialogsPage = new ModalDialogsPage(driver);
            modalDialogsPage.clickSmallModal();
            tituloSmallDialag = modalDialogsPage.obtenerTituloSmallModal();
            modalDialogsPage.cerrarSmallModal();
            modalDialogsPage.clickLargeModal();
            tituloLargeModal = modalDialogsPage.obtenerTituloLargeModal();
            modalDialogsPage.cerrarLargeModal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia ver los titulos de los dialogos {string} {string}")
    public void deberiaVerLosTitulosDeLosDialogos(String tituloSmallDialogExpected, String tituloLargeDialogExpected) {
        try {
            Assertions.assertEquals(tituloSmallDialogExpected, tituloSmallDialag);
            Assertions.assertEquals(tituloLargeDialogExpected, tituloLargeModal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
