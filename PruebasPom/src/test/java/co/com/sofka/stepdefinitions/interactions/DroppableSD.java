package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DroppablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class DroppableSD extends WebSetup {

    DroppablePage droppablePage;

    @When("ingresa hasta la interaccion Droppable")
    public void ingresa_hasta_la_interaccion_droppable() {
        try {
            droppablePage = new DroppablePage(driver);
            droppablePage.goToDroppable();
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }

    }
    @When("arrastra la caja a la ubicacion indicada")
    public void arrastra_la_caja_a_la_ubicacion_indicada() {
        try {
            droppablePage.holdClick();
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
    }

    @When("arrastra la caja con el texto Acceptable")
    public void arrastra_la_caja_con_el_texto_acceptable() {
        try {
            droppablePage.holdClickA();
        }catch (Exception e){
            e.printStackTrace();
            quiteDrive();
            Assert.fail();
        }
    }

    @Then("deberia observar un mensaje de dropped")
    public void deberia_observar_un_mensaje_de_dropped() throws InterruptedException {
        try {
            String texto = droppablePage.getMensaje();
            Assert.assertEquals("Dropped!",texto);
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }finally {
            quiteDrive();
        }
    }

    @Then("deberia observar un mensaje de dropped!")
    public void deberia_observar_un_mensaje_de_dropped_() throws InterruptedException {
        try {
            String texto = droppablePage.getMensajeA();
            Assert.assertEquals("Dropped!",texto);
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }finally {
            quiteDrive();
        }
    }
}
