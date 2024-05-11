package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.ButtonsPage;
import co.com.sofka.page.ElementLinksPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonsStepDefinitions extends WebSetup {

    ButtonsPage buttonsPage;


    @When("hace click en el boton")
    public void hace_click_en_el_boton() {
        try {
            buttonsPage = new ButtonsPage(driver);
            buttonsPage.gohomeBoton();
            buttonsPage.clickBoton();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia ver el mensaje de click")
    public void deberia_ver_el_mensaje_de_click() {
        try {
            assertTrue(buttonsPage.returnMessageClick());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }

    @When("hace click derecho en el boton")
    public void hace_click_derecho_en_el_boton() {
        try {
            buttonsPage = new ButtonsPage(driver);
            buttonsPage.gohomeBoton();
            buttonsPage.rightClickButton();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia ver el mensaje de click derecho")
    public void deberia_ver_el_mensaje_de_click_derecho() {
        try {
            assertTrue(buttonsPage.returnMessageRightClick());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }

    @When("hace doble click en el boton")
    public void hace_doble_click_en_el_boton() {
        try {
            buttonsPage = new ButtonsPage(driver);
            buttonsPage.gohomeBoton();
            buttonsPage.dblClickButton();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia ver el mensaje de doble click")
    public void deberia_ver_el_mensaje_de_doble_click() {
        try {
            Assert.assertTrue(buttonsPage.returnMessageDoubleClick());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}