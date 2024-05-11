package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.UploadDownloandPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class UploadDownloandStep extends WebSetup {
    private UploadDownloandPage uploadDownloandPage;

    @When("el usuario esta ubicado en la seccion de Upload y downloand")
    public void elUsuarioEstaUbicadoEnLaSeccionDeUploadYDownloand() {
        try {
            uploadDownloandPage = new UploadDownloandPage(driver);
            uploadDownloandPage.entrarUD();
        } catch (Exception e) {
            Assert.fail("Error al navegar a la sección de carga y descarga: " + e.getMessage());
        }
    }

    @When("el usuario selecciona un archivo y lo carga")
    public void elUsuarioSeleccionaUnArchivoYLoCarga() {
        try {
            uploadDownloandPage = new UploadDownloandPage(driver);
            uploadDownloandPage.subirArchivo();

        } catch (Exception e) {
            Assert.fail("Error al cargar y subir el archivo: " + e.getMessage());
        }
    }

    @Then("deberia de mostrar el archivo que lo carga")
    public void deberiaDeMostrarElArchivoQueLoCarga() {

    }

    @When("el usuario descarga archivo")
    public void el_usuario_descarga_archivo() {
        try {
            uploadDownloandPage = new UploadDownloandPage(driver);

        } catch (Exception e) {
            Assert.fail("Error al descargar el archivo: " + e.getMessage());
        }
    }

    @Then("deberia de mostrar el archivo que lo descarga")
    public void deberia_de_mostrar_el_archivo_que_lo_descarga() {

    }
}
