package ru.netology.tests;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.FormField;
import ru.netology.pages.PaymentType;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class BuyTourTest extends TestBase {

    FormField formDate = new FormField();

    // Positive tests

    @Test
    void shouldBeWrongHolderNotificationOperationNotificationBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getEmptyCard());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeApprovedOperationNotificationBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getApprovedCard());
        Assertions.assertAll(
                () ->  formDate.verifyApprovedOperationNotification(),
                () -> assertEquals("APPROVED", SqlHelper.getPaymentStatus())
        );
    }

    @Test
    void shouldBeFailedOperationNotificationBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getDeclinedCard());
        Assertions.assertAll(
                () ->  formDate.verifyFailedOperationNotification(),
                () -> assertEquals("DECLINED", SqlHelper.getPaymentStatus())
        );
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardMaxYearValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardMaxYearValue());
        formDate.verifyApprovedOperationNotification();
    }


    // Negative tests
    // Not Valid Number Tests

    @Test
    void shouldBeRequiredToFilAfterWithoutCardNumberBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutCardNumber());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter15DigitCardNumberBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard15DigitCardNumber());
        formDate.verifyWrongFormatNotification();
    }

    // Not Valid Month Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutMonthValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutMonthValue());
        formDate.verifyRequiredToFillNotification();
    }


    @Test
    void shouldBeWrongFormatNotificationAfter1DigitMonthValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1DigitMonthValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterOver12MonthValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardOver12MonthValue());
        formDate.verifyWrongExpiredCardNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter00MonthValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard00MonthValue());
        formDate.verifyWrongFormatNotification();
    }

    // Not Valid Year Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutYearValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutYearValue());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitYearValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1DigitYearValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardLessCurrentYearValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardLessCurrentYearValue());
        formDate.verifyExpiredCardNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardCurrentYearPlus6ValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardCurrentYearPlus6Value());
        formDate.verifyWrongExpiredCardNotification();
    }


    @Test
    void shouldBeExpiredCardNotificationAfterCard00MYearValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard00MYearValue());
        formDate.verifyExpiredCardNotification();
    }

    // Not Valid Holder Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutHolderValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutHolderValue());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1WordHolderValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1WordHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardCyrillicHolderValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardCyrillicHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardDigitsHolderValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardDigitsHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardSymbolsHolderValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardSymbolsHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    // Not Valid Holder CVV

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutCvvValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutCvvValue());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitCvvValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1DigitCvvValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard2DigitCvvValueBuy() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard2DigitCvvValue());
        formDate.verifyWrongFormatNotification();
    }

}