package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentType {
    private static SelenideElement buyButton = $$(".button").find(exactText("Купить"));
    private static SelenideElement creditButton = $$(".button").find(exactText("Купить в кредит"));



    public static BuyTour goToBuyTour() {
        buyButton.click();
        return new BuyTour();
    }

    public BuyTourOnCredit goToBuyTourOnCredit() {
        creditButton.click();
        return new BuyTourOnCredit();
    }

}
