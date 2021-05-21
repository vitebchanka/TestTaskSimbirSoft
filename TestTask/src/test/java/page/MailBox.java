package page;

import hooks.PropertyFileRead;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailBox extends BasePage {

    String mailTheme = new PropertyFileRead().getProp("mailTheme");
    int messageCount = 0;

    public MailBox(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Check count of messages")
    public int getMailCountByTheme(String theme) {
        List<WebElement> mails = driver.findElements(By.xpath("//span[@title='" + theme + "']"));
        int mailCount = mails.size();
        return mailCount;
    }

    @Step(value = "Create new message")
    public MailBox createNewMessage() {
        click(By.xpath("//a[@title='Написать (w, c)']"));
        return this;
    }

    @Step(value = "Fill address: {0}")
    public MailBox fillAddress(String address) {
        writeText(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div"), address);
        //writeText(By.xpath("//span[.='Кому']/ancestor::div[@class='compose-LabelRow']//div[contains(@class,'MultipleAddresses')]"), address);
        return this;
    }

    @Step(value = "Fill message subject: {0}")
    public MailBox fillMailTheme(String mailTheme) {
        writeText(By.xpath("//input[@class='composeTextField ComposeSubject-TextField']"), mailTheme);
        return this;
    }

    @Step(value = "Fill message")
    public MailBox fillMessage() {
        messageCount = getMailCountByTheme(mailTheme);
        String message = "Количество сообщений = " + messageCount;
        writeText(By.xpath("//div[@placeholder='Напишите что-нибудь']"), message);
        return this;
    }

    @Step(value = "Send message")
    public MailBox sendMessage() {
        click(By.xpath("//span[.='Отправить']/../.."));
        return this;
    }
}
