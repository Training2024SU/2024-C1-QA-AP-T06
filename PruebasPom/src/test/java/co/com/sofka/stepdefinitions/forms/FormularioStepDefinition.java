package co.com.sofka.stepdefinitions.forms;


import co.com.sofka.model.FormularioModel;
import co.com.sofka.page.ElementLinksPage;
import co.com.sofka.page.FormularioPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.MSN_GRACIAS;
import static co.com.sofka.util.util.crearUsuario;

public class FormularioStepDefinition extends WebSetup {

    FormularioPage formularioPage;

    FormularioModel formularioModel;

    @Given("And el usuario navega al apartado Practice Form de forms")
    public void queElUsuarioEstaEnLaPaginaDeRegistro() {
        try {
            formularioPage = new FormularioPage(driver);
            formularioPage.irAForms();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("ingresa su informacion correctamente")
    public void ingresaSuInformacionCorrectamente() {
        try {
            formularioModel = crearUsuario();
           formularioPage.setUsuario(formularioModel);
            formularioPage.llenarFormulario();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("envia el formulario")
    public void enviaElFormulario() throws InterruptedException {
        try {
            formularioPage.enviarFormulario();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @Then("deberia observar un mensaje de registro exitoso con la información ingresada")
    public void deberiaObservarUnMensajeDeRegistroExitoso() throws InterruptedException {
        try {
            Assertions.assertEquals(MSN_GRACIAS,formularioPage.mensajeBienvenida());
            Assertions.assertTrue(formularioPage.compararRegistro());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }finally {
//          Thread.sleep(5000);
            quiteDrive();
        }

    }
}

