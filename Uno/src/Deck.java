
import java.util.*;

public class Deck {

	protected ArrayList<Card> deck;
	CardGenerator cardGen = new CardGenerator();

	public Deck(int size, int numSpecialCards) {
		deck = new ArrayList<Card>(size);
		CardGenerator cardGen = new CardGenerator();
		if (numSpecialCards == 0) {
			for (int i = 0; i < size; i++) {
				deck.add(new Card(cardGen.newRegularCard()));
			}
		} else {
			for (int i = 0; i < size - 4 * numSpecialCards; i++) {
				deck.add(new Card(cardGen.newRegularCard()));
			}

			for (int i = 0; i < numSpecialCards; i++) {
				deck.add(new ReverseCard("Reverse"));
			}

			for (int i = 0; i < numSpecialCards; i++) {
				deck.add(new Plus2Card("PlusTwo"));
			}

			for (int i = 0; i < numSpecialCards; i++) {
				deck.add(new Plus4Card("PlusFour"));
			}

			for (int i = 0; i < numSpecialCards; i++) {
				deck.add(new SkipCard("Skip"));
			}
		}

	}

	public ArrayList<Card> reshufle() {
		for (int i = 0; i < 3; i++) {
			Collections.shuffle(deck);
		}

		return deck;
	}

	public ArrayList<Card> getCards() {
		return deck;
	}

	public int getSizeOfDeck() {
		return deck.size();
	}

	public Card drawCard() {
		Card temp = deck.get(0);
		deck.remove(0);
		return temp;
	}

	public void cardRegen() {
		
		if (deck.size() < 20) {
			for (int i = 0; i < 50; i++) {
				deck.add(new Card(cardGen.newRegularCard()));
			}
//			for (int i = 0; i < 10; i++) {
//				deck.add(new Card(cardGen.newSpecialCard()));
//			}
		}
	}
}
