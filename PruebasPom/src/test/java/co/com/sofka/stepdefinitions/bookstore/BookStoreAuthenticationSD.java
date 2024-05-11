package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.model.UserRegisterPageModel;
import co.com.sofka.page.PageFactoryAuthentication;
import co.com.sofka.setup.WebSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static co.com.sofka.util.mapToModel.mapToUserList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookStoreAuthenticationSD extends WebSetup {
    private UserRegisterPageModel userModel;
    private PageFactoryAuthentication pageFactoryAuthentication;

    @When("el usuario ingresa las siguentes crendeciasles para registro")
    public void elUsuarioIngresaLasSiguentesCrendeciaslesParaRegistro(DataTable dataTable) {
        try {
            List<Map<String, String>> userMapList = dataTable.asMaps(String.class, String.class);
            pageFactoryAuthentication = new PageFactoryAuthentication(driver);
            userModel = mapToUserList(userMapList).get(0);
            pageFactoryAuthentication.goToAuthentication();
            pageFactoryAuthentication.goToRegistration();
            pageFactoryAuthentication.fillUserData(userModel);
            // no se puede resolver el captcha de la pagina
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("ingresa nuevamente sus credenciales para iniciar sesion")
    public void ingresaNuevamenteSusCredencialesParaIniciarSesion() {
        // No se puede resolver el captcha de la pagina
    }

    @Then("deberia estar dentro de la pagina como usuario registrado")
    public void deberiaEstarDentroDeLaPaginaComoUsuarioRegistrado() {
        try {
            assertThat(pageFactoryAuthentication.getFirstName(), equalTo(userModel.getName()));
            assertThat(pageFactoryAuthentication.getLastname(), equalTo(userModel.getLastname()));
            assertThat(pageFactoryAuthentication.getUserName(), equalTo(userModel.getUsername()));
            assertThat(pageFactoryAuthentication.getPassword(), equalTo(userModel.getPassword()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }

}
