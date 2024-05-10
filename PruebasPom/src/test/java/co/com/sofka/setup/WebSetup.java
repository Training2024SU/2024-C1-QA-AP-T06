package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static co.com.sofka.Constantes.DEMO_QA_URL;
import static co.com.sofka.Constantes.OPCION_VALIDA;

public class WebSetup {
    protected static WebDriver driver;

    private void setupWebDriverUrl(int driverSelect) {
        switch (driverSelect) {
            case 1:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case 2:
                edgeConfiguration();
                break;
            case 3:
                firefoxConfiguration();
            default:
                System.out.println(OPCION_VALIDA);
        }
        driver.get(DEMO_QA_URL);
//        maximize();
    }

    private void firefoxConfiguration() {
        FirefoxOptions fo = new FirefoxOptions();
        fo.addArguments("-private");
        fo.addPreference("extensions.allowPrivateBrowsingByDefault", true);
        FirefoxProfile fp = new FirefoxProfile();
        fp.setPreference("browser.privatebrowsing.autostart", true);
        fo.setProfile(fp);
//                fo.addArguments("-headless");
        driver = new FirefoxDriver(fo);
    }

    private void edgeConfiguration() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        edgeOptions.setCapability("ms:edgeChromium", true);
        edgeOptions.setCapability("ms:edgeOptions", "--headless");
        driver = new EdgeDriver(edgeOptions);
    }

    protected void generalSetup(int tipoDriver) {
        setupWebDriverUrl(tipoDriver);
    }

    protected void quiteDrive() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }


}