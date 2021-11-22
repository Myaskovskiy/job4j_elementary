package ru.job4j.streamapi;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    private static Suit suit;
    private static Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "card{"
                + "suit='" + suit + '\''
                + ", value=" + value
                + '}';
    }

    public class CardString {
         String suit;
         String value;

        public CardString(String suit, String value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return "CardString{" + "suit='"
                    + suit + '\'' + ", value='"
                    + value + '\'' + '}';
        }
    }

    public Set<Card> sort() {
       return  Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> new Card(su, val)))
                 .collect(Collectors.toSet());
    }

    public Set<CardString> sortNew() {
        return  Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> new CardString(su.toString(), val.toString())))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Card card = new Card(suit, value);
        Set<Card> set = card.sort();
        Set<CardString> set1 = card.sortNew();
        System.out.println(set);
        System.out.println(set1);
    }
}
