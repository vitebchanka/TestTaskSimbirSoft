package test;

import hooks.CommonMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import page.YandexMail;
import page.MailBox;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    String nodeUrl;
    public YandexMail yandexMail;
    public MailBox mailBox;


    @BeforeTest
    public void start() throws IOException, InterruptedException {
        CommonMethods.runDockerContainer();
        nodeUrl = "http://192.168.0.102:4444/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.ANY);
        driver = new RemoteWebDriver(new URL(nodeUrl), cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        yandexMail = PageFactory.initElements(driver, YandexMail.class);
        mailBox = PageFactory.initElements(driver, MailBox.class);
    }

    @AfterTest
    public void finish() throws IOException, InterruptedException {
        if (driver != null)
            driver.quit();
        CommonMethods.stopDockerContainer();
    }
}