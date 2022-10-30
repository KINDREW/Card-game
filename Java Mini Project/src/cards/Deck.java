package cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kindrew
 * @version 1.01
 *
 * Deck class with all 52 cards initially
 */

public class Deck {
   private ArrayList<Card> cardDeck = new ArrayList<>();

    /**
     *
     * @return ArrayList of cards
     */
    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    /**
     *
     * @return int - number of available cards in the deck
     */
    public int getDeckSize(){
        return this.cardDeck.size();
    }

    /**
     * create a deck as a list of 52 card instances
     */
    public void createDeck(){

        final int suitSize = 4;
        final int valuesSize=13;

        for(int i=0;i<suitSize;i++){
            for(int j=0;j<valuesSize;j++){
                Card cardInstance = new Card(Suit.values()[i], CardDetail.values()[j]);
                cardDeck.add(cardInstance);
            }
        }
    }

    /**
     *
     * @return Card - randomly picked card from the deck
     */
    public ArrayList<Card> shuffleDeck(){
        if(getDeckSize()>0) {
            Collections.shuffle(cardDeck);
            return cardDeck;
        }
        else{
            System.out.println("No cards left the game should end!");
            return null;
        }

    }
}
