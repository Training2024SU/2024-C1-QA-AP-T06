package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DragabblePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class DragabbleCursorStyleStepDefiniton extends WebSetup{
    DragabblePage dragabblePage = new DragabblePage(driver);
    byte[] screenshotBeforeMove;
    byte[] screenshotAfterMove;
    @When ("accede a la seccion en estilo de cursor en el navegador de dragabble {int}")
    public void accederAVentanaCursorStyleEnDraggable(int posicion) {
        try {
            dragabblePage.abrirDragableNavPorPosicion(posicion);
        } catch (Exception e) {
            System.err.println("Error al acceder a la ventana cursor style en el navegador de dragabble: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("mueve los elementos")
    public void mueveLosElementos() {
        try {
            // Capturar una imagen de la página antes de mover el elemento
            screenshotBeforeMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            dragabblePage.moverElementosCursorStyle();

            // Capturar una imagen de la página despues de mover el elemento
            screenshotAfterMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Error al mover los elementos: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia visualizar que se cambian de lugar")
    public void deberiaVisualizarQueSeCambianDeLugar() {
        try {
            // Comparar las imágenes antes y después del movimiento
            // Si las imágenes son diferentes, los elementos se han movido correctamente
            Assertions.assertNotEquals(screenshotBeforeMove, screenshotAfterMove, "Los elementos no se han movido");
        } catch (Exception e) {
            System.err.println("Error al verificar el movimiento de los elementos: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }
}
