package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.SortablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SortableListStepDefinitions extends WebSetup {
    private SortablePage sortablePage;
    private int posicionInicialY;

    @When("ordena la lista")
    public void ordena_la_lista() {
        try{
            sortablePage = new SortablePage(driver);
            sortablePage.organizarLista();
        }catch (Exception e){
            System.out.println(e);
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("debería veria el nuevo orden de la lista")
    public void deberíaVeriaElNuevoOrdenDeLaLista() {
        quiteDrive();
    }}

