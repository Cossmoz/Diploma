package ru.netology.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.Card;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.FormField;
import ru.netology.pages.Notification;
import ru.netology.pages.PaymentType;
import ru.netology.pages.PaymentType;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @AfterEach
    public void cleanBase() {
        SqlHelper.cleanDB();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void buyPositiveAllFieldValidApproved() {
        FormField form = new FormField();
        FormField.inputData(DataHelper.getApprovedCard());
        approvedPayment();
        assertEquals("APPROVED", SqlHelper.getPaymentStatus());
    }

//    @Test
//    void buyPositiveAllFieldValidDeclined() {
//        FormField form = new FormField();
//        FormField.inputData(DataHelper.getDeclinedCard());
//        failedPayment();
//    }

}
