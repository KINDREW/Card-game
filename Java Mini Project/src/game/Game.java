package game;

import cards.Card;
import cards.Deck;
import player.Player;
import player.Status;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {

    //For creating of the players for the game
    private int totalPlayers;
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();

    public Game(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }
    public Game() {
        this.totalPlayers = 3;
    }



    public Status checkPlayerStatus(Player player){
        return player.getPlayStatus();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public List<Player> getAllPlayers(){
        return this.players;
    }
    public int getTotalNumberOfPlayers(){
        return players.size();
    }

    public List<Card> getCreatedDeck(){
        this.deck.createDeck();

        return deck.shuffleDeck();

    }
    public void giveCardsToPlayers(){
        for(int i =0; i< this.getTotalNumberOfPlayers(); i++){
            Player player = this.players.get(i);
            Status playerStatus = player.getPlayStatus();
            switch (playerStatus){
                case BEGIN:
                    player.setMyCards(this.deck.getCardDeck().remove(0));
                    player.setMyCards(this.deck.getCardDeck().remove(0));
                    break;
                case HIT:
                    player.setMyCards(this.deck.getCardDeck().remove(0));
                    break;
                case STICK:
                    System.out.println(player.getName()+" you stick, so you can not pick a card");
                    break;
                case GOBUST:
                    System.out.println(player.getName()+" went Bust and out of the game now");
                    players.remove(player);
            }
        }

    }
    //Checking Each player's total and changing their status in order for the game to continue.
    public void checkPlayersTotalCardValueAssigned(){
        for(int i =0; i< this.getTotalNumberOfPlayers(); i++){
            Player player = this.players.get(i);
            player.setMyDetails();
            System.out.println(player.getName()+" : "+player.getMyCards().toString()+"="+player.getTotalPoints()+" : "+ player.getPlayStatus());
        }
    }
    public void checkForAWinner(){
        boolean allMatch = players.stream()
                .allMatch(player -> player.getPlayStatus()==Status.STICK);

        int firstPlayerPoints = players.get(0).getTotalPoints();
        if(allMatch){
            System.out.println("All players are Stick! ");
            boolean sameTotalPoints = players.stream().allMatch(player -> player.getTotalPoints()==firstPlayerPoints);
            if(sameTotalPoints) {
                System.out.println("All players won with the same total points............");
            }
            else{
                Player maxPlayer = players.stream().max(Comparator.comparing(Player::getTotalPoints)).get();
                System.out.println(maxPlayer.getName()+" won with: "+maxPlayer.getTotalPoints());
            }
            this.players.clear();
        }
        else{
            for(int i =0; i< this.getTotalNumberOfPlayers(); i++){
                Player player = this.players.get(i);
                if(this.getTotalNumberOfPlayers()==1){
                    System.out.println("Only one player left.. So you won");
                    System.out.println("Player "+player.getID()+" Won!!!");
                    this.players.remove(player);
                }
                else if(player.getTotalPoints()==21){
                    System.out.println("Player "+player.getID()+" had 21 so you won!!!");
                    this.players.clear();
                }
            }
        }


    }

}
