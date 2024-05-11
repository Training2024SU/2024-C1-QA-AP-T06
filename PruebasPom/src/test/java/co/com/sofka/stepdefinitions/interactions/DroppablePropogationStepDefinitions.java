package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DroppablePage;
import co.com.sofka.page.InteractionsPage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.page.ResizablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DroppablePropogationStepDefinitions extends WebSetup {
    PageFactoryMain pageFactoryMain;
    InteractionsPage interactionsPage;
    DroppablePage droppablePage;
    String mensajeDropZone;
    String mensajeGreedyDropZone;

    @When("ingresa hasta la pagina de droppable al apartado prevent propogation")
    public void ingresaHastaLaPaginaDeDroppableAlApartadoPreventPropogation() {
        try {
            pageFactoryMain = new PageFactoryMain(driver);
            interactionsPage = new InteractionsPage(driver);
            droppablePage = new DroppablePage(driver);
            pageFactoryMain.navegarAInteracciones();
            interactionsPage.navegarADroppablePage();
            droppablePage.irAPreventPropagation();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("arrastra la caja Drag me hasta inner droppable")
    public void arrastraLaCajaDragMeHastaInnerDroppable() {
        try {
            droppablePage.dragHastaInnerDrop();
            mensajeDropZone = droppablePage.mensajeDropZone();
            droppablePage.dragHastaGreedyInnerDrop();
            mensajeGreedyDropZone = droppablePage.mensajeGreedyDropZone();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("debería aparecer un mensaje {string}")
    public void deberíaAparecerUnMensaje(String mensajeEsperado) {
        try {
            Assertions.assertEquals(mensajeEsperado, mensajeDropZone);
            Assertions.assertEquals(mensajeEsperado, mensajeGreedyDropZone);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }
}
