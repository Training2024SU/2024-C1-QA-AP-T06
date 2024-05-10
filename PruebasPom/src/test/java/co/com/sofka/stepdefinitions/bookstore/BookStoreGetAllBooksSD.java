package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.setup.ServiceSetup;
import co.com.sofka.setup.WebSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStoreGetAllBooksSD extends ServiceSetup {

    @Given("el usuaro tiene acceso al servicio GET de la pagina")
    public void elUsuaroTieneAccesoAlServicioGETDeLaPagina() {

    }

    @When("realiza la peticion GET correctamente para obtener todos los libros")
    public void realizaLaPeticionGETCorrectamenteParaObtenerTodosLosLibros() {
    }

    @Then("deberia ver los siguentes libros ofrecidos en la pagina")
    public void deberiaVerLosSiguentesLibrosOfrecidosEnLaPagina(DataTable dataTable) {

    }

    @Then("deberia recibir una respuesta exitosa con codigo {int}")
    public void deberiaRecibirUnaRespuestaExitosaConCodigo(Integer codigo) {

    }

}
