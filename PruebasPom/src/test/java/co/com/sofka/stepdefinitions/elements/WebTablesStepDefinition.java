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

    @When("usa el boton de add")
    public void usaElBotonDeAdd() {
        try {
            webTablesPage = new WebTablesPage(driver, webTableModel);
            webTablesPage.abrirWebElements();
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
            webTablesPage.waitSeconds(2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
            quiteDrive();
        }
    }
    @Then("deberia verse todos los cambios hechos en la tabla {string} {string} {string}")
    public void deberiaVerseTodosLosCambiosHechosEnLaTabla(String corre, String nombre, String apellido) {
        try {
            webTablesPage.limpiarCampoBusqueda();
          Assertions.assertEquals(corre, webTablesPage.obtenerTexto("correo"));
          Assertions.assertEquals(nombre, webTablesPage.obtenerTexto("nombre"));
          Assertions.assertEquals(apellido, webTablesPage.obtenerTexto("apellido"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();

        }finally {
            quiteDrive();
        }
    }
}
