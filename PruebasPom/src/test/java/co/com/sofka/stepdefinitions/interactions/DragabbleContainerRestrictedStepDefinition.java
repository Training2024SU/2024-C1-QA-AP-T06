package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DragabblePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DragabbleContainerRestrictedStepDefinition extends WebSetup {
    DragabblePage dragabblePage = new DragabblePage(driver);
    byte[] screenshotBeforeMove;
    byte[] screenshotAfterMove;
    @When("accede a la seccion de contenedor restringido en el navegador de dragabble {int}")
    public void accedeALaVentanaContainerRestrictedEnElNavegadorDeDraggable(int posicion){
        try {
            dragabblePage.abrirDragableNavPorPosicion(posicion);
        } catch (Exception e) {
            System.err.println("Error al acceder a la ventana container restricted en el navegador de dragabble: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("mueve los elementos con contenedor restringido")
    public void mueveLosElementosRestringidos(){
        try {
            // Capturar una imagen de la página antes de mover el elemento
            screenshotBeforeMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            dragabblePage.moverElementosContainerRestricted();

            // Capturar una imagen de la página despues de mover los elementos
            screenshotAfterMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Error al mover los elementos con contenedor restringido: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("deberian figurar en el lugar indicado")
    public void deberianFigurarEnElLugarIndicado(){
        try {
            // Comparar las imágenes antes y después del movimiento
            // Si las imágenes son diferentes, el elemento se ha movido correctamente
            Assertions.assertNotEquals(screenshotBeforeMove, screenshotAfterMove, "El elemento no se ha movido");
        } catch (Exception e) {
            System.err.println("Error al verificar el movimiento del elemento: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }
}