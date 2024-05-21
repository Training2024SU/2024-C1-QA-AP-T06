package co.com.sofka.stepdefinitions.interactions;

import co.com.sofka.page.InteractionsPage;
import co.com.sofka.page.ResizablePage;
import co.com.sofka.page.SelectablePage;
import co.com.sofka.setup.WebSetup;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.not;

public class SelectionSteps extends WebSetup {
    SelectablePage selectablePage;

    @ParameterType("\\[([0-9, ]*)\\]")
    public List<Integer> listOfIntegers(String integers) {
        return Arrays.stream(integers.split(", ?"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Given("El usuario accede a la opción de seleccionables")
    public void elUsuarioAccedeALaOpcionDeSeleccionables() {
        try {
            InteractionsPage interactionsPage = new InteractionsPage(driver);
            interactionsPage.navegarASelectablePage();
            selectablePage = new SelectablePage(driver);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @When("selecciona los elementos {listOfIntegers}")
    public void seleccionaLosElementos(List<Integer> posiciones) {
        try {
            selectablePage.seleccionarItems(posiciones);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @And("des-selecciona los items {listOfIntegers}")
    public void desSeleccionaLosItems(List<Integer> posiciones) {
        try {
            selectablePage.desSeleccionarItemsLista(posiciones);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @Then("debería ver seleccionados los elementos {listOfIntegers}")
    public void deberiaVerSeleccionadosLosElementos(List<Integer> posiciones) {
        try {
            assertThat(selectablePage.obtenerItemsListaSeleccionados(), contains(posiciones.toArray()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }
    }

    @When("selecciona y des-selecciona varios elementos")
    public void seleccionaYDesSeleccionaVariosElementos() {
        try {
            selectablePage.interactuarConItemsGrid();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            quiteDrive();
            Assertions.fail();
        }

    }

    @Then("debería ver los elementos seleccionados correctamente")
    public void deberiaVerLosElementosSeleccionadosCorrectamente() {
        try {
            assertThat(selectablePage.obtenerItemsGridSeleccionados(),
                    not(emptyCollectionOf(Integer.class)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDrive();
        }

    }
}
