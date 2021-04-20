package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;


public class PaymentType {
    private static SelenideElement buyButton = $$(".button").find(exactText("Купить"));
    private static SelenideElement creditButton = $$(".button").find(exactText("Купить в кредит"));



    public static void goToBuyTour() {
        buyButton.click();
    }

    public static void goToBuyTourOnCredit() {
        creditButton.click();
    }

}
