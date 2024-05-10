package co.com.sofka.stepdefinitions.elements;

import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;


public class TestElements extends WebSetup {
    @Given("El usuario esta en la pagina web de elements demoqa {int}")
    public void el_usuario_esta_en_la_pagina_web_de_elements_demoqa(Integer browser) {
        generalSetup(browser);
        PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
        pageFactoryMain.navegarAElements();
    }
}
