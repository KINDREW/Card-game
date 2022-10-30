import exceptions.MultiplePlayerException;
import game.Game;
import player.Player;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws MultiplePlayerException {
        System.out.println("----------------------CREATING PLAYERS----------------");
        Game game = new Game();

        if((args.length >=7)){
            throw new  MultiplePlayerException("Can not have less than 1 or greater than 6 players for the game.");
        }
        else if((args.length>0) && (args.length<7)) {
            for (int i = 0; i < args.length; i++) {
                Player player = new Player(args[i], (i+1));
                game.addPlayer(player);
                System.out.println("Player " + player.getID() + ": " + player.getName());
            }
        }
        else {
            Player player1 = new Player("Kindrew",1);
            Player player2 = new Player("Kojo",2);
            Player player3 = new Player("Afful",3);
            game.addPlayer(player1);
            game.addPlayer(player2);
            game.addPlayer(player3);
        }
        System.out.println("----------------------BLACKJACK GAME STARTS----------------");
        System.out.println("We have: "+ game.getTotalNumberOfPlayers() + " Players At Start!" );
        System.out.println();

        game.getCreatedDeck();
        int countRound = 1;
        do{
            System.out.println("Total Number of players: "+ game.getTotalNumberOfPlayers());
            System.out.println("Round:"+countRound++);
            System.out.println("-------------Giving Cards to players--------------");
            game.giveCardsToPlayers();

            System.out.println("-----Players Checking Their Cards And Telling Me Their Status And Total Points Now----------------");
        game.checkPlayersTotalCardValueAssigned();
            System.out.println("After round "+(countRound-1)+", Checking Who Won......................");
        game.checkForAWinner();
        } while(game.getTotalNumberOfPlayers()>0);
}
}
