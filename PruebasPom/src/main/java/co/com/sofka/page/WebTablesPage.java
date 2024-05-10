package co.com.sofka.page;

import co.com.sofka.model.WebTableModel;
import co.com.sofka.page.function.FunctionsCommons;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class WebTablesPage extends FunctionsCommons {

    private WebTableModel fila;

    //Localizadores
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement BOTON_AGREGAR_FILA;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement CAMPO_NOMBRE;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement CAMPO_APELLIDO;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement CAMPO_CORREO;

    @CacheLookup
    @FindBy(id = "age")
    private WebElement CAMPO_EDAD;

    @CacheLookup
    @FindBy(id = "salary")
    private WebElement CAMPO_SALARIO;

    @CacheLookup
    @FindBy(id = "department")
    private WebElement CAMPO_DEPARTAMENTO;

    @CacheLookup
    @FindBy(id = "edit-record-1")
    private WebElement BOTON_EDITAR;

    @CacheLookup
    @FindBy(id = "delete-record-2")
    private WebElement BOTON_ELIMINAR;

    @CacheLookup
    @FindBy(id = "searchBox")
    private WebElement CAMPO_BUSQUEDA;

    @CacheLookup
    @FindBy(id = "submit")
    private WebElement BOTON_SUBMIT;

    @CacheLookup
    @FindBy(xpath = "//*[@class='element-list collapse show']//*[@id='item-3']")
    private WebElement BOTON_WEB_ELEMENTS;




    //Funciones

    public WebTablesPage(WebDriver driver, WebTableModel fila) {
        super(driver);
        this.fila = fila;
        PageFactory.initElements(driver, this);
    }

    public void abrirWebElements(){
        clickSelection(BOTON_WEB_ELEMENTS);
    }

    public void agregarNuevaFila() throws InterruptedException {

        refrescarLocalizadoresFormulario();
        typeInto(CAMPO_NOMBRE, String.valueOf(fila.getNombre()));
        typeInto(CAMPO_APELLIDO, String.valueOf(fila.getApellido()));
        typeInto(CAMPO_CORREO, String.valueOf(fila.getCorreo()));
        typeInto(CAMPO_EDAD, String.valueOf(fila.getEdad()));
        typeInto(CAMPO_SALARIO, String.valueOf(fila.getSalario()));
        typeInto(CAMPO_DEPARTAMENTO, String.valueOf(fila.getDepartamento()));

        waitSeconds(1);
        clickSelection(BOTON_SUBMIT);
        waitSeconds(1);
    }

    private void refrescarLocalizadoresFormulario() {

        CAMPO_NOMBRE = driver.findElement(By.id("firstName"));
        CAMPO_APELLIDO = driver.findElement(By.id("lastName"));
        CAMPO_CORREO = driver.findElement(By.id("userEmail"));
        CAMPO_EDAD = driver.findElement(By.id("age"));
        CAMPO_SALARIO = driver.findElement(By.id("salary"));
        CAMPO_DEPARTAMENTO = driver.findElement(By.id("department"));
        CAMPO_BUSQUEDA = driver.findElement(By.id("searchBox"));
        BOTON_SUBMIT = driver.findElement(By.id("submit"));

    }

    public void agregarFilaBoton() {
        clickSelection(BOTON_AGREGAR_FILA);
    }

    public void editarFila(String Correo){

        buscarFilaCorreo(Correo);
        clickSelection(BOTON_EDITAR);

        refrescarLocalizadoresFormulario();
        Faker faker = new Faker();

        typeInto(CAMPO_NOMBRE, faker.name().firstName());
        typeInto(CAMPO_APELLIDO, faker.name().lastName());
        typeInto(CAMPO_EDAD, String.valueOf(faker.number().numberBetween(18, 80)));
        typeInto(CAMPO_SALARIO, String.valueOf(faker.number().numberBetween(1000,12000)));
        typeInto(CAMPO_DEPARTAMENTO, faker.industrySegments().sector());

        waitSeconds(1);
        clickSelection(BOTON_SUBMIT);
    }

    public void eliminarFila(String Correo){
        buscarFilaCorreo(Correo);
        clickSelection(BOTON_ELIMINAR);
    }

    public void buscarFilaCorreo(String Correo){
        limpiarCampoBusqueda();
        typeInto(CAMPO_BUSQUEDA, Correo);
    }

    private void limpiarCampoBusqueda() {
        limpiarCampo(CAMPO_BUSQUEDA);
    }

    public By obtenerByXpath(String elemento){
        waitSeconds(1);
        switch (elemento) {
            case "correo":
                By ASSERTION_EMAIL = By.xpath(String.format("//*[contains(text(), '%s')]", fila.getCorreo()));
                return ASSERTION_EMAIL;
            case "nombre":
                By ASSERTION_NOMBRE = By.xpath(String.format("//*[contains(text(), '%s')]", fila.getNombre()));
                return ASSERTION_NOMBRE;
            case "apellido":
                By ASSERTION_APELLIDO = By.xpath(String.format("//*[contains(text(), '%s')]", fila.getApellido()));
                return ASSERTION_APELLIDO;
            default:
                System.out.println("Opción no válida");
                break;
        }
        return null;
    }

    public String obtenerTexto(String elemento) {
        return getText(obtenerByXpath(elemento));
    }
}
