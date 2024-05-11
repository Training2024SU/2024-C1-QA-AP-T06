package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.model.UserRegisterModel;
import co.com.sofka.setup.ServiceSetup;
import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.datafaker.Faker;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookStoreGenerateTokeSD extends ServiceSetup {
    private String jsonModel;

    @When("crea un usuario realizando una peticion el servicio POST con el usuario {string} y la contrasena {string}")
    public void creaUnUsuarioRealizandoUnaPeticionElServicioPOSTConElUsuarioYLaContrasena(String userName, String password) {
        Faker faker = new Faker();
        Gson gson = new Gson();
        request = RestAssured.given();
        String name = userName + faker.bothify("#####");
        UserRegisterModel userRegisterModel = new UserRegisterModel(name, password);
        jsonModel = gson.toJson(userRegisterModel);
        response = request
                .header("Content-Type", "application/json")
                .body(jsonModel)
                .post(POST_USER_URL);
    }

    @When("solicita un token ingresando las credenciales del usuario creado usando el metodo POST")
    public void solicitaUnTokenIngresandoLasCredencialesDelUsuarioCreadoUsandoElMetodoPOST() {
        response = request
                .header("Content-Type", "application/json")
                .body(jsonModel)
                .post(GENERATE_TOKEN_URL);
    }

    @Then("deberia generar un token de ingreso")
    public void deberiaGenerarUnTokenDeIngreso() {
        response.then().assertThat().body("token", notNullValue());
        response.then().assertThat().body("status", equalTo(SUCCESS_MESSAGE));
        response.then().assertThat().body("result", equalTo(RESULT_MESSAGE));

    }

    @Then("deberia ser autorizado para entrar")
    public void deberiaSerAutorizadoParaEntrar() {
        response = request
                .header("Content-Type", "application/json")
                .body(jsonModel)
                .post(ASK_AUTHORIZATION_URL);

        String responseBody = response.getBody().asString();
        assertThat(responseBody, equalTo("true"));
    }
}
