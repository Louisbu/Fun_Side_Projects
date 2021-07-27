
import java.util.*;

public class CardGenerator {

	int playerCount;
	ArrayList<String> colors;
	ArrayList<Integer> values;

	public CardGenerator() {

		colors = new ArrayList<String>(4);
		colors.add("Yellow");
		colors.add("Green");
		colors.add("Red");
		colors.add("Blue");
		Collections.sort(colors);

		values = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			values.add(i);
		}

	}

	public void newGame() {

	}

	public ArrayList<String> getColors() {
		return colors;
	}

	public ArrayList<Integer> getNumbers() {
		return values;
	}

	public String getRandomColor() {
		Random rand = new Random();
		return colors.get(rand.nextInt(4));
	}

	public Integer getRandomValue() {
		Random rand = new Random();
		return values.get(rand.nextInt(9));
	}
	
	public String newRegularCard() {
		String card = getRandomColor().concat(Integer.toString(getRandomValue()));
		//System.out.println(card);
		return card;
	}
	
	public String newSpecialCard() {
		//String card = 
		return null;
	}

}
