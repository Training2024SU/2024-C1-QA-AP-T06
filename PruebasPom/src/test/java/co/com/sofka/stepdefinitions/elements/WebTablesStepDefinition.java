package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.model.WebTableModel;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.page.WebTablesPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.util.crearFila;

public class WebTablesStepDefinition extends WebSetup {

    WebTablesPage webTablesPage;
    WebTableModel webTableModel;
    PageFactoryMain pageFactoryMain;

    @Given("El usuario esta en la pagina web de elements demoqa {int}")
    public void elUsuarioEstaEnLaPaginaWebDeElementsDemoqa(Integer browser) {
        try {
            generalSetup(browser);
            pageFactoryMain.navegarAElements();
            webTablesPage.abrirWebElements();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @When("usa el boton de add")
    public void usaElBotonDeAdd() {
        try {
            webTablesPage = new WebTablesPage(driver, webTableModel);
            webTablesPage.agregarFilaBoton();


        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @When("llena el formulario con {string} {string} {string} {int} {int} {string}")
    public void llenaElFormularioCon(String nombre, String apellido, String correo, Integer edad, Integer salario, String departamento) {
        try {
            webTableModel = crearFila(nombre,apellido,correo,edad,salario,departamento);
            webTablesPage = new WebTablesPage(driver, webTableModel);
            webTablesPage.agregarNuevaFila();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @When("actualiza la fila con correo {string} a datos random")
    public void actualizaLaFilaConCorreoADatosRandom(String correo) {
        try {
            webTablesPage.editarFila(correo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @When("elimina la fila con el correo {string}")
    public void eliminaLaFilaConElCorreo(String correo) {
        try {
            webTablesPage.eliminarFila(correo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @Then("deberia verse todos los cambios hechos en la tabla")
    public void deberiaVerseTodosLosCambiosHechosEnLaTabla() {
        try {

           // Assertions.assertEquals(MENSAJE_ESPERADO_CORREO_WEBTABLES, webTablesPage.obtenerTexto("correo"));
           // Assertions.assertEquals(MENSAJE_ESPERADO_NOMBRE_WEBTABLES, webTablesPage.obtenerTexto("nombre"));
           // Assertions.assertEquals(MENSAJE_ESPERADO_APELLIDO_WEBTABLES, webTablesPage.obtenerTexto("apellido"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();

        }finally {
            quiteDrive();
        }
    }
}
