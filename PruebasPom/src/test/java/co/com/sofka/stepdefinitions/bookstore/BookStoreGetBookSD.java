package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.setup.ServiceSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.GET_BOOK;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookStoreGetBookSD extends ServiceSetup {

    @When("realiza la peticion GET correctamente ingresando el isbn {string}")
    public void realizaLaPeticionGETCorrectamenteIngresandoElIsbn(String isbn) {
        response = given()
                .when()
                .pathParam("isbn", isbn)
                .get(GET_BOOK);
    }
    @Then("deberia ver el titulo {string}")
    public void deberiaVerElTitulo(String titulo) {
        response.then().assertThat().body("title", equalTo(titulo));
    }

}
