package ru.job4j.streamapi;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    private static Suit suit;
    private static Value value;
    Set<CardString> cards = new HashSet<>();

    static class CardString {
        String suit;
        String value;

        public CardString(String suit, String value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return "CardString{"
                    + "suit='"
                    + suit
                    + '\''
                    + ", value='"
                    + value
                    + '\''
                    + '}';
        }
    }

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public void sort() {
        Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> su + " " + val))
                .forEach(System.out::println);

        this.cards = Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> new CardString(su.toString(), val.toString())))
                .collect(Collectors.toSet());

        cards.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {

        Card card = new Card(suit, value);
        card.sort();

    }
}
