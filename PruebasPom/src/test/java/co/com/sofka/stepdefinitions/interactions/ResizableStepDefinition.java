package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.ResizablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import static co.com.sofka.Constantes.*;

public class ResizableStepDefinition extends WebSetup {

    ResizablePage resizablePage;

    @Given("selecciona la opcion Resizable")
    public void selecciona_la_opcion_resizable() {
            try {
                resizablePage = new ResizablePage(driver);
                resizablePage.irARedimensionar();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                quiteDrive();
                Assertions.fail();
            }
    }
    @When("el usuario redimenziona las cajas")
    public void el_usuario_redimenziona_las_cajas() {
        try {
            resizablePage.minSizeLimitBox();
            resizablePage.maxSizeLimitBox();
            resizablePage.minNotLimitBox();
            resizablePage.maxNotLimitBox();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("las cajas deberian visualizarse del tamaño correctamente dimensionado")
    public void deberia_visualizarse_del_tamano_correctamente_dimensionado() {
        try {
            Assertions.assertEquals(BOXLIMIT_WIDHT, resizablePage.getWidthLimitBoxSixe());
            Assertions.assertEquals(BOXLIMIT_HEIGHT, resizablePage.getHeightLimitBoxSixe());
            Assertions.assertEquals(BOXNOTLIMIT_WIDHT, resizablePage.getWidthNotLimitBoxSixe());
            Assertions.assertEquals(BOXNOTLIMIT_HEIGHT,  resizablePage.getHeighNotLimitBoxSixe());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }
}
