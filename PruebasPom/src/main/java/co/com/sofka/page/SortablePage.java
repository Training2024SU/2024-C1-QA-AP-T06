package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortablePage extends FunctionsCommons {
    private WebDriverWait wait;

    @CacheLookup
    @FindBy(xpath = "//span[@class='text' and text()='Sortable']")
    private WebElement sortableOption;

    @CacheLookup
    @FindBy(id = "demo-tab-grid")
    private WebElement gridOption;

    @CacheLookup
    @FindBy(xpath = "//div[@class='grid-container mt-4']//div[contains(@class, 'list-group-item')]")
    private List<WebElement> listItems;

    @CacheLookup
    @FindBy(id = "Ad.Plus-970x250-2")
    private WebElement adContainer;

    @CacheLookup
    @FindBy(xpath = "//div[@class='list-group-item list-group-item-action' and text()='Three']")
    private WebElement tercerElemnto;


    private List<String> originalOrder;

    public SortablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getElements() {
        clickSelection(sortableOption);
        scrollTo(adContainer);
        clickSelection(gridOption);
    }

    public void getOrganizedElements() {
        scrollTo(adContainer);
    }

    public void organizeElements() {
        int size = listItems.size();

        // Generate random order of indices
        List<Integer> indices = IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(indices);

        // Save original order of element texts
        originalOrder = listItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // Rearrange elements according to new order of indices
        List<WebElement> reorderedElements = indices.stream()
                .map(listItems::get)
                .collect(Collectors.toList());

        // Simulate drag-and-drop using reordered elements
        Actions actions = new Actions(driver);
        IntStream.range(0, size)
                .forEach(i -> actions.clickAndHold(listItems.get(i))
                        .moveToElement(reorderedElements.get(i))
                        .release()
                        .perform());
    }

    public void organizarLista(){
        clickSelection(sortableOption);
        clickHoldAndMoveVertically(tercerElemnto,100);

    }


    public boolean compareLists() {
        for (int i = 0; i < listItems.size(); i++) {
            String element = originalOrder.get(i);
            WebElement organizedElement = listItems.get(i);
            if (!element.equals(organizedElement.getText())) {
                return true; // Comparison fails if a difference is found
            }
        }
        return false;
    }

    public int obtenerPosicionYElemento() {
        return tercerElemnto.getLocation().getY();
    }
}
