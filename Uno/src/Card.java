//import java.util.*;

public class Card {
	protected String card;
	protected String color;
	protected String number;
	

	public Card(String card) {
		this.card = card;
	}
	
	public String getCard() {
		return card;
	}
	
	public String getColor() {
		return Character.toString(card.charAt(0));
	}
	
	public Integer getNumber() {
		return Integer.parseInt(Character.toString(card.charAt(1)));
	}

	public Boolean matchColor(Card card1) {
		if (this.getColor().equals(card1.getColor())) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean matchNumber(Card card1) {
		if (this.getNumber() == card1.getNumber()) {
			return true;
		} else {
			return false;
		}
	}
}
