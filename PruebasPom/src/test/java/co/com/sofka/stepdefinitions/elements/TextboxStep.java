package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.model.TextboxModel;
import co.com.sofka.page.AlertsWindowsPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.page.function.TextboxPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TextboxStep extends WebSetup {
    TextboxModel textboxModel;
    TextboxPage textboxPage;

    @When("ingresa a la pagina del formulario")
    public void ingresaALaPaginaDelFormulario() {
        try {
            textboxPage = new TextboxPage(driver);
            textboxPage.goToTB();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("El usuario llena el formulario con la siguiente informacion:")
    public void elUsuarioLlenaElFormularioConLaSiguienteInformacion(DataTable dataTable) {

        try {
            List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);
            textboxModel = new TextboxModel();
            textboxPage = new TextboxPage(driver);
            Map<String, String> row = formData.get(0);

            textboxModel.setFullname(row.get("Full Name"));
            textboxModel.setEmail(row.get("Email"));
            textboxModel.setCurrent(row.get("Current Address"));
            textboxModel.setPermanet(row.get("Permanent Address"));
            textboxPage.formularioTextbox(textboxModel);
        } catch (Exception e) {
            Assert.fail("Error al llenar el formulario: " + e.getMessage());
        }
    }

    @Then("El usuario debería ver un mensaje de confirmacion de envío")
    public void elUsuarioDeberíaVerUnMensajeDeConfirmacionDeEnvío() {
        try {
            assertTrue("El cuadro de salida debería estar presente",
                    textboxPage.verificarPresenciaDeRecuadroDeSalida());
            quiteDrive();
        } catch (Exception e) {
            Assert.fail("Error al verificar el mensaje de confirmación: " + e.getMessage());
        }
    }


}
