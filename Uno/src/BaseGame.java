import java.util.*;

//This class contains the basic workings of this game, the following are basic game rules:

//The game first hands each player 8 cards, after each player has 8 cards, the top card on the list becomes the first card get played
//The direction always starts clockwise, however whoever plays first is by random order
//Each player get to play a card, this card must be the same color or the same number as the card on the top of the deck
//If the player has no card in hand that can be played, the player would keep drawing from the deck till he can play again while keeping all the cards drawn
//
public class BaseGame {

	private int index;
	protected int playerCount;
	protected Deck deck;
	protected Card previousPlay;

	protected ArrayList<Player> players;

	public BaseGame(int playerCount) {
		players = new ArrayList<Player>(playerCount);
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public ArrayList<Player> getPlayer() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i) + " ");
		}

		return players;
	}

	public Deck getDeck() {
		return deck;
	}

	public Card initiateNewGame(int regCardNum, int SpecialNum) {
		deck = new Deck(regCardNum, SpecialNum);
		previousPlay = deck.getCards().get(0);

		return previousPlay;
	}

	public void playClockwise(int regCardNum, int SpecialNum) {
		initiateNewGame(regCardNum, SpecialNum);
		int loopSize = players.size();

		for (int i = 0; i < loopSize; i++) {
			Player currPlayer = players.get(i);
			if (currPlayer.getHand().getCardInHand().size() == 0) {
				System.out.println(currPlayer.toString() + ", wins the game.");
				break;
			}
			Card temp = currPlayer.playCardInHand(previousPlay);
			if (temp != null) {
				previousPlay = temp;
			} else {
				currPlayer.drawCardFromDeck();
			}

			if (i == loopSize - 1) {
				i = -1;
			}

		}

	}

	public void playCounterClockwise(int regCardNum, int SpecialNum) {
		initiateNewGame(regCardNum, SpecialNum);
		int loopSize = players.size();

		for (int i = loopSize - 1; i >= 0; i--) {
			Player currPlayer = players.get(i);
			Card temp = currPlayer.playCardInHand(previousPlay);
			if (temp != null) {
				previousPlay = temp;
			} else {
				currPlayer.drawCardFromDeck();
			}
			if (currPlayer.getHand().getCardInHand().size() == 0) {
				System.out.println(currPlayer.toString() + ", wins the game.");
				break;
			}

			if (i == 0) {
				i = loopSize;
			}

		}
	}

	public void playGame(int playSequence, int regCardNum, int SpecialNum) {
		if (playSequence >= 0) {
			playClockwise(regCardNum, SpecialNum);
		} else {
			playCounterClockwise(regCardNum, SpecialNum);
		}
	}

}
