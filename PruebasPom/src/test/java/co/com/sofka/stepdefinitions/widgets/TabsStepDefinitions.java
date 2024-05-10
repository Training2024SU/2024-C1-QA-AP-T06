package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.PageFactoryTabs;
import co.com.sofka.page.function.FunctionsCommons;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.page.PageFactoryTabs.INTEREACION;

public class TabsStepDefinitions extends WebSetup {
    PageFactoryTabs pageFactoryTabs;
    @When("se dirije a la pagina tabs")
    public void seDirijeALaPaginaTabs() {
        try {
            pageFactoryTabs = new PageFactoryTabs(driver);
            pageFactoryTabs.irPaginaTabs();
        }catch (Exception e){
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("deberia poder interactuar con los elementos de la pagina")
    public void deberiaPoderInteractuarConLosElementosDeLaPagina() {
        try {
            pageFactoryTabs = new PageFactoryTabs(driver);
            pageFactoryTabs.interactuarTabs();
            Assert.assertEquals(INTEREACION, pageFactoryTabs.mensajeActual());
        }catch (Exception e){
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
}
