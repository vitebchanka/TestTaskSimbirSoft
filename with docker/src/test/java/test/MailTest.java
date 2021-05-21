package test;

import hooks.PropertyFileRead;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


public class MailTest extends TestBase {
    PropertyFileRead properties = new PropertyFileRead();
    String login = properties.getProp("login");
    String password = properties.getProp("password");
    String mailTheme = properties.getProp("mailTheme");

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Epic("SimbirSoft test Task")
    @Feature(value = "Tests for Yandex Mailbox")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will login with correct credentials. " +
            "When we logged we check count of messages, and send new message")
    @Story(value = "Test for login in Yandex mailbox")

    @Test
    public void loginIntoYandexMailboxCheckCredentialsAndSendMail() {
        yandexMail
                .open()
                .nextBtnClick()
                .fillInLogin(login)
                .submitBtnClick()
                .fillInPass(password)
                .submitBtnClick()
                .isLoginCorrect();
        mailBox
                .createNewMessage()
                .fillAddress(login + "@yandex.ru")
                .fillMailTheme(mailTheme)
                .fillMessage()
                .sendMessage();
    }

}
