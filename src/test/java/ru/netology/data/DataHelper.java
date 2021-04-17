package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;

public class DataHelper {

    private static final String APPROVED_CARD_NUMBER = "4444444444444441";
    private static final String DECLINED_CARD_NUMBER = "4444444444444442";
    private static final String URL = "http://localhost:8080/";

    public static void openURL () {
        open(URL);
    }

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



    public static Card getApprovedCard() {
        Faker faker = new Faker(new Locale("ru"));
        String card = APPROVED_CARD_NUMBER;
        String month = getMonth();
        String year = getYear();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String holderRu = transliterate(holder);
        String cvv = faker.number().digits(3);
        return new Card(card, month, year, holderRu, cvv);
    }

    public static Card getDeclinedCard() {
        Faker faker = new Faker(new Locale("ru"));
        String card = DECLINED_CARD_NUMBER;
        String month = getMonth();
        String year = getYear();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String holderRu = transliterate(holder);
        String cvv = faker.number().digits(3);
        return new Card(card, month, year, holderRu, cvv);
    }



}
