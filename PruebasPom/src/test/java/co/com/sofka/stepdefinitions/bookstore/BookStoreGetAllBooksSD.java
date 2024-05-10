package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.model.BookModel;
import co.com.sofka.setup.ServiceSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.GET_ALL_BOOKS;
import static co.com.sofka.util.mapToModel.mapToBooksList;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookStoreGetAllBooksSD extends ServiceSetup {
    @When("realiza la peticion GET correctamente para obtener todos los libros")
    public void realizaLaPeticionGETCorrectamenteParaObtenerTodosLosLibros() {
        response = given()
                .when()
                .get(GET_ALL_BOOKS);
    }

    @Then("deberia ver los siguentes libros ofrecidos en la pagina")
    public void deberiaVerLosSiguentesLibrosOfrecidosEnLaPagina(DataTable dataTable) {
        List<BookModel> bookModelsFromFeature;
        List<Map<String, String>> bookData = dataTable.asMaps(String.class, String.class);

        bookModelsFromFeature = mapToBooksList(bookData);
        List<BookModel> booksFromService = response.jsonPath().getList("books", BookModel.class);

        bookModelsFromFeature.forEach(bookModel -> {
            assertTrue(booksFromService.contains(bookModel),
                    "El libro '" + bookModel.getTitle() + "' no se encontró en la lista de libros del servicio");
        });

    }

    @Then("deberia recibir una respuesta exitosa con codigo {int}")
    public void deberiaRecibirUnaRespuestaExitosaConCodigo(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

}
