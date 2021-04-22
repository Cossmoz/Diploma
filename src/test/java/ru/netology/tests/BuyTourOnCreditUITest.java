package ru.netology.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.PaymentType;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.openURL;
import static ru.netology.pages.FormField.inputData;
import static ru.netology.pages.Notification.*;


public class BuyTourOnCreditUITest {
    @BeforeEach
    public void paymentType() {
        openURL();
        clearBrowserCache();
        PaymentType.goToBuyTourOnCredit();
    }

    @AfterEach
    public void cleanDB () {
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



    // Positive tests

    @Test
    void shouldBeNotCountCredit() {
        inputData(DataHelper.getEmptyCard());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeApprovedOperationNotificationCredit() {
        inputData(DataHelper.getApprovedCard());
        approvedOperationNotification();
    }

    @Test
    void shouldBeFailedOperationNotificationCredit() {
        inputData(DataHelper.getDeclinedCard());
        failedOperationNotification();
    }



    // Negative tests
    // Not Valid Number Tests

    @Test
    void shouldBeNotCountAfterWithoutCardNumberCredit() {
        inputData(DataHelper.getCardWithoutCardNumber());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfter15DigitCardNumberCredit() {
        inputData(DataHelper.getCard15DigitCardNumber());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Month Tests

    @Test
    void shouldBeNotCountAfterWithoutMonthValueCredit() {
        inputData(DataHelper.getCardWithoutMonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }


    @Test
    void shouldBeNotCountAfter1DigitMonthValueCredit() {
        inputData(DataHelper.getCard1DigitMonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterOver12MonthValueCredit() {
        inputData(DataHelper.getCardOver12MonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfter00MonthValueCredit() {
        inputData(DataHelper.getCard00MonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Year Tests

    @Test
    void shouldBeNotCountAfterWithoutYearValueCredit() {
        inputData(DataHelper.getCardWithoutYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard1DigitYearValueCredit() {
        inputData(DataHelper.getCard1DigitYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardLessCurrentYearValueCredit() {
        inputData(DataHelper.getCardLessCurrentYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }



    @Test
    void shouldBeNotCountAfterCardCurrentYearPlus6ValueCredit() {
        inputData(DataHelper.getCardCurrentYearPlus6Value());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard00MYearValueCredit() {
        inputData(DataHelper.getCard00MYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Holder Tests

    @Test
    void shouldBeNotCountAfterCardWithoutHolderValueCredit() {
        inputData(DataHelper.getCardWithoutHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard1WordHolderValueCredit() {
        inputData(DataHelper.getCard1WordHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardCyrillicHolderValueCredit() {
        inputData(DataHelper.getCardCyrillicHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardDigitsHolderValueCredit() {
        inputData(DataHelper.getCardDigitsHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardSymbolsHolderValueCredit() {
        inputData(DataHelper.getCardSymbolsHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Holder CVV

    @Test
    void shouldBeNotCountAfterCardWithoutCvvValueCredit() {
        inputData(DataHelper.getCardWithoutCvvValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard1DigitCvvValueCredit() {
        inputData(DataHelper.getCard1DigitCvvValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard2DigitCvvValueCredit() {
        inputData(DataHelper.getCard2DigitCvvValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

}
