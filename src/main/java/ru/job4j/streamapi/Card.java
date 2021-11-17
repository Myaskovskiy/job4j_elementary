package ru.job4j.streamapi;

import java.util.stream.Stream;
public class Card {

    private static Suit suit;
    private static Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public void sort() {
        Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> su + " " + val))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Card card = new Card(suit, value);
        card.sort();
    }
}
