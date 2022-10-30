package game;

import org.junit.Test;
import player.Player;
import player.Status;

import static org.junit.Assert.*;

public class GameTest {
    Player player = new Player("Kindrew",1);
    Game game = new Game(4);
    @Test
    public void checkPlayerStatusTest() {

        assertEquals(Status.BEGIN,game.checkPlayerStatus(player));

    }
    @Test
    public void addPlayersToGameTest(){
        game.addPlayer(player);
        assertEquals(1,game.getAllPlayers().size());
    }
}