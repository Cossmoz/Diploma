package ru.netology.data;

import com.github.javafaker.Faker;
import java.time.Year;
import java.util.Locale;

public class DataHelper {

    private static final String APPROVED_CARD_NUMBER = "4444444444444441";
    private static final String DECLINED_CARD_NUMBER = "4444444444444442";


    public static String getMonth() {
        int minMonth = 1;
        int maxMonth = 12;
        int randomMonth = minMonth + (int)(Math.random() * ((maxMonth  - minMonth) + 1));

        if (randomMonth < 10) {
            return ("0" + randomMonth);
        } else {
            return String.valueOf(randomMonth);
        }

    }

    public static String getYear() {
        int minYear =  Year.now().getValue() % 100;
        int maxYear = (Year.now().getValue() % 100) + 5;
        int randomYear = minYear + (int)(Math.random() * ((maxYear  - minYear) + 1));
            return String.valueOf(randomYear);
    }

    public static String transliterate(String message){
        char[] abcCyr =   {' ','а','б','в','г','д','е','ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш','щ','ъ','ы','ь','э', 'ю','я','А','Б','В','Г','Д','Е','Ё', 'Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч','Ш', 'Щ','Ъ','Ы','Ь','Э','Ю','Я','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String[] abcLat = {" ","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ja","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int x = 0; x < abcCyr.length; x++ ) {
                if (message.charAt(i) == abcCyr[x]) {
                    builder.append(abcLat[x]);
                }
            }
        }
        return builder.toString();
    }


    public static Card getEmptyCard() {
        return new Card("", "", "", "", "");
    }


// Valid Card Data

    public static Card getApprovedCard() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getDeclinedCard() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(DECLINED_CARD_NUMBER, month, year, holder, cvv);
    }

    // Not Valid Card Data
    // Not Valid Card Number

    public static Card getCardWithoutCardNumber() {
        Faker faker = new Faker(new Locale("ru"));
        String card = "";
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(card, month, year, holder, cvv);
    }

    public static Card getCard15DigitCardNumber() {
        Faker faker = new Faker(new Locale("ru"));
        String card = faker.number().digits(15);
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(card, month, year, holder, cvv);
    }

    // Not Valid Card Month

    public static Card getCardWithoutMonthValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = "";
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard1DigitMonthValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = faker.number().digit();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCardOver12MonthValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = "13";
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard00MonthValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = "00";
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    // Not Valid Card Year

    public static Card getCardWithoutYearValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = "";
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard1DigitYearValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = faker.number().digit();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCardLessCurrentYearValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = String.valueOf((Year.now().getValue() % 100) - 1);
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCardMaxYearValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = String.valueOf((Year.now().getValue() % 100) + 5);
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }



    public static Card getCardCurrentYearPlus6Value() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = String.valueOf((Year.now().getValue() % 100) + 6);
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard00MYearValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = "00";
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    // Not Valid Card Holder

    public static Card getCardWithoutHolderValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = "";
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard1WordHolderValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().lastName());
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCardCyrillicHolderValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }
    public static Card getCardDigitsHolderValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = (transliterate(faker.name().firstName())) + faker.number().digit();
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCardSymbolsHolderValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = (transliterate(faker.name().firstName())) + "@$#*&";
        String cvv = faker.number().digits(3);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    // Not Valid Card CVV

    public static Card getCardWithoutCvvValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = "";
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard1DigitCvvValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(1);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

    public static Card getCard2DigitCvvValue() {
        Faker faker = new Faker(new Locale("ru"));
        String month = getMonth();
        String year = getYear();
        String holder = transliterate(faker.name().firstName() + " " + faker.name().lastName());
        String cvv = faker.number().digits(2);
        return new Card(APPROVED_CARD_NUMBER, month, year, holder, cvv);
    }

}
