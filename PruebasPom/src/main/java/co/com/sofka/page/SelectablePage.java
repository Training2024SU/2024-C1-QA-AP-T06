package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static co.com.sofka.util.util.pickRandomItem;

public class SelectablePage extends FunctionsCommons {
    private final By itemsGridLocalizador = By.cssSelector("#gridContainer li");
    @CacheLookup
    @FindBy(css = "#verticalListContainer li")
    private List<WebElement> itemsLista;
    @CacheLookup
    @FindBy(id = "demo-tab-grid")
    private WebElement gridTab;

    public SelectablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void seleccionarItems(List<Integer> indices) {
        for (Integer indice : indices) {
            WebElement item = itemsLista.get(indice - 1);
            seleccionarItem(item);
        }
    }

    public void seleccionarItem(WebElement item) {
        if (!estaSeleccionado(item)) {
            scrollTo(item);
            item.click();
        }
    }

    public void desSeleccionarItemsLista(List<Integer> indices) {
        for (Integer indice : indices) {
            WebElement item = itemsLista.get(indice - 1);
            desSeleccionarItem(item);
        }
    }

    public void desSeleccionarItem(WebElement element) {
        if (estaSeleccionado(element)) {
            scrollTo(element);
            element.click();
        }
    }

    public void interactuarConItemsGrid() {
        gridTab.click();
        List<WebElement> itemsGrid = findElements(itemsGridLocalizador);
        // Seleccionar todos
        for (WebElement item : itemsGrid) {
            seleccionarItem(item);
        }
        // Des-seleccionar algunos dejando mínimo uno
        int cantidadADesSeleccionar = new Random().nextInt(itemsGrid.size());
        for (int i = 0; i < cantidadADesSeleccionar; i++) {
            WebElement item = pickRandomItem(itemsGrid);
            desSeleccionarItem(item);
        }
    }

    public List<Integer> obtenerItemsGridSeleccionados() {
        List<WebElement> gridItems = findElements(itemsGridLocalizador);
        return obtenerItemsSeleccionados(gridItems);
    }

    public List<Integer> obtenerItemsListaSeleccionados() {
        return obtenerItemsSeleccionados(itemsLista);
    }

    public List<Integer> obtenerItemsSeleccionados(List<WebElement> items) {
        List<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            if (estaSeleccionado(item)) {
                posiciones.add(i + 1);
            }
        }
        return posiciones;
    }

    private boolean estaSeleccionado(WebElement items) {
        return items.getAttribute("class").contains("active");
    }
}
