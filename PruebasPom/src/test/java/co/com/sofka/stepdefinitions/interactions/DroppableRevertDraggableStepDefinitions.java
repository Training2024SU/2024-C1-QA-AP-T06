package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DroppablePage;
import co.com.sofka.page.InteractionsPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DroppableRevertDraggableStepDefinitions extends WebSetup {
    PageFactoryMain pageFactoryMain;
    InteractionsPage interactionsPage;
    DroppablePage droppablePage;
    String mensajeActual;

    @When("ingresa hasta la pagina de droppable al apartado revert draggable")
    public void ingresaHastaLaPaginaDeDroppableAlApartadoRevertDraggable() {
        try {
            pageFactoryMain = new PageFactoryMain(driver);
            interactionsPage = new InteractionsPage(driver);
            droppablePage = new DroppablePage(driver);
            pageFactoryMain.navegarAInteracciones();
            interactionsPage.navegarADroppablePage();
            droppablePage.irARevertDraggable();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("arrastra los elementos drag hasta la seccion drop here")
    public void arrastraLosElementosDragHastaLaSeccionDropHere() {
        try {
            droppablePage.dragNotRevertADropZone();
            mensajeActual = droppablePage.obtenerTexto();
            droppablePage.dragWillRevertADropZone();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia cambiar el mensaje a {string}")
    public void deberiaCambiarElMensajeA(String mensajeEsperado) {
        try {
            Assertions.assertEquals(mensajeEsperado, mensajeActual);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
