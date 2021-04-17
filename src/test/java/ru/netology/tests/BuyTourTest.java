package ru.netology.tests;

import com.codeborne.selenide.Condition;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.Card;
import ru.netology.data.DataHelper;
import ru.netology.pages.FormField;
import ru.netology.pages.Notification;
import ru.netology.pages.PaymentType;
import ru.netology.pages.PaymentType;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataHelper.getApprovedCard;
import static ru.netology.data.DataHelper.openURL;
import static ru.netology.pages.Notification.approvedPayment;
import static ru.netology.pages.Notification.failedPayment;

public class BuyTourTest {
    @BeforeEach
    public void paymentType() {
        openURL();
        PaymentType.goToBuyTour();
    }

    @Test
    void buyPositiveAllFieldValidApproved() {
        FormField form = new FormField();
        FormField.inputData(DataHelper.getApprovedCard());
        approvedPayment();
    }

    @Test
    void buyPositiveAllFieldValidDeclined() {
        FormField form = new FormField();
        FormField.inputData(DataHelper.getDeclinedCard());
        failedPayment();
    }

}
