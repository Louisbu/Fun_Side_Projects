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
	
	public void initiateNewGame(int regCardNum, int SpecialNum) {
		deck = new Deck(regCardNum, SpecialNum);
	}
	
	public void playClockwise() {
		
	}
	
	public void playCounterClockwise() {
		
	}
	
	public void playGame(int playSequence) {
		if (playSequence >= 0) {
			playClockwise();
		} else {
			playCounterClockwise();
		}
	}

}
