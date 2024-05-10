package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.setup.ServiceSetup;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.BASE_URL;

public class BookStoreServiceSD extends ServiceSetup {
    @Given("el usuaro tiene acceso a los servicios de la biblioteca en DemoQA")
    public void elUsuaroTieneAccesoALosServiciosDeLaBibliotecaEnDemoQA() {
        RestAssured.baseURI = BASE_URL;
    }

}
