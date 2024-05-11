package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.model.DeleteBookAPIModel;
import co.com.sofka.setup.ServiceSetup;
import com.google.gson.Gson;
import io.cucumber.java.en.When;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.UPDATE_BOOK_NOT_AUTHORIZED_URL;

public class BookStoreUpdateBookNotAuthorized extends ServiceSetup {

    @When("el usuario {string} intenta actualizar el libro con isbn {string} ingresando un nuevo isbn {string}")
    public void elUsuarioIntentaActualizarElLibroConIsbnIngresandoUnNuevoIsbn(String userId, String oldIsbn, String newIsbn) {
        DeleteBookAPIModel deleteBookAPIModel = new DeleteBookAPIModel(userId, newIsbn);
        Gson gson = new Gson();
        String jsonModel = gson.toJson(deleteBookAPIModel);
        response = request
                .given()
                .when()
                .body(jsonModel)
                .pathParam("ISBN", oldIsbn)
                .put(UPDATE_BOOK_NOT_AUTHORIZED_URL);
    }

}
