package ru.job4j.streamapi;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card() {
    }

    @Override
    public String toString() {
        return "card{"
                + "suit='" + suit + '\''
                + ", value=" + value
                + '}';
    }

    public Set<Card> sort() {
       return  Stream.of(Suit.values())
                .flatMap(su -> Stream.of(Value.values())
                        .map(val -> new Card(su, val)))
                 .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Card card = new Card();
        Set<Card> set = card.sort();
        System.out.println(set);
    }
}
