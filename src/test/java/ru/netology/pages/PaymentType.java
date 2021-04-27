package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;


public class PaymentType {
    private SelenideElement buyButton = $$(".button").find(exactText("Купить"));
    private SelenideElement creditButton = $$(".button").find(exactText("Купить в кредит"));



    public PaymentType goToBuyTour() {
        buyButton.click();
        return null;
    }

    public PaymentType goToBuyTourOnCredit() {
        creditButton.click();
        return null;
    }

}