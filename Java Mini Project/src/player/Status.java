package player;

public enum Status {
    HIT(0), STICK(1), GOBUST(2), BEGIN(3),WINNER(4);

    private int statusNumber;
    Status(int statusNumber) {
        this.statusNumber = statusNumber;
    }
}
