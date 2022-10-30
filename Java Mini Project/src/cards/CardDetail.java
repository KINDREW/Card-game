package cards;

/**
 * @author Kindrew
 * @version 1.01
 *
 * enum for cards and their associated values
 */
public enum CardDetail {
    TWO(2),THREE(3),FOUR(4),FIVE(5),
    SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),
    JACK(10),QUEEN(10),KING(10),ACE(11);

    private int cardValue;

    /**
     *
     * @param cardValue
     */
    CardDetail(int cardValue){
        this.cardValue= cardValue;
    }

    /**
     *
     * @return int cardvalue
     */
    public int getCardValue() {
        return cardValue;
    }

    /**
     *
     * @param cardValue
     */
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

}
