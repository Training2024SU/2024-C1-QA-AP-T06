package co.com.sofka.stepdefinitions.forms;

import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;

public class TestForms extends WebSetup {
    @Given("El usuario esta en la pagina web de forms demoqa {int}")
    public void el_usuario_esta_en_la_pagina_forms_demoqa(Integer browser) {
        generalSetup(browser);
        PageFactoryMain pageFactoryMain = new PageFactoryMain(driver);
        pageFactoryMain.navegarAForms();
    }
}
