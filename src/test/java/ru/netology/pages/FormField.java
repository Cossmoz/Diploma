package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.data.Card;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ru.netology.pages.Notification. *;


public class FormField {
    private static SelenideElement cardNumberField = $$(".input__inner").find(exactText("Номер карты")).$(".input__control");
    private static SelenideElement cardMonthField = $$(".input__inner").find(exactText("Месяц")).$(".input__control");
    private static SelenideElement cardYeaField = $$(".input__inner").find(exactText("Год")).$(".input__control");
    private static SelenideElement carHolderField = $$(".input__inner").find(exactText("Владелец")).$(".input__control");
    private static SelenideElement cardCvvField = $$(".input__inner").find(exactText("CVC/CVV")).$(".input__control");
    private static SelenideElement continueButton = $$(".button").find(exactText("Продолжить"));



    public static void inputData(Card card) {
        cardNumberField.setValue(card.getCardNumber());
        cardMonthField.setValue(card.getCardMonth());
        cardYeaField.setValue(card.getCardYear());
        carHolderField.setValue(card.getCardHolder());
        cardCvvField.setValue(card.getCardCvv());
        continueButton.click();
    }




}





