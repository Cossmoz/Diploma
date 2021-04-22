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
import static ru.netology.pages.Notification.wrongFormatNotification;


public class BuyTourDBTest {

    @BeforeEach
    public void paymentType() {
        openURL();
        clearBrowserCache();
        PaymentType.goToBuyTour();
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
    void shouldBeNotCountAfterEmptyCardBuy() {
        inputData(DataHelper.getEmptyCard());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeApprovedPaymentStatusInDBBuy() {
        inputData(DataHelper.getApprovedCard());
        notification();
        assertEquals("APPROVED", SqlHelper.getPaymentStatus());
    }

    @Test
    void shouldBeDeclinedPaymentStatusInDBBuy() {
        inputData(DataHelper.getDeclinedCard());
        notification();
        assertEquals("DECLINED", SqlHelper.getPaymentStatus());
    }

    // Negative tests
    // Not Valid Number Tests

    @Test
    void shouldBeNotCountAfterWithoutCardNumberBuy() {
        inputData(DataHelper.getCardWithoutCardNumber());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfter15DigitCardNumberBuy() {
        inputData(DataHelper.getCard15DigitCardNumber());
        wrongFormatNotification();
    }

    // Not Valid Month Tests

    @Test
    void shouldBeNotCountAfterWithoutMonthValueBuy() {
        inputData(DataHelper.getCardWithoutMonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }


    @Test
    void shouldBeNotCountAfter1DigitMonthValueBuy() {
        inputData(DataHelper.getCard1DigitMonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterOver12MonthValueBuy() {
        inputData(DataHelper.getCardOver12MonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfter00MonthValueBuy() {
        inputData(DataHelper.getCard00MonthValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Year Tests

    @Test
    void shouldBeNotCountAfterWithoutYearValueBuy() {
        inputData(DataHelper.getCardWithoutYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard1DigitYearValueBuy() {
        inputData(DataHelper.getCard1DigitYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardLessCurrentYearValueBuy() {
        inputData(DataHelper.getCardLessCurrentYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardCurrentYearPlus6ValueBuy() {
        inputData(DataHelper.getCardCurrentYearPlus6Value());
        assertEquals("0", SqlHelper.getOrderCount());
    }


    @Test
    void shouldBeNotCountAfterCard00MYearValueBuy() {
        inputData(DataHelper.getCard00MYearValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Holder Tests

    @Test
    void shouldBeNotCountAfterCardWithoutHolderValueBuy() {
        inputData(DataHelper.getCardWithoutHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard1WordHolderValueBuy() {
        inputData(DataHelper.getCard1WordHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardCyrillicHolderValueBuy() {
        inputData(DataHelper.getCardCyrillicHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardDigitsHolderValueBuy() {
        inputData(DataHelper.getCardDigitsHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCardSymbolsHolderValueBuy() {
        inputData(DataHelper.getCardSymbolsHolderValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    // Not Valid Holder CVV

    @Test
    void shouldBeNotCountAfterCardWithoutCvvValueBuy() {
        inputData(DataHelper.getCardWithoutCvvValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard1DigitCvvValueBuy() {
        inputData(DataHelper.getCard1DigitCvvValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeNotCountAfterCard2DigitCvvValueBuy() {
        inputData(DataHelper.getCard2DigitCvvValue());
        assertEquals("0", SqlHelper.getOrderCount());
    }

}
