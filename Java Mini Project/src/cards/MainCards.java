package cards;

public class MainCards {
    public static void main(String[] args) {
        Deck CardDeck = new Deck();
        CardDeck.createDeck();

        System.out.println(CardDeck.getDeckSize());

        System.out.println(CardDeck.getCardDeck().toString());

       CardDeck.shuffleDeck();
        System.out.println(CardDeck.getCardDeck().toString());

        System.out.println(CardDeck.getDeckSize());


    }
}
