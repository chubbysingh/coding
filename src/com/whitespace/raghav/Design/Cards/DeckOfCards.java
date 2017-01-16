package com.whitespace.raghav.Design.Cards;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 6/14/15.
 */
public class DeckOfCards {
    private final int NCARDS = 52;
    private final Card[] deckOfCards;

    private int currentCard = 0;

    public DeckOfCards() {
        deckOfCards = new Card[NCARDS];

        int i = 0;
        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                deckOfCards[i] = new Card(suit, rank);
                i++;
            }
         }
    }

    public void shuffle() {
        for (int i = 0 ; i < NCARDS ; i++) {
            int random = (int) (Math.random() * 52) ;

            Card temp;
            temp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[random];
            deckOfCards[random] = temp;
        }
    }

    public Card deal() {
        return deckOfCards[currentCard++];
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "deckOfCards=" + Arrays.toString(deckOfCards) +
                '}';
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle();

        System.out.println(deckOfCards);
    }
}

class Card {
    Suits suit;
    Ranks rank;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

enum Suits {HEART, DIAMOND, SPADE, CLUB} ;
enum Ranks {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

