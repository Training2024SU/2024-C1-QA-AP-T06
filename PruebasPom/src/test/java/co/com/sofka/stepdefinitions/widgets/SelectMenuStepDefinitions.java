package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.PageFactorySelectMenu;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static co.com.sofka.page.PageFactoryTabs.EXPECTED;
import static co.com.sofka.page.PageFactoryTabs.INTEREACION;


public class SelectMenuStepDefinitions extends WebSetup {
    PageFactorySelectMenu pageFactorySelectMenu;
    @When("se dirije a la pagina select menu")
    public void seDirijeALaPaginaSelectMenu() {
        pageFactorySelectMenu = new PageFactorySelectMenu(driver);
        pageFactorySelectMenu.irPaginaSelectMenu();
    }
    @When("completa todos los campos")
    public void completaTodosLosCampos() {
        pageFactorySelectMenu = new PageFactorySelectMenu(driver);
        pageFactorySelectMenu.llenarCampos();
    }
    @Then("deberia poder ver toda la infomacion ingresada")
    public void deberiaPoderVerTodaLaInfomacionIngresada() {
        pageFactorySelectMenu = new PageFactorySelectMenu(driver);
        pageFactorySelectMenu.camposTexto();
        Assert.assertEquals(EXPECTED, pageFactorySelectMenu.camposTexto());
    }
}
