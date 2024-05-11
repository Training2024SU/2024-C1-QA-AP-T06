package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.model.DeleteBookAPIModel;
import co.com.sofka.setup.ServiceSetup;
import com.google.gson.Gson;
import io.cucumber.java.en.When;

import static co.com.sofka.stepdefinitions.bookstore.ConstantesBookStoreService.DELETE_BOOK_NOT_AUTHORIZED_URL;

public class BookStoreDeleteBookNotAuthorized extends ServiceSetup {
    @When("el usuario {string} intenta eliminar el libro con isbn {string}")
    public void elUsuarioIntentaEliminarElLibroConIsbn(String userId, String isbn) {
        DeleteBookAPIModel deleteBookAPIModel= new DeleteBookAPIModel(userId, isbn);
        Gson gson = new Gson();
        String jsonModel = gson.toJson(deleteBookAPIModel);
        response = request
                .given()
                .when()
                .body(jsonModel)
                .delete(DELETE_BOOK_NOT_AUTHORIZED_URL);
    }

}
