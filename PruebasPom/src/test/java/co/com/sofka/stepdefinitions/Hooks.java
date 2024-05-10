package co.com.sofka.stepdefinitions;

import co.com.sofka.setup.WebSetup;
import io.cucumber.java.After;

public class Hooks extends WebSetup {

    @After("@DavidTearDown")
    public void davidWebTearDown(){
        quiteDrive();
    }
}
