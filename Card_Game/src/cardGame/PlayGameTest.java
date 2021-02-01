/**
 * 
 */
package cardGame;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author rahulsonawane
 *
 */


class PlayGameTest {

	/**
	 * @throws java.lang.Exception
	 */
	

	static PlayGame newGame = new PlayGame();

	/**
	 * Test method for A new deck should contain 40 cards.
	 */
	@Test
	final void testCardDeck() {
		int checkDeckSize = newGame.cardDeck().size();
		assertEquals(checkDeckSize, 40);

	}

	/**
	 * Test method for A shuffle function should shuffle a deck.
	 */
	@Test
	final void testShuffledDeck() {
		ArrayList<Integer> deck = newGame.cardDeck();
		ArrayList<Integer> shuffledDeck = newGame.shuffledDeck(deck);

		assertNotSame(shuffledDeck.toArray(), deck.toArray());	
	}

	/**
	 * Test method for If a player with an empty draw pile tries to draw a card, the discard pile is shuffled into the draw pile.
	 */
	@Test
	 final void testDrawCard() {
		
		ArrayList<Integer> drawPilePlayer = new ArrayList<Integer>();
		ArrayList<Integer> discardPilePlayer = new ArrayList<Integer>();
		for (int i = 1; i <= 2; ++i) {
			discardPilePlayer.add(i);
			discardPilePlayer.add(i);
			discardPilePlayer.add(i);
			discardPilePlayer.add(i);
		}
		
		drawPilePlayer = newGame.shuffledDeck(discardPilePlayer);
		
		assertFalse(drawPilePlayer.isEmpty());

	}

	/**
	 * Test method for When comparing two cards, the higher card should win.
	 * Here we call ifPlayer1CardIsHigh method which returns result array and print the winner.
	 */
	@Test
	final void testComparingTwoCards() {
		
		ArrayList<Integer> Player_1_Card = new ArrayList<Integer>();
		ArrayList<Integer> Player_2_Card = new ArrayList<Integer>();

		Player_1_Card.add(5);
		Player_2_Card.add(4);
		Player_1_Card.add(5);
		Player_2_Card.add(4);
		

		
		
		Object[] gameResult = newGame.ifPlayer1CardIsHigh(Player_1_Card, Player_2_Card);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultPlayer1 = (ArrayList<Integer>) gameResult[0];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultPlayer2 = (ArrayList<Integer>) gameResult[1];
		

		int player1_Card = gameResultPlayer1.get(gameResultPlayer1.size() - 1);
		int player2_Card = gameResultPlayer2.get(gameResultPlayer2.size() - 1);
		

		  int high = player1_Card;
		  int low = player2_Card;
		  
		 assertTrue(" player1 Card is high", high >= low);	

	}

	
	
	/**
	 * Test method for When comparing two cards of the same value, 
	 * the winner of the next round should win 4 cards method which returns result array and print the result.
	*/
	@Test
	final void testIfTwoCardsSame() {
	
	ArrayList<Integer> Player_1_Card = new ArrayList<Integer>();
		ArrayList<Integer> Player_2_Card = new ArrayList<Integer>();

		Player_1_Card.add(5);
		Player_1_Card.add(5);
		Player_2_Card.add(5);
		Player_2_Card.add(4);
		
		Object[] gameResult = newGame.ifTwoCardsSame(Player_1_Card, Player_2_Card);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultPlayer1 = (ArrayList<Integer>) gameResult[0];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultPlayer2 = (ArrayList<Integer>) gameResult[1];

		
		int player1_Card = gameResultPlayer1.get(gameResultPlayer1.size() - 1);
		int player2_Card = gameResultPlayer2.get(gameResultPlayer2.size() - 1);

		  int high = player1_Card;
		  int low = player2_Card;
		  
		 assertTrue(" player1 Card is high", high == low);
		
	



		
		
	} 

}
