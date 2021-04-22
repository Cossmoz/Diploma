package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import static ru.netology.data.DataHelper.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.PaymentType;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static ru.netology.pages.FormField.inputData;
import static ru.netology.pages.Notification.*;


public class BuyTourUITest {
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
    void shouldBeWrongNotificationBuy() {
        inputData(DataHelper.getEmptyCard());
        wrongNotification();
    }

    @Test
    void shouldBeApprovedOperationNotificationBuy() {
        inputData(DataHelper.getApprovedCard());
        approvedOperationNotification();
    }

    @Test
    void shouldBeFailedOperationNotificationBuy() {
        inputData(DataHelper.getDeclinedCard());
        failedOperationNotification();
    }



    // Negative tests
    // Not Valid Number Tests

    @Test
    void shouldBeRequiredToFilAfterWithoutCardNumberBuy() {
        inputData(DataHelper.getCardWithoutCardNumber());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter15DigitCardNumberBuy() {
        inputData(DataHelper.getCard15DigitCardNumber());
        wrongFormatNotification();
    }

    // Not Valid Month Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutMonthValueBuy() {
        inputData(DataHelper.getCardWithoutMonthValue());
        requiredToFillNotification();
    }


    @Test
    void shouldBeWrongFormatNotificationAfter1DigitMonthValueBuy() {
        inputData(DataHelper.getCard1DigitMonthValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterOver12MonthValueBuy() {
        inputData(DataHelper.getCardOver12MonthValue());
        wrongExpiredCardNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter00MonthValueBuy() {
        inputData(DataHelper.getCard00MonthValue());
        wrongFormatNotification();
    }

    // Not Valid Year Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutYearValueBuy() {
        inputData(DataHelper.getCardWithoutYearValue());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitYearValueBuy() {
        inputData(DataHelper.getCard1DigitYearValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardLessCurrentYearValueBuy() {
        inputData(DataHelper.getCardLessCurrentYearValue());
        expiredCardNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardCurrentYearPlus6ValueBuy() {
        inputData(DataHelper.getCardCurrentYearPlus6Value());
        wrongExpiredCardNotification();
    }


    @Test
    void shouldBeExpiredCardNotificationAfterCard00MYearValueBuy() {
        inputData(DataHelper.getCard00MYearValue());
        expiredCardNotification();
    }

    // Not Valid Holder Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutHolderValueBuy() {
        inputData(DataHelper.getCardWithoutHolderValue());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1WordHolderValueBuy() {
        inputData(DataHelper.getCard1WordHolderValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardCyrillicHolderValueBuy() {
        inputData(DataHelper.getCardCyrillicHolderValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardDigitsHolderValueBuy() {
        inputData(DataHelper.getCardDigitsHolderValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardSymbolsHolderValueBuy() {
        inputData(DataHelper.getCardSymbolsHolderValue());
        wrongFormatNotification();
    }

    // Not Valid Holder CVV

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutCvvValueBuy() {
        inputData(DataHelper.getCardWithoutCvvValue());
        requiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitCvvValueBuy() {
        inputData(DataHelper.getCard1DigitCvvValue());
        wrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard2DigitCvvValueBuy() {
        inputData(DataHelper.getCard2DigitCvvValue());
        wrongFormatNotification();
    }

}
