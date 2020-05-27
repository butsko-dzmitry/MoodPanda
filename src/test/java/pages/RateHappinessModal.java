package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateHappinessModal extends BaseModal {

    By sliderCss = By.cssSelector(".ui-slider-handle");
    By updateButtonCss = By.cssSelector(".ButtonUpdate");
    By goToMyDiaryCss = By.cssSelector(".ButtonMyDiary");

    public RateHappinessModal isModalOpened() {
        $(updateButtonCss).waitUntil(Condition.visible,10000);
        return this;
    }

    public RateHappinessModal updateMood(int moodRating) {
        $(sliderCss).click();
        int changeValue;
        if(moodRating > 5) {
            changeValue = moodRating - 5;
            for (int i = 0; i < changeValue ; i++) {
                $(sliderCss).sendKeys(Keys.ARROW_RIGHT);
            }
        }else if(moodRating < 5) {
          changeValue =  5 - moodRating;
            for (int i = 0; i < changeValue ; i++) {
                $(sliderCss).sendKeys(Keys.ARROW_LEFT);
            }
        }
        $(updateButtonCss).click();
        return this;
    }

    public MyDiaryPage goToMyDiary() {
        $(goToMyDiaryCss).click();
        MyDiaryPage myDiaryPage = new MyDiaryPage();
        myDiaryPage.isPageOpened();
        return myDiaryPage;
    }

}
