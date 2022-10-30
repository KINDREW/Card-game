package player;

import cards.Card;
import cards.CardDetail;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {


    @Test
    public void setMyDetails() {
        Player player = new Player("News", 1);
        Card card1 = mock(Card.class);
        CardDetail detailsCard = mock(CardDetail.class);
        card1.setCardDetail(detailsCard);

        when(detailsCard.getCardValue()).thenReturn(3);
        player.setMyCards(card1);
        player.setMyDetails();
        assertEquals(Status.HIT,player.getPlayStatus());
    }
}