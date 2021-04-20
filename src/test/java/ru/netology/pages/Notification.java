package ru.netology.pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class Notification {
    public static void notification() {
        $(".notification__content").waitUntil(visible, 30000).shouldBe(visible);
    }

    public static void approvedOperationNotification() {
        $(".notification__content").waitUntil(visible, 30000).shouldBe(visible).shouldHave(exactText("Операция одобрена Банком."));
    }

    public static void failedOperationNotification() {
        $(".notification__content").waitUntil(visible, 30000).shouldBe(visible).shouldHave(exactText("Ошибка! Банк отказал в проведении операции."));
    }

    public static void wrongFormatNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверный формат"));;
    }

    public static void requiredToFillNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Поле обязательно для заполнения"));;
    }


    public static void expiredCardNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Истёк срок действия карты"));;
    }

    public static void wrongExpiredCardNotification() {
        $(".input__sub").shouldBe(visible).shouldHave(exactText("Неверно указан срок действия карты"));;
    }


}
