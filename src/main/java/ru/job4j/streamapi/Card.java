package ru.job4j.streamapi;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    private static Suit suit;
    private static Value value;
    private static Set<Card> cards = new HashSet<>();

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public void sort() {
         this.cards = Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> new Card(su, val)))
                 .collect(Collectors.toSet());
    }

    public static void main(String[] args) {

        Card card = new Card(suit, value);
        card.sort();

    }
}
