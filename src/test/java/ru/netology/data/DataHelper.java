package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {

    public static String getdMonth(int shift){
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getYear (int yearCount){
        return LocalDate.now().plusYears(yearCount).format(DateTimeFormatter.ofPattern("YY"));
    }


    public static Card getApprovedCard() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getdMonth(12);
        String year = getYear(1);
        String cvv = faker.number().digits(3);
        String number = faker.number().digits(15);
        return new Card("4444444444444441", "12", "22", "Ivan Ivanov", "123");
    }
}
