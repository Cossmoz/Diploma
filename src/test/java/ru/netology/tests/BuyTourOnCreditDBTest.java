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


public class BuyTourOnCreditDBTest {
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
    void shouldBeNotCountAfterEmptyCardCredit() {
        inputData(DataHelper.getEmptyCard());
        assertEquals("0", SqlHelper.getOrderCount());
    }

    @Test
    void shouldBeApprovedPaymentStatusInDBCredit() {
        inputData(DataHelper.getApprovedCard());
        notification();
        assertEquals("APPROVED", SqlHelper.getCreditPaymentStatus());
    }

    @Test
    void shouldBeDeclinedPaymentStatusInDBCredit() {
        inputData(DataHelper.getDeclinedCard());
        notification();
        assertEquals("DECLINED", SqlHelper.getCreditPaymentStatus());
    }

    // Negative tests
    // Not Valid Number Tests

    @Test
    void shouldBeRequiredToFilAfterWithoutCardNumberCredit() {
        inputData(DataHelper.getCardWithoutCardNumber());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter15DigitCardNumberCredit() {
        inputData(DataHelper.getCard15DigitCardNumber());
        wrongFormatNotification();
    }

    // Not Valid Month Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutMonthValueCredit() {
        inputData(DataHelper.getCardWithoutMonthValue());
        requiredToFillNotification();
    }


    @Test
    void shouldBeWrongFormatNotificationAfter1DigitMonthValueCredit() {
        inputData(DataHelper.getCard1DigitMonthValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterOver12MonthValueCredit() {
        inputData(DataHelper.getCardOver12MonthValue());
        wrongExpiredCardNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter00MonthValueCredit() {
        inputData(DataHelper.getCard00MonthValue());
        wrongFormatNotification();
    }

    // Not Valid Year Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutYearValueCredit() {
        inputData(DataHelper.getCardWithoutYearValue());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitYearValueCredit() {
        inputData(DataHelper.getCard1DigitYearValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardLessCurrentYearValueCredit() {
        inputData(DataHelper.getCardLessCurrentYearValue());
        expiredCardNotification();
    }



    @Test
    void shouldBeExpiredCardNotificationAfterCardCurrentYearPlus6ValueCredit() {
        inputData(DataHelper.getCardCurrentYearPlus6Value());
        wrongExpiredCardNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCard00MYearValueCredit() {
        inputData(DataHelper.getCard00MYearValue());
        expiredCardNotification();
    }

    // Not Valid Holder Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutHolderValueCredit() {
        inputData(DataHelper.getCardWithoutHolderValue());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1WordHolderValueCredit() {
        inputData(DataHelper.getCard1WordHolderValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardCyrillicHolderValueCredit() {
        inputData(DataHelper.getCardCyrillicHolderValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardDigitsHolderValueCredit() {
        inputData(DataHelper.getCardDigitsHolderValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardSymbolsHolderValueCredit() {
        inputData(DataHelper.getCardSymbolsHolderValue());
        wrongFormatNotification();
    }

    // Not Valid Holder CVV

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutCvvValueCredit() {
        inputData(DataHelper.getCardWithoutCvvValue());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitCvvValueCredit() {
        inputData(DataHelper.getCard1DigitCvvValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard2DigitCvvValueCredit() {
        inputData(DataHelper.getCard2DigitCvvValue());
        wrongFormatNotification();
    }

}
