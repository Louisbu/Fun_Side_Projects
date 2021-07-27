import java.util.ArrayList;

//import java.util.*;

public class Card implements Comparable<Card> {
	protected String card;
	protected String color;
	protected int value;
	CardGenerator cardGen = new CardGenerator();

	public Card(String card) {
		this.card = card;
	}

	public String getCard() {
		return card;
	}

	public String getColor() {
		String[] tempArr = card.split(Character.toString(card.charAt(card.length()-1)));
		String temp = tempArr[0];
		for (int i = 1; i < tempArr.length; i++) {
			temp.concat(tempArr[i]);
		}
		return temp;
	}

	public Integer getNumber() {
		return Integer.parseInt(Character.toString(card.charAt(card.length()-1)));
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
	
	public String toString() {
		return card.concat("; ");
	}

	public int compareNumber(Card card) {
		ArrayList<Integer> numbers = cardGen.getNumbers();
		
		int thisCardNum = numbers.indexOf(this.getNumber());
		int otherCardNum = numbers.indexOf(card.getNumber());
		
		if (thisCardNum < otherCardNum) {
			return 1;
		} else if (thisCardNum == otherCardNum) {
			return 0;
		} else {
			return -1;
		}
	}
	
	public int compareColor(Card card) {
		ArrayList<String> colors = cardGen.getColors();
		//ArrayList<Integer> numbers = cardGen.getNumbers();
		
		int thisCardColor = colors.indexOf(this.getColor());
		int otherCardColor = colors.indexOf(card.getColor());
		
		if (thisCardColor < otherCardColor) {
			return 1;
		} else if (thisCardColor == otherCardColor) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public int compareTo(Card o) {
		
		return 0;
	}
	
	
}
