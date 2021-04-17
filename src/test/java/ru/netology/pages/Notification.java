package ru.netology.pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class Notification {
    public static void approvedPayment() {
        $(".notification__content").waitUntil(visible, 15000).shouldBe(visible).shouldHave(exactText("Операция одобрена Банком."));
    }

    public static void failedPayment() {
        $(".notification__content").waitUntil(visible, 15000).shouldBe(visible).shouldHave(exactText("Ошибка! Банк отказал в проведении операции."));
    }
}
