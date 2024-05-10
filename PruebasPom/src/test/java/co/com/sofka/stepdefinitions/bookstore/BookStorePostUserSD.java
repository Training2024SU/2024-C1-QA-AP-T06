package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.model.UserRegisterModel;
import co.com.sofka.setup.ServiceSetup;
import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.POST_USER;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class BookStorePostUserSD extends ServiceSetup {
    private UserRegisterModel userRegisterModel;

    @When("realiza la peticion POST correctamente ingresando el usuario {string} y la contrasena {string}")
    public void realizaLaPeticionPOSTCorrectamenteIngresandoElUsuarioYLaContrasena(String userName, String password) {
        Gson gson = new Gson();
        request = RestAssured.given();
        userRegisterModel = new UserRegisterModel(userName, password);
        String jsonModel = gson.toJson(userRegisterModel);
        response = request
                .header("Content-Type", "application/json")
                .body(jsonModel)
                .post(POST_USER);
        System.out.println(jsonModel);
    }

    @Then("deberia ver informacion al usuario creado")
    public void deberiaVerInformacionAlUsuarioCreado() {
        response.then().assertThat().body("username", equalTo(userRegisterModel.getUserName()));
        response.then().assertThat().body("userID", notNullValue());
    }
}
