
import java.util.*;

public class Hand {
	
	private ArrayList<Card> hand;
	CardGenerator cardGen = new CardGenerator();
	private int handSize;
	
	public Hand(int handSize) {
		this.handSize = handSize;
		hand = new ArrayList<Card>(handSize);
		for (int i = 0; i < handSize; i++) {
			hand.add(new Card(cardGen.newRegularCard()));
		}
	}

	public void newHand() {
		hand = new ArrayList<Card>(handSize);
		for (int i = 0; i < handSize; i++) {
			hand.add(new Card(cardGen.newRegularCard()));
		}
		
		Collections.sort(hand);
	}
	
	public ArrayList<Card> getCardInHand() {
		return hand;
	}
	
	public String toString() {
		String str = hand.get(0).toString();
		for (int i = 1; i < hand.size(); i++) {
			str.concat(hand.get(i).toString());
			str.concat(", ");
		}
		return str;
	}
}
