
import java.util.*;

public class Player extends BaseGame {

	private Hand hand;
	private String name;
	private int index = 0;

	public Player(String name, Hand hand, int index) {
		super(index);
		this.hand = hand;
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public Card getCard() {
		return hand.getCardInHand().get(index);
	}

	public String getName() {
		// System.out.println(name);
		return name;
	}

	public void newHand() {
		hand.newHand();
	}

	public Card getCard(int i) {
		return hand.getCardInHand().get(i);
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> checkPlayableCardinHand(Card previousPlay) {
		ArrayList<Card> playableCards = new ArrayList<Card>();
		ArrayList<Card> currentCardsInHand = hand.getCardInHand();

		for (int i = 0; i < currentCardsInHand.size(); i++) {
			Card tempCard = currentCardsInHand.get(i);

			if (tempCard.matchColor(previousPlay)
					|| tempCard.matchNumber(previousPlay)) {
				playableCards.add(tempCard);
			}
		}

		if (playableCards.size() == 0) {
			drawCardFromDeck();
			checkPlayableCardinHand(previousPlay);
		}
		return playableCards;
	}

	public Card playCardInHand(
			Card previousPlay/* ArrayList<Card> playableCards */) {

		ArrayList<Card> playableCards = checkPlayableCardinHand(previousPlay);

		Card temp = null;
		int index;
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Previosly Played Card is: " + previousPlay.toString() + "\n");
		if (playableCards.size() != 0) {
			System.out.println(
					"This is your hand, and the playable Cards are listed below: ");
			System.out.println(this.toString());

			System.out.print("\n");
			for (int i = 0; i < playableCards.size(); i++) {
				System.out.print(playableCards.get(i).toString());
			}

			System.out.println("Please pick a card to play.");
			index = sc.nextInt() - 1;

			if (index < playableCards.size() && index >= 0) {
				temp = playableCards.get(index);
				playableCards.clear();
				hand.getCardInHand().remove(temp);
			}
			return temp;

		} else {
			System.out.println("This is your hand: ");
			System.out.println(this.toString());
			System.out.println("You don't have any cards to play.");
			// Card nullCard = new Card("Purple0");
			// temp = nullCard;
			drawCardFromDeck();
			return temp;
		}

	}

	public void drawCardFromDeck() {
		ArrayList<Card> cardsInHand = hand.getCardInHand();
		System.out.println("You are now drawing cards from the deck: ");
		while (playCardInHand(previousPlay) != null) {
			Card temp = getDeck().drawCard();
			System.out.println("You drew: " + temp.toString());

			cardsInHand.add(temp);
			hand.setCardInHand(cardsInHand);
		}

	}

	public String toString() {
		String str = name + "\n";

		// for (int i = 0; i < hand.getCardInHand().size() - 2; i++) {
		// str.concat(hand.toString()).concat(", ");
		// }
		// str.concat(hand.getCardInHand().get(hand.getCardInHand().size() -
		// 1).toString());
		// str.concat(". ");

		str = str.concat(hand.toString());

		return str;
	}
}
