package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class MoodPandaTest extends BaseTest {


    @Test
    public void login() {
        loginPage
                .openPage()
                .login("dmitry.butsko@mailinator.com","qwerty12345")
                .openRateHappinessModal();
    }
}
