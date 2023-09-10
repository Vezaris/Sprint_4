package Praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    // Срздание драйвера и ждун
    protected void before() {
        if ("firefox".equals(System.getProperty("browser")))
            setupFirefox();
        else
            setupChrome();
        driver.manage().timeouts().pageLoadTimeout(EnvConfig.defoultTimeout, TimeUnit.SECONDS);
    }

    public void setupChrome () {
        driver = new ChromeDriver();

        // Для конерктного пути
        /*System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/WebDriver/bin/chromedriver"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(service, options);*/
    }

    public void setupFirefox () {
        driver = new FirefoxDriver();

        // Для конерктного пути
        /*System.setProperty("webdriver.http.factory", "jdk-http-client");
        var service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("/WebDriver/bin/geckodriver"))
                .build();

        var options = new FirefoxOptions()
                .setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        driver = new FirefoxDriver(service, options);*/
    }

    @Override
    // Закрытие драйвера
    protected void after()  {
        driver.quit();
    }

    // Получение драйвера
    public WebDriver getDriver() {
        return driver;
    }
}
