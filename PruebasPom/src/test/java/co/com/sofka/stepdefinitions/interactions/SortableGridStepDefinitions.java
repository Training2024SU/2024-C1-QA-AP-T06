package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.SortablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SortableGridStepDefinitions extends WebSetup {

    SortablePage sortablePage;

    @When("el usuario selecciona en la página de ordenamiento")
    public void el_usuario_selecciona_en_la_página_de_ordenamiento() {
       try{
           sortablePage = new SortablePage(driver);
           sortablePage.getElements();
       }catch (Exception e){
           System.out.println(e.getMessage());
           quiteDrive();
           Assertions.fail();
       }

    }
    @When("organiza su lista")
    public void organiza_su_lista() {
        // Write code here that turns the phrase above into concrete actions
        try {
            sortablePage.organizeElements();
            sortablePage.getOrganizedElements();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
    @Then("debería ver la opción ordenada")
    public void debería_ver_la_opción_ordenada() {
        try {
            // Verificar si los elementos están organizados correctamente
            Assertions.assertTrue(sortablePage.compareLists());

        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }finally {
            quiteDrive();
        }

    }

}
