import java.util.*;

public class Player {
    private ArrayList<Card> hand;
    private String name;
    private int index = 0;

    public Player(String name, ArrayList<Card> hand) {
        this.hand = hand;
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Card getCard() {
        return hand.get(index);
    }
}
