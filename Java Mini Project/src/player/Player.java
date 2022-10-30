package player;

import cards.Card;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kindrew
 * @version 1.0
 *
 * Player class with players details
 */

public class Player {
    private String name;
    private int ID;

    public String getName() {
        return name;
    }

    private int totalPoints;
    private Status playStatus;
    // Card to be added from the creation of the Game class
    private Set <Card> myCards = new HashSet<>();

    public Player(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.playStatus = Status.BEGIN;
    }
    //When player want to be anonymous
    public Player (){
    }


    public int getID() {
        return ID;
    }


    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints +=totalPoints;
    }

    public Status getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(Status playStatus) {
        this.playStatus = playStatus;
    }

    public Set<Card> getMyCards() {
        return myCards;
    }

    public void setMyCards(Card myCards) {
        this.myCards.add(myCards);
    }

    public void setMyDetails(){
        this.totalPoints=0;
        for(Card card: this.myCards){
            this.setTotalPoints(card.getCardDetail().getCardValue());
        }
        if(this.getTotalPoints()<17){
            this.setPlayStatus(Status.HIT);
        } else if ((this.getTotalPoints()>=17)&&(this.getTotalPoints()<21)) {
            this.setPlayStatus(Status.STICK);
        }
        else if (this.getTotalPoints()==21){
            this.setPlayStatus(Status.WINNER);
        }
        else if(this.getTotalPoints()>21){
            this.setPlayStatus(Status.GOBUST);
        }
    }
}
