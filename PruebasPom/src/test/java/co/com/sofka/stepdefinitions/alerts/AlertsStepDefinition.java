package co.com.sofka.stepdefinitions.alerts;

import co.com.sofka.page.AlertsPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class AlertsStepDefinition extends WebSetup {

    AlertsPage alertsPage;
    Alert alert;

    @Given("que el usuario esta en la pagina de inicio")
    public void queElUsuarioEstaEnLaPaginaDeInicio() {
        generalSetup(1);
    }
    @When("ingresa hasta el apartado de alertas")
    public void ingresaHastaElApartadoDeAlertas() {
        alertsPage = new AlertsPage(driver);
        try {
            alertsPage.goToAlerts();
        } catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
    }
    @When("clickea sobre la alerta de click")
    public void clickeaSobreLaAlertaDeClick() {
        try {
            alert = alertsPage.clickAlert();
        } catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
    }

    @Then("debería ver una ventana emergente")
    public void deberíaVerUnaVentanaEmergente() {
        try {
            String alertText = alert.getText();
            Assert.assertEquals("You clicked a button",alertText);
            alert.accept();
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
        quiteDrive();
    }

    @When("clickea sobre la alerta con timer")
    public void clickeaSobreLaAlertaConTimer() throws InterruptedException {
        try {
            alert = alertsPage.timerAlert();
        } catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
    }

    @Then("debería ver una ventana emergente despues de cinco segundos")
    public void deberíaVerUnaVentanaEmergenteDespuesDeCincoSegundos() {
        try {
            String alertText = alert.getText();
            Assert.assertEquals("This alert appeared after 5 seconds",alertText);
            alert.accept();
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
        quiteDrive();
    }

    @When("clickea sobre la alerta con confirmacion")
    public void clickeaSobreLaAlertaConConfirmacion() {
        try {
            alert=alertsPage.confirmacionAlert();
        } catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
    }

    @Then("debería ver una ventana emergente con una opcion de confirmar")
    public void deberíaVerUnaVentanaEmergenteConUnaOpcionDeConfirmar() {
        try {
            String alertText = alert.getText();
            Assert.assertEquals("Do you confirm action?",alertText);
            alert.accept();
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
        quiteDrive();
    }

    @When("clickea sobre la alerta con prompt enviando el name Juan")
    public void clickeaSobreLaAlertaConPromptEnviandoElNameJuan( ) {
        try {
            alert=alertsPage.promptAlert();
        } catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
    }

    @Then("deberia observar la alerta con el nombre")
    public void deberiaObservarLaAlertaConElNombre() {
        alert.sendKeys("Juan");
        try {
            String alertText = alert.getText();
            alert.sendKeys("Juan");
            Assert.assertEquals("Please enter your name",alertText);
            alert.accept();
        }catch (Exception e){
            quiteDrive();
            Assert.fail();
        }
        quiteDrive();
    }
}
