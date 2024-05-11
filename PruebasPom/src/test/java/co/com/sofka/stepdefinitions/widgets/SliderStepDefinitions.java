package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.SliderPage;
import co.com.sofka.page.WidgetsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SliderStepDefinitions extends WebSetup {
    WidgetsPage widgetsPage;
    SliderPage sliderPage;

    @Given("se dirige a la seccion de slider")
    public void seDirigeALaSeccionDeSlider() {
        try {
            widgetsPage = new WidgetsPage(driver);
            widgetsPage.navegarASlider();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @When("desplaza el slider a otro punto {int} pixeles")
    public void desplazaElSliderAOtroPuntoPixeles(Integer pixeles) {
        try {
            sliderPage = new SliderPage(driver);
            sliderPage.moverSlider(pixeles);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }

    @Then("deberia cambiar el numero del input a {int}")
    public void deberiaCambiarElNumeroDelInputA(Integer numeroInput) {
        try {
            int numero = sliderPage.numeroInput();
            Assertions.assertEquals(numeroInput, numero);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
