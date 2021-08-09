
import java.util.*;

public class UnoTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many players are there? (Max: 8; Min 3)");
		int numPlayers = sc.nextInt();

		BaseGame game = new BaseGame(numPlayers);

		// CardGenerator game = new CardGenerator();
		// game.newCardConcat();
		//
		// UnusedDeck deck = new UnusedDeck();
		// deck.newDeck(50, 3);
		//
		// int size = deck.getCards().size();
		//
		// for (int i = 0; i < size; i++) {
		// System.out.println(deck.getCards().get(i));
		// }

		for (Integer i = 1; i <= numPlayers; i++) {
			Player Alpha = new Player(i.toString(), new Hand(10), i);
			String name = "Player ".concat(i.toString());

			System.out.println(name + ", do you wish to set a name? (Y/N)");
			String nameChoice = sc.next();
			String user;
			if (nameChoice.equals("Y")) {
				System.out.println("Please enter a name:");
				sc.nextLine();
				user = sc.nextLine();
			} else {
				user = "No name.";
			}

			name = name.concat(": ").concat(user);
			Alpha.setName(name);

			game.addPlayer(Alpha);

			Alpha.getName();
			ArrayList<Card> testCardInHand = Alpha.getHand().getCardInHand();
			System.out.print("\n" + Alpha.toString());

			System.out.println("\n");
		}

		// game.getPlayer();
		game.playGame(1, 10, 0);

	}
}
