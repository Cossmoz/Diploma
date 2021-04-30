package ru.netology.tests;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SqlHelper;
import ru.netology.pages.FormField;
import ru.netology.pages.PaymentType;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BuyTourOnCreditTest extends TestBase {

    FormField formDate = new FormField();

    // Positive tests

    @Test
    void shouldBeWrongHolderNotificationOperationNotificationCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTourOnCredit();
        formDate.inputData(DataHelper.getEmptyCard());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeApprovedOperationNotificationCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getApprovedCard());
        formDate.verifyApprovedOperationNotification();
        assertEquals("APPROVED", SqlHelper.getPaymentStatus());
    }

    @Test
    void shouldBeFailedOperationNotificationCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getDeclinedCard());
        formDate.verifyFailedOperationNotification();
        assertEquals("DECLINED", SqlHelper.getPaymentStatus());
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardMaxYearValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardMaxYearValue());
        formDate.verifyApprovedOperationNotification();
    }


    // Negative tests
    // Not Valid Number Tests

    @Test
    void shouldBeRequiredToFilAfterWithoutCardNumberCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutCardNumber());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter15DigitCardNumberCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard15DigitCardNumber());
        formDate.verifyWrongFormatNotification();
    }

    // Not Valid Month Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutMonthValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutMonthValue());
        formDate.verifyRequiredToFillNotification();
    }


    @Test
    void shouldBeWrongFormatNotificationAfter1DigitMonthValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1DigitMonthValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterOver12MonthValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardOver12MonthValue());
        formDate.verifyWrongExpiredCardNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfter00MonthValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard00MonthValue());
        formDate.verifyWrongFormatNotification();
    }

    // Not Valid Year Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterWithoutYearValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutYearValue());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitYearValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1DigitYearValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardLessCurrentYearValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardLessCurrentYearValue());
        formDate.verifyExpiredCardNotification();
    }

    @Test
    void shouldBeExpiredCardNotificationAfterCardCurrentYearPlus6ValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardCurrentYearPlus6Value());
        formDate.verifyWrongExpiredCardNotification();
    }


    @Test
    void shouldBeExpiredCardNotificationAfterCard00MYearValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard00MYearValue());
        formDate.verifyExpiredCardNotification();
    }

    // Not Valid Holder Tests

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutHolderValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutHolderValue());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1WordHolderValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1WordHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardCyrillicHolderValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardCyrillicHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardDigitsHolderValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardDigitsHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCardSymbolsHolderValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardSymbolsHolderValue());
        formDate.verifyWrongFormatNotification();
    }

    // Not Valid Holder CVV

    @Test
    void shouldBeRequiredToFilNotificationAfterCardWithoutCvvValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCardWithoutCvvValue());
        formDate.verifyRequiredToFillNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard1DigitCvvValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard1DigitCvvValue());
        formDate.verifyWrongFormatNotification();
    }

    @Test
    void shouldBeWrongFormatNotificationAfterCard2DigitCvvValueCredit() {
        PaymentType paymentType = new PaymentType();
        paymentType.goToBuyTour();
        formDate.inputData(DataHelper.getCard2DigitCvvValue());
        formDate.verifyWrongFormatNotification();
    }

}