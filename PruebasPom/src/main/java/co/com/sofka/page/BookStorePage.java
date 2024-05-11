package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage extends FunctionsCommons {

    //Localizadores
    @CacheLookup
    @FindBy(id = "searchBox")
    private WebElement CAMPO_BUSQUEDA;

    @CacheLookup
    @FindBy(xpath = "//*[text() = 'Author']")
    private WebElement BOTON_AUTOR;

    @CacheLookup
    @FindBy(xpath = "//*[text() ='Book Store']")
    private WebElement BOTON_BOOK_STORE;

    @CacheLookup
    @FindBy(xpath = "(//*[@class='rt-tr-group']//*[@class='rt-td'])[3]")
    private WebElement LIBRO_AUTOR_ASSERTION;






    //Metodos
    public BookStorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openBookStore(){
        scrollTo(BOTON_BOOK_STORE);
        clickSelection(BOTON_BOOK_STORE);
    }

    public void filtrarPorAutor(){
        waitToBeVisible(BOTON_AUTOR);
        clickSelection(BOTON_AUTOR);
        waitSeconds(2);
    }

    public void buscarLibro(String nombreLibro){
        typeInto(CAMPO_BUSQUEDA, nombreLibro);
        waitSeconds(2);
    }
    public String obtenerNombreAutor(){
        return getText(LIBRO_AUTOR_ASSERTION);
    }
}
