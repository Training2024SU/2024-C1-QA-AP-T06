package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.*;


public class UploadDownloandPage extends FunctionsCommons {

//Localizadores
    private final By BTN_UD = By.id("item-7");
    private final By BTN_DOWNLOAND = By.xpath("//*[@id='downloadButton']");
    private final By CAMPO_UPDOAND = By.id("uploadFile");
    public static final String RUTA_ARCHIVO_PRUEBA ="src/test/resources/testfile/prueba.txt";


    //Contructor
    public UploadDownloandPage(WebDriver driver) {
        super(driver);
    }
//Funciones

    public void subirArchivo(){
        typeInto(CAMPO_UPDOAND, RUTA_ARCHIVO_PRUEBA);
        clickSelection(CAMPO_UPDOAND);

    }

    public void entrarUD(){
        scrollTo(BTN_UD);
        clickSelection(BTN_UD);
    }

    public void goToBtnDonw(){
        clickSelection(BTN_DOWNLOAND);
    }
    public void goToBtnUpload(){
        clickSelection(CAMPO_UPDOAND);
    }


}
