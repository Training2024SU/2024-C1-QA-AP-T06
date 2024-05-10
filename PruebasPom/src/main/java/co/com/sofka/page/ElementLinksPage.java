package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;


public class ElementLinksPage extends FunctionsCommons {

    private String validatelinkHomd;
    private String validateDynamiclink;

    public ElementLinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //localizadores
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Elements')]/ancestor::div[@class='element-group'] //li[@id='item-5']")
    private WebElement links;

    @CacheLookup
    @FindBy(id = "simpleLink")
    private WebElement linkHomd;

    @CacheLookup
    @FindBy(id = "dynamicLink")
    private WebElement dynamicLink;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Selenium Online Training']")
    private WebElement bannerHome;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    //funciones

    public void irALinks(){
        clickSelection(links);
    }

    public void testLinks(){
        wait.until(ExpectedConditions.visibilityOf(linkHomd));
        wait.until(ExpectedConditions.visibilityOf(dynamicLink));

        this.validatelinkHomd = testLinkNewTab(linkHomd);
        this.validateDynamiclink = testLinkNewTab(dynamicLink);
    }

    public String testLinkNewTab (WebElement elementLink){

        // Obtener la ventana/pestaña inicial
        String ventanaInicial = driver.getWindowHandle();

        // Encontrar el elemento que contiene el enlace y hacer clic en él
        clickSelection(elementLink);

        String newTab = elementLink.getAttribute("href");

        driver.switchTo().window(ventanaInicial);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return newTab;

    }



    public int verifyLink(String url) {
        int response = 0;
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();

          response =  httpURLConnection.getResponseCode();

        } catch (Exception e) {
            System.out.println(e);
        }

        return response;
    }

    public String getValidatelinkHomd() {
        return validatelinkHomd;
    }

    public String getValidateDynamiclink() {
        return validateDynamiclink;
    }

        public boolean validarImageBanner(WebElement linkToValidate){
        boolean linkValidate = false;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(linkToValidate));
            linkValidate = true;

        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println(e);

        }

        return linkValidate;
    }



}
