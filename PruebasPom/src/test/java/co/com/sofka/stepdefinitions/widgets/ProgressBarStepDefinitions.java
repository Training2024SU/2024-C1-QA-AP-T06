package co.com.sofka.stepdefinitions.widgets;

import co.com.sofka.page.ProgressBarPage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;



public class ProgressBarStepDefinitions extends WebSetup {
    ProgressBarPage progressBarPage;

    @When("se dirije a la pagina Progress bar")
    public void se_dirije_a_la_pagina_progress_bar() {
        try {
            progressBarPage = new ProgressBarPage(driver);
            progressBarPage.abrirMenuProgressBar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("usa el boton Start")
    public void usa_el_boton_start() {
        try {
            progressBarPage.clickBotonStartStop();
            progressBarPage.waitSeconds(2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("pausa la barra de progreso")
    public void pausa_la_barra_de_progreso() {
        try {
            progressBarPage.clickBotonStartStop();
            progressBarPage.waitSeconds(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @When("la activa otra vez")
    public void la_activa_otra_vez() {
        try {
            progressBarPage.clickBotonStartStop();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
    @Then("deberia terminar de cargar la barra completa y ver la palabra {string} y {string}")
    public void deberia_terminar_de_cargar_la_barra_completa_y_ver_la_palabra_y(String reset, String porcentaje) {
        try {
            progressBarPage.esperarQueCargue();
            Assert.assertEquals(porcentaje, progressBarPage.recibirTextoBarra());
            Assert.assertEquals(reset, progressBarPage.recibirTextoReset());
            progressBarPage.waitSeconds(2);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }
}
