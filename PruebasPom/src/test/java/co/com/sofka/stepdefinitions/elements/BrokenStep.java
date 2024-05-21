package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.AlertsWindowsPage;
import co.com.sofka.page.BrokenPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.HOME_DEMO_QA;
import static co.com.sofka.Constantes.PAGINA_STATUS500;


public class BrokenStep extends WebSetup {
    BrokenPage brokenPage;

    @When("el usuario esta ubicado en la seccion de links e imagenes")
    public void elUsuarioEstaUbicadoEnLaSeccionDeLinksEImagenes() {
        try {
            brokenPage = new BrokenPage(driver);
            brokenPage.abrirBrokenLinksImages();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @When("el usuario selecciona una imagen o link")
    public void elUsuarioSeleccionaUnaImagenOLink() {
        try {
            brokenPage = new BrokenPage(driver);
            brokenPage.goToLinkValido();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @Then("deberia de mostrar su correspondiente alerta como buena o rota")
    public void deberiaDeMostrarSuCorrespondienteAlertaComoBuenaORota() {
        try {
            brokenPage = new BrokenPage(driver);
            Assertions.assertEquals(driver.getCurrentUrl(), HOME_DEMO_QA);
        } catch (Exception e) {
            Assert.fail("Error al seleccionar link: " + e.getMessage());
        } finally {
            quiteDrive();
        }
    }

    @When("el usuario selecciona un link invalido")
    public void elUsuarioSeleccionaUnLinkInvalido() {
        try {
            brokenPage = new BrokenPage(driver);
            brokenPage.goToLinkInvalido();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("deberia de mostrar su correspondiente alerta de link invalido")
    public void deberiaDeMostrarSuCorrespondienteAlertaDeLinkInvalido() {
        try {
            brokenPage = new BrokenPage(driver);
            Assertions.assertEquals(driver.getCurrentUrl(), PAGINA_STATUS500);
        } catch (Exception e) {
            Assert.fail("Error al seleccionar linko: " + e.getMessage());
        } finally {
            quiteDrive();
        }

    }

    @When("el usuario selecciona un puede ver una imagen valida")
    public void elUsuarioSeleccionaUnPuedeVerUnaImagenValida() {
        try {
            brokenPage = new BrokenPage(driver);
            brokenPage.goToImagenValido();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
    @Then("deberia de mostrar su correspondiente alerta de imagen valida")
    public void deberiaDeMostrarSuCorrespondienteAlertaDeImagenValida() {
        try {
            brokenPage = new BrokenPage(driver);
            Assert.assertTrue(brokenPage.validarImageneFuncional());

        } catch (Exception e) {
            Assert.fail("Error al seleccionar imagen link: " + e.getMessage());
        } finally {
            quiteDrive();
        }

    }
    @When("el usuario selecciona un no puede ver una imagen valida")
    public void elUsuarioSeleccionaUnNoPuedeVerUnaImagenValida() {
        try {
            brokenPage = new BrokenPage(driver);
            brokenPage.goToImagenInvalido();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }


    }
    @Then("deberia de mostrar su correspondiente alerta de imagen invalido")
    public void deberiaDeMostrarSuCorrespondienteAlertaDeImagenInvalido() {
        try {
            brokenPage = new BrokenPage(driver);
            Assert.assertTrue(brokenPage.validarImageneNoFuncional());

        } catch (Exception e) {
            Assert.fail("Error al seleccionar imagen link: " + e.getMessage());
        } finally {
            quiteDrive();
        }
    }

}
