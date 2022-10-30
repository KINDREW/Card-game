package cards;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Kindrew
 * Tests for the card class
 */

public class CardsTest {


    @Test
    public void setInitialTotalCardsTest(){
        Deck CardDeck=new Deck();
        CardDeck.createDeck();
        int actual = CardDeck.getDeckSize();
        int expected =52;

        assertEquals(expected,actual);
    }

    @Test
    public void ShuffleCardsTest(){
        Deck CardDeck= new Deck();
        CardDeck.createDeck();
        CardDeck.shuffleDeck();
        assertEquals(51,CardDeck.getDeckSize());
    }


}