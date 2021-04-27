package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Card;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FormField {
    private SelenideElement cardNumberField = $$(".input__inner").find(exactText("Номер карты")).$(".input__control");
    private SelenideElement cardMonthField = $$(".input__inner").find(exactText("Месяц")).$(".input__control");
    private SelenideElement cardYeaField = $$(".input__inner").find(exactText("Год")).$(".input__control");
    private SelenideElement carHolderField = $$(".input__inner").find(exactText("Владелец")).$(".input__control");
    private SelenideElement cardCvvField = $$(".input__inner").find(exactText("CVC/CVV")).$(".input__control");
    private SelenideElement continueButton = $$(".button").find(exactText("Продолжить"));



    public void inputData(Card card) {
        cardNumberField.setValue(card.getCardNumber());
        cardMonthField.setValue(card.getCardMonth());
        cardYeaField.setValue(card.getCardYear());
        carHolderField.setValue(card.getCardHolder());
        cardCvvField.setValue(card.getCardCvv());
        continueButton.click();
    }

//    public void notification() {
//        $(".notification__content").waitUntil(visible, 30000).shouldBe(visible);
//    }

    public void verifyApprovedOperationNotification() {
        $(".notification__content").waitUntil(visible, 30000).shouldBe(visible).shouldHave(exactText("Операция одобрена Банком."));
    }

    public void verifyFailedOperationNotification() {
        $(".notification__content").waitUntil(visible, 30000).shouldBe(visible).shouldHave(exactText("Ошибка! Банк отказал в проведении операции."));
    }

    public void verifyWrongFormatNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверный формат"));;
    }

    public void verifyRequiredToFillNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Поле обязательно для заполнения"));;
    }


    public void verifyExpiredCardNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Истёк срок действия карты"));;
    }

    public void verifyWrongExpiredCardNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверно указан срок действия карты"));;
    }


}





