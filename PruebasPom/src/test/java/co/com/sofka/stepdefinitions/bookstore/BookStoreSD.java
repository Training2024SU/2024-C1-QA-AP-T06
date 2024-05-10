package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.page.BookStorePage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BookStoreSD extends WebSetup {

    BookStorePage bookStorePage;

    @When("reorganiza los libros por autor")
    public void reorganiza_los_libros_por_autor() {
        try {
            bookStorePage = new BookStorePage(driver);
            bookStorePage.openBookStore();
            bookStorePage.filtrarPorAutor();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
    @When("busca el nombre del libro por el nombre {string}")
    public void busca_el_nombre_del_libro_por_el_nombre(String nombreLibro) {
        try {
            bookStorePage.buscarLibro(nombreLibro);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia poder observar el libro de primero en la lista con su {string}")
    public void deberia_poder_observar_el_libro_de_primero_en_la_lista_con_su(String nombreAutor) {
        try {
            Assertions.assertEquals(nombreAutor, bookStorePage.obtenerNombreAutor());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();

        }finally {
            quiteDrive();
        }
    }


}
