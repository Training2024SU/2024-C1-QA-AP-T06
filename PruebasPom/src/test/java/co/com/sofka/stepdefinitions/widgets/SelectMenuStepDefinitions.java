package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.PageFactorySelectMenu;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.page.PageFactoryTabs.EXPECTED;
import static co.com.sofka.page.PageFactoryTabs.INTEREACION;


public class SelectMenuStepDefinitions extends WebSetup {
    PageFactorySelectMenu pageFactorySelectMenu;
    @When("se dirije a la pagina select menu")
    public void seDirijeALaPaginaSelectMenu() {
        try {
            pageFactorySelectMenu = new PageFactorySelectMenu(driver);
            pageFactorySelectMenu.irPaginaSelectMenu();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
    @When("completa todos los campos")
    public void completaTodosLosCampos() {
        try {
            pageFactorySelectMenu = new PageFactorySelectMenu(driver);
            pageFactorySelectMenu.llenarCampos();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
    @Then("deberia poder ver toda la infomacion ingresada")
    public void deberiaPoderVerTodaLaInfomacionIngresada() {
        try {
            pageFactorySelectMenu = new PageFactorySelectMenu(driver);
            pageFactorySelectMenu.camposTexto();
            Assert.assertEquals(EXPECTED, pageFactorySelectMenu.camposTexto());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
}
