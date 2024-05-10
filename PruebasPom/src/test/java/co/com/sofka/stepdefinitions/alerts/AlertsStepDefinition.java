package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertsStepDefinition extends WebSetup {

    AlertsPage alertsPage;

    @Given("que el usuario esta en la pagina de inicio")
    public void queElUsuarioEstaEnLaPaginaDeInicio() {
        generalSetup(2);
    }
    @When("ingresa hasta el apartado de alertas")
    public void ingresaHastaElApartadoDeAlertas() {
        alertsPage = new AlertsPage(driver);
        alertsPage.goToAlerts();
    }
    @When("clickea sobre la alerta de click")
    public void clickeaSobreLaAlertaDeClick() {

    }
    @Then("debería ver una ventana emergente")
    public void deberíaVerUnaVentanaEmergente() {

    }
    @When("clickea sobre la alerta con timer")
    public void clickeaSobreLaAlertaConTimer() {
        quiteDrive();
    }
    @Then("debería ver una ventana emergente despues de cinco segundos")
    public void deberíaVerUnaVentanaEmergenteDespuesDeCincoSegundos() {

    }
    @When("clickea sobre la alerta con confirmacion")
    public void clickeaSobreLaAlertaConConfirmacion() {

    }
    @Then("debería ver una ventana emergente con una opcion de confirmar")
    public void deberíaVerUnaVentanaEmergenteConUnaOpcionDeConfirmar() {

    }
    @When("clickea sobre la alerta con prompt enviando el name Juan")
    public void clickeaSobreLaAlertaConPromptEnviandoElNameJuan() {

    }
    @Then("deberia observar la alerta con el nombre")
    public void deberiaObservarLaAlertaConElNombre() {

    }
}
