package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.setup.ServiceSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookStoreDeleteUserNotAuthorized extends ServiceSetup {

    @When("el usuario hace uso del servicio delete e ingresa el siguiente id {string}")
    public void elUsuarioHaceUsoDelServicioDeleteEIngresaElSiguienteId(String id) {
        response = given()
                .when()
                .pathParam("UUID", id)
                .delete(DELETE_USER_NOT_AUTHORIZED_URL);
    }
    @Then("deberia recibir un mensaje de usuario no autorizado")
    public void deberiaRecibirUnMensajeDeUsuarioNoAutorizado() {
        response.then().assertThat().body("code", equalTo(FAILED_CODE));
        response.then().assertThat().body("message", equalTo(NOT_AUTHORIZED_MESSAGE));
    }
    @Then("deberia recibir una respuesta fallida con codigo {int}")
    public void deberiaRecibirUnaRespuestaFallidaConCodigo(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
}
