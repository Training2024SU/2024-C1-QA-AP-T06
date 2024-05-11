package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class TestInteractions extends WebSetup {
    @Given("El usuario esta en la pagina web de interactions demoqa {int}")
    public void elUsuarioEstaEnLaPaginaWebDeInteractionsDemoqa(int browser) {
        try {
            generalSetup(browser);
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryMain.navegarAInteracciones();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
}
