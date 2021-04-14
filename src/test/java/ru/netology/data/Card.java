package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String cardNumber;
    private String cardMonth;
    private String cardYear;
    private String cardHolder;
    private String cardCvv;
}
