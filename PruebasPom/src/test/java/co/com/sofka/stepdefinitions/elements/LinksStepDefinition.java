package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.ElementLinksPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.Constantes.*;

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
        }finally {
            quiteDrive();
        }

    }

    @When("el usuario hace click en todas los link de api call")
    public void elUsuarioHaceClickEnTodasLosLinkDeApiCall() {
        try {
            elementLinksPage.createdClick();
            elementLinksPage.noContentClick();
            elementLinksPage.movedClick();
            elementLinksPage.badRequestClick();
            elementLinksPage.unauthorizedClick();
            elementLinksPage.forbiddenClick();
            elementLinksPage.notFoundClick();
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("se deberia mostrar en pantalla un mensaje con la respuesta de la api")
    public void seDeberiaMostrarEnPantallaUnMensajeConLaRespuestaDeLaApi() throws InterruptedException {
        try {
            Assertions.assertEquals(CREATED,elementLinksPage.getResponseCreated());
            Assertions.assertEquals(NO_CONTENT, elementLinksPage.getResponseNoContent());
            Assertions.assertEquals(MOVED, elementLinksPage.getResponseMoved());
            Assertions.assertEquals(BAD_REQUEST, elementLinksPage.getResponseBadRequest());
            Assertions.assertEquals(UNAUTHORIZED, elementLinksPage.getResponseUnauthorized());
            Assertions.assertEquals(FORBIDDEN, elementLinksPage.getResponseForbidden());
            Assertions.assertEquals(NOT_FOUND, elementLinksPage.getResponseNotFound());
        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }finally {
            quiteDrive();
        }
    }

}
