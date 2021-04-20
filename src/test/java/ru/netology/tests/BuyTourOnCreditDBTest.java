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
}
