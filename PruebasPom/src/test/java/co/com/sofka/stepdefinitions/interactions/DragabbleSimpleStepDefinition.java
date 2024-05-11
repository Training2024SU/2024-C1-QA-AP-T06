package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.DragabblePage;
import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DragabbleSimpleStepDefinition extends WebSetup {
    DragabblePage dragabblePage = new DragabblePage(driver);
    byte[] screenshotBeforeMove;
    byte[] screenshotAfterMove;

    @Given("El usuario esta en la pagina web de interacciones de demoqa {int}")
    public void elUsuarioEstaEnLaPaginaWebDeInteraccionesDemoqa(Integer tipoDriver) {
        try {
            generalSetup(tipoDriver);
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryMain.navegarAInteracciones();
        } catch (Exception e) {
            System.err.println("Error al configurar el WebDriver: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }
    @Given("selecciona la opcion Dragabble")
    public void seleccionaLaOpcionDragabble() {
        try {
            dragabblePage = new DragabblePage(driver);
            dragabblePage.ingresarASeccionDragabble();
        } catch (Exception e) {
            System.err.println("Error al seleccionar la opción Dragabble: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("mueve el elemento")
    public void mueveElElemento() {
        try {
            // Capturar una imagen de la página antes de mover el elemento
            screenshotBeforeMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            dragabblePage.moverElElementoDraggableSimple();

            // Capturar una imagen de la página después de mover el elemento
            screenshotAfterMove = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Error al mover el elemento: " + e.getMessage());
            e.printStackTrace();
            quiteDrive();
            Assertions.fail();
        }
    }
   @Then("deberia visualizarse en el lugar indicado")
    public void deberiaVisualizarseEnElLugarIndicado() {
       try {
           // Comparar las imágenes antes y después del movimiento
           // Si las imágenes son diferentes, el elemento se ha movido correctamente
           Assertions.assertNotEquals(screenshotBeforeMove, screenshotAfterMove, "El elemento no se ha movido");
       } catch (Exception e) {
           System.err.println("Error al verificar el movimiento del elemento: " + e.getMessage());
           e.printStackTrace();
           Assertions.fail();
       } finally {
           quiteDrive();
       }
    }
}