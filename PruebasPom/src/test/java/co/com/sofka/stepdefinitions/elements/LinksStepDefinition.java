package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.ElementLinksPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.HOME_DEMO_QA;

public class LinksStepDefinition extends WebSetup {

    ElementLinksPage elementLinksPage;

    @Given("el usuario navega al apartado links de Elementos")
    public void el_usuario_esta_en_el_apartado_links_de_elementos() {
        try {
            elementLinksPage = new ElementLinksPage(driver);
            elementLinksPage.irALinks();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("el usuario hace clic en los enlaces Home y HomewXVOz")
    public void el_usuario_hace_clic_en_los_enlaces_home_y_homew_xv_oz() {
        try {
            elementLinksPage.testLinks();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }
    @Then("se deberia estar en el apartado links de elementos luego de abrir la pestaña de los enlaces Home y HomewXVOz")
    public void se_deberian_redirigir_al_home_de_demo_qa_correctamente() {
        try {
            Assertions.assertEquals(HOME_DEMO_QA,elementLinksPage.getValidatelinkHomd());
            Assertions.assertEquals(HOME_DEMO_QA,elementLinksPage.getValidateDynamiclink());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

}
