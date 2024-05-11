package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BookStoreAuthenticationSD extends WebSetup {
    @When("el usuario ingresa sus crendenciales de registro user {string} y la contrasena {string}")
    public void elUsuarioIngresaSusCrendencialesDeRegistroUserYLaContrasena(String string, String string2) {

    }
    @When("ingresa nuevamente sus credenciales para iniciar sesion")
    public void ingresaNuevamenteSusCredencialesParaIniciarSesion() {

    }
    @Then("deberia estar dentro de la pagina como usuario registrado")
    public void deberiaEstarDentroDeLaPaginaComoUsuarioRegistrado() {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();

        }finally {
            quiteDrive();
        }
    }
}
