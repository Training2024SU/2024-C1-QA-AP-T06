package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class TestWidgets extends WebSetup {

    @Given("El usuario esta en la pagina web de widgets demoqa {int}")
    public void elUsuarioEstaEnLaPaginaWebDeWidgetsDemoqa(int browser) {
        try {
            generalSetup(browser);
            PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryMain.navegarAWidgets();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
}
