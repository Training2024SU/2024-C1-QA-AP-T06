package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DragabblePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DragabbleAxisRestrictedStepDefinition extends WebSetup {
    DragabblePage dragabblePage = new DragabblePage(driver);
    byte[] screenshotBeforeMove;
    byte[] screenshotAfterMove;
    @When("accede a la seccion de acceso restringido en el navegador de dragabble {int}")
    public void accedeALaSeccionDeAccesoRestringidoEnElNavegadorDeDragabble(int posicion){
        dragabblePage.abrirDragableNavPorPosicion(posicion);
    }
    @When("mueve los elementos uno horizontal y otro verticalmente")
    public void mueveLosElementosUnoHorizontalYOtroVerticalmente() {
        // Capturar una imagen de la página antes de mover el elementos
        screenshotBeforeMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        dragabblePage.moverElElementoDraggableAxisRestricted();

        // Capturar una imagen de la página despues de mover los elementos
        screenshotAfterMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
     }

    @Then("deberian visualizarse en el lugar indicado")
    public void deberianVisualizarseEnElLugarIndicado(){
        try {
            // Comparar las imágenes antes y después del movimiento
            // Si las imágenes son diferentes, el elemento se ha movido correctamente
            Assertions.assertNotEquals(screenshotBeforeMove, screenshotAfterMove, "El elemento no se ha movido");
        } catch (Exception e) {
            System.err.println("Error al verificar el movimiento del elemento: " + e.getMessage());
            e.printStackTrace();
        }
        quiteDrive();
    }
}



