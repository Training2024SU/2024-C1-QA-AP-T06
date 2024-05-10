package co.com.sofka.stepdefinitions.bookstore;

import co.com.sofka.page.PageFactoryMain;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class BookStoreApplication extends WebSetup {
    PageFactoryMain pageFactoryMain;

    @Given("el usuario esta en la pagina de demoqa Book Store {int}")
    public void el_usuario_esta_en_la_pagina_de_demoqa_book_store(int browser) {
        try {
            generalSetup(browser);
            pageFactoryMain = new PageFactoryMain(driver);
            pageFactoryMain.navegarBookStoreApplication();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }
    }
}

