package co.com.sofka.page;

import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.opentelemetry.semconv.SemanticAttributes.AndroidStateValues.CREATED;


public class ElementLinksPage extends FunctionsCommons {

    private String validatelinkHomd;
    private String validateDynamiclink;

    private String responseCreated ;
    private String responseNoContent ;
    private String responseMoved ;
    private String responseBadRequest ;
    private String responseUnauthorized ;
    private String responseForbidden ;
    private String responseNotFound;

    public static final String CREATED = "201";
    public static final String NO_CONTENT = "204";
    public static final String MOVED = "301";
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";

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
    @FindBy(id = "created")
    private WebElement createdLink;

    @CacheLookup
    @FindBy(id = "no-content")
    private WebElement noContentLink;

    @CacheLookup
    @FindBy(id = "moved")
    private WebElement movedLink;

    @CacheLookup
    @FindBy(id = "bad-request")
    private WebElement badRequestLink;

    @CacheLookup
    @FindBy(id = "unauthorized")
    private WebElement unauthorizedLink;

    @CacheLookup
    @FindBy(id = "forbidden")
    private WebElement forbiddenLink;

    @CacheLookup
    @FindBy(id = "invalid-url")
    private WebElement invalidUrlLink;

    @CacheLookup
    @FindBy(id = "linkResponse")
    private WebElement linkResponseLink;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    //funciones


    public String getResponseCreated() {
        return responseCreated;
    }

    public String getResponseNoContent() {
        return responseNoContent;
    }

    public String getResponseMoved() {
        return responseMoved;
    }

    public String getResponseBadRequest() {
        return responseBadRequest;
    }

    public String getResponseUnauthorized() {
        return responseUnauthorized;
    }

    public String getResponseForbidden() {
        return responseForbidden;
    }

    public String getResponseNotFound() {
        return responseNotFound;
    }

    public void irALinks(){
        clickSelection(links);
    }

    public void testLinks(){
        scrollTo(linkHomd);

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

        return newTab;

    }



    public void createdClick (){
        scrollTo(createdLink);
        wait.until(ExpectedConditions.elementToBeClickable(createdLink));
        clickSelection(createdLink);
        this.responseCreated = responseTextLinkApi(CREATED);;
    }

    public void noContentClick() {
        wait.until(ExpectedConditions.elementToBeClickable(noContentLink));
        clickSelection(noContentLink);
        this.responseNoContent = responseTextLinkApi(NO_CONTENT);
    }

    public void movedClick() {
        wait.until(ExpectedConditions.elementToBeClickable(movedLink));
        clickSelection(movedLink);
        this.responseMoved = responseTextLinkApi(MOVED);
    }

    public void badRequestClick() {
        wait.until(ExpectedConditions.elementToBeClickable(badRequestLink));
        clickSelection(badRequestLink);
        this.responseBadRequest = responseTextLinkApi(BAD_REQUEST);
    }

    public void unauthorizedClick() {
        wait.until(ExpectedConditions.elementToBeClickable(unauthorizedLink));
        clickSelection(unauthorizedLink);
        this.responseUnauthorized = responseTextLinkApi(UNAUTHORIZED);
    }

    public void forbiddenClick() {
        wait.until(ExpectedConditions.elementToBeClickable(forbiddenLink));
        clickSelection(forbiddenLink);
        this.responseForbidden = responseTextLinkApi(FORBIDDEN);
    }

    public void notFoundClick() {
        wait.until(ExpectedConditions.elementToBeClickable(invalidUrlLink));
        clickSelection(invalidUrlLink);
        this.responseNotFound = responseTextLinkApi(NOT_FOUND);
    }


    public String getValidatelinkHomd() {
        return validatelinkHomd;
    }

    public String getValidateDynamiclink() {
        return validateDynamiclink;
    }

    public String responseTextLinkApi(String idResponse){
        String xpath = "//p[@id='linkResponse']//b[contains(text(),'"+idResponse+"')]";
        By localtor = By.xpath(xpath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(localtor));
        return  getText(localtor);
    }

}
