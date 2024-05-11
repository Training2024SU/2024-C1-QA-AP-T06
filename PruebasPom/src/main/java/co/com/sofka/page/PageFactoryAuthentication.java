package co.com.sofka.page;

import co.com.sofka.model.UserRegisterPageModel;
import co.com.sofka.page.function.FunctionsCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryAuthentication extends FunctionsCommons {
    @CacheLookup
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    // register

    @CacheLookup
    @FindBy(id = "newUser")
    private WebElement registerBtn;

    @CacheLookup
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @CacheLookup
    @FindBy(id = "lastname")
    private WebElement lastnameInput;

    @CacheLookup
    @FindBy(id = "userName")
    private WebElement usernameInput;

    @CacheLookup
    @FindBy(id = "password")
    private WebElement passwordInput;

    @CacheLookup
    @FindBy(id = "register")
    private WebElement confirmRegisterBtn;

    @CacheLookup
    @FindBy(id = "gotologin")
    private WebElement goToLoginBtn;




    public PageFactoryAuthentication(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    public void goToAuthentication(){
        clickSelection(loginBtn);
    }

    public void goToRegistration(){
        clickSelection(registerBtn);
    }

    public void fillUserData(UserRegisterPageModel userRegisterPageModel){
        scrollTo(goToLoginBtn);
        typeInto(firstNameInput, userRegisterPageModel.getName());
        typeInto(lastnameInput, userRegisterPageModel.getLastname());
        typeInto(usernameInput, userRegisterPageModel.getUsername());
        typeInto(passwordInput, userRegisterPageModel.getPassword());
    }




    public String getFirstName(){
        return firstNameInput.getAttribute("value");
    }
    public String getLastname(){
        return lastnameInput.getAttribute("value");
    }
    public String getUserName(){
        return usernameInput.getAttribute("value");
    }
    public String getPassword(){
        return passwordInput.getAttribute("value");
    }

}
