package com.company;

import java.awt.*;
import java.util.ArrayList;

public class PitchDealer implements Dealer {
    Deck deck = new Deck();
    // Shuffle the cards


    public void resetDeck() {
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    void shufle() {
        for(int i = 0; i<deck.cards.size();i++) {
            int j = (int) (Math.random() * deck.cards.size());
                Card index = deck.cards.get(j);
                Card temp = deck.cards.get(i);
                deck.cards.set(i,index);
                deck.cards.set(j,temp);

        }
}

    @Override
    public ArrayList<Card> dealHand() {
        //Make sure to delete the cards after you deal them until the game restarts
        Player player1 = new Player();
        int counter =6;
        for(Card card : deck.cards){
           if(card.isCardOut() == false) {
                player1.hand.add(card);
                card.setCardOut(true);
                counter--;
                if (counter == 0) {
                    break;
                }
           }
        }
        return player1.hand;
    }
}
