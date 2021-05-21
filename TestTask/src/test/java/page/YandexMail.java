package page;

import hooks.PropertyFileRead;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMail extends BasePage {
    String SITE_URL = new PropertyFileRead().getProp("URL");


    public YandexMail(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Open Yandex Mail")
    public YandexMail open() {
        SITE_URL = new PropertyFileRead().getProp("URL");
        driver.get(SITE_URL);
        return this;

    }

    @Step(value = "Fill in login with {0}")
    public YandexMail fillInLogin(String login){
        writeText(By.xpath("//input[@name='login']"), login);
        return this;
    }

    @Step(value = "Click next button")
    public YandexMail nextBtnClick(){
        click(By.xpath("//span[.='Войти']/.."));
        return this;
    }

    @Step(value = "Fill in password with {0}")
    public YandexMail fillInPass(String pass){
        writeText(By.xpath("//input[@name='passwd']"), pass);
        return this;
    }

    @Step(value = "Click login button")
    public YandexMail submitBtnClick(){
        click(By.xpath("//button[@type='submit']"));
        return this;
    }

    @Step(value = "Check credentials")
    public YandexMail isLoginCorrect() {
        isElementDisplayed(By.xpath("//span[.='Написать']"));
        return this;
    }


}
