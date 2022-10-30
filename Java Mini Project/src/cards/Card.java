package cards;

/**
 * @author Kindrew
 * @version 1.01
 * Card class creating a card with suit and associated value
 */

public class Card {
  CardDetail cardDetail;
  Suit suit;

    @Override
    public String toString() {
        return "Card{" +
                "value=" + cardDetail +
                ", suit=" + suit +
                '}';
    }

    /**
     *
     * @param suit
     * @param cardValue
     */
    public Card(Suit suit, CardDetail cardValue) {
        this.cardDetail = cardValue;
        this.suit = suit;
    }

    public void setCardDetail(CardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }

    /**
     *
     * @return  cardDetail
     */
    public CardDetail getCardDetail() {
        return cardDetail;
    }



}
