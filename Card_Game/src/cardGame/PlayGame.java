package cardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayGame {

	static ArrayList<Integer> deck = new ArrayList<Integer>();
	static ArrayList<Integer> drawPilePlayer1 = new ArrayList<Integer>();
	static ArrayList<Integer> drawPilePlayer2 = new ArrayList<Integer>();
	static ArrayList<Integer> discardPilePlayer1 = new ArrayList<Integer>();
	static ArrayList<Integer> discardPilePlayer2 = new ArrayList<Integer>();
	static ArrayList<Integer> sameCardPile = new ArrayList<Integer>();
	static int player1TopCard;
	static int player2TopCard;
	static int removePlayer1TopCard;
	static int removePlayer2TopCard;
	static int player1Count = 0;
	static int player2Count = 0;
	static int round = 1;

	public ArrayList<Integer> cardDeck() {
		// Create array list for new deck
		for (int i = 1; i <= 10; ++i) {
			deck.add(i);
			deck.add(i);
			deck.add(i);
			deck.add(i);
		}
		return deck;
	}

	public static ArrayList<Integer> shuffledDeck(ArrayList<Integer> deck) {
		Random random = new Random();
		for (int i = deck.size() - 1; i >= 1; i--) {
			// get a random index j such that 0 <= j <= i
			int j = random.nextInt(i + 1);
			// swap element at i'th position in the list with element at
			// randomly generated index j
			Integer obj = (Integer) deck.get(i);
			deck.set(i, deck.get(j));
			deck.set(j, obj);
		}
		return deck;
	}

	public Object[] drawCard(List<Integer> shuffledDeck) {
		if (drawPilePlayer1.size() == 0 && drawPilePlayer2.size() == 0) {
			for (int i = 0; i < shuffledDeck.size(); i++) {
				if (i % 2 == 0) {
					drawPilePlayer1.add((Integer) shuffledDeck.get(i));
				} else {
					drawPilePlayer2.add((Integer) shuffledDeck.get(i));
				}
			}
		}
		return new Object[] { drawPilePlayer1, drawPilePlayer2 };
	}

	public static Object[] comparingTwoCards(ArrayList<Integer> drawPilePlayer1, ArrayList<Integer> drawPilePlayer2) {
		do {
			System.out.println("  ");
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Round " + round + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("  ");
			player1TopCard = drawPilePlayer1.get(drawPilePlayer1.size() - 1);
			player2TopCard = drawPilePlayer2.get(drawPilePlayer2.size() - 1);
			System.out.println("Player 1 (" + drawPilePlayer1.size()+")" + player1TopCard);
			System.out.println("Player 2 (" + drawPilePlayer2.size()+")" + player2TopCard);

			if (player1TopCard > player2TopCard) {
				ifPlayer1CardIsHigh(drawPilePlayer1, drawPilePlayer2);

			} else if (player1TopCard < player2TopCard) {
				ifPlayer2CardIsHigh(drawPilePlayer1, drawPilePlayer2);

			} else if (player1TopCard == player2TopCard) {
				ifTwoCardsSame(drawPilePlayer1, drawPilePlayer2);
			}

			if ((drawPilePlayer1.size() == 0) && (discardPilePlayer1.size() != 0)) {
				drawPilePlayer1 = shuffledDeck(discardPilePlayer1);
			}

			if ((drawPilePlayer2.size() == 0) && (discardPilePlayer2.size() != 0)) {
				drawPilePlayer2 = shuffledDeck(discardPilePlayer2);
			}

		} while ((drawPilePlayer1.size() != 0) && (drawPilePlayer2.size() != 0));
		return new Object[] { drawPilePlayer1, drawPilePlayer2, sameCardPile };

	}

	public static Object[] ifPlayer1CardIsHigh(ArrayList<Integer> drawPilePlayer1, ArrayList<Integer> drawPilePlayer2) {
		if (sameCardPile.size() > 0) {
			int sameCardSize = sameCardPile.size();
			for (int i = 0; i <= sameCardSize - 1; i++) {
				int same = sameCardPile.get(i);
				discardPilePlayer1.add(0, same);
			}
			sameCardPile.removeAll(sameCardPile);
		}
		discardPilePlayer1.add(0, player1TopCard);
		removePlayer1TopCard = drawPilePlayer1.size() - 1;
		drawPilePlayer1.remove(removePlayer1TopCard);
		discardPilePlayer1.add(0, player2TopCard);
		removePlayer2TopCard = drawPilePlayer2.size() - 1;
		drawPilePlayer2.remove(removePlayer2TopCard);
		round++;
		System.out.println("  ");
		System.out.println("Player 1 wins this round");
		return new Object[] { drawPilePlayer1, drawPilePlayer2 };

	}

	public static void ifPlayer2CardIsHigh(ArrayList<Integer> drawPilePlayer1, ArrayList<Integer> drawPilePlayer2) {
		if (sameCardPile.size() > 0) {
			int sameCardSize = sameCardPile.size();
			for (int i = 0; i <= sameCardSize - 1; i++) {
				int same = sameCardPile.get(i);
				discardPilePlayer2.add(0, same);
			}
			sameCardPile.removeAll(sameCardPile);
		}
		discardPilePlayer2.add(0, player2TopCard);
		removePlayer2TopCard = drawPilePlayer2.size() - 1;
		drawPilePlayer2.remove(removePlayer2TopCard);
		discardPilePlayer2.add(0, player1TopCard);
		removePlayer1TopCard = drawPilePlayer1.size() - 1;
		drawPilePlayer1.remove(removePlayer1TopCard);
		round++;
		System.out.println("  ");
		System.out.println("Player 2 wins this round");
	}

	public static Object[] ifTwoCardsSame(ArrayList<Integer> drawPilePlayer1, ArrayList<Integer> drawPilePlayer2) {
		// TODO Auto-generated method stub
		player1TopCard = drawPilePlayer1.get(drawPilePlayer1.size() - 1);
		player2TopCard = drawPilePlayer2.get(drawPilePlayer2.size() - 1);
		sameCardPile.add(player1TopCard);
		sameCardPile.add(player2TopCard);
		if (drawPilePlayer1.size() > 0) {
			int removePlayer1TopCard = drawPilePlayer1.size() - 1;
			drawPilePlayer1.remove(removePlayer1TopCard);
		}
		if (drawPilePlayer2.size() > 0) {
			int removePlayer2TopCard = drawPilePlayer2.size() - 1;
			drawPilePlayer2.remove(removePlayer2TopCard);
		}
		round++;
		System.out.println("  ");
		System.out.println("No winner in this round");
		return new Object[] { drawPilePlayer1, drawPilePlayer2 };

	}

}
