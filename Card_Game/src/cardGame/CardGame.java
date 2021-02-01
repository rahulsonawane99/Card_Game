package cardGame;

import java.util.ArrayList;

public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlayGame pg = new PlayGame();

		ArrayList<Integer> deck = pg.cardDeck();
		
		System.out.println(" ");
		System.out.println("New deck " +deck);


		ArrayList<Integer> shuffledDeck = pg.shuffledDeck(deck);
		System.out.println(" ");
		System.out.println("Shuffled deck " +shuffledDeck);


		Object[] drawPilesOfPlayers = pg.drawCard(shuffledDeck);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> drawPilePlayer1 = (ArrayList<Integer>) drawPilesOfPlayers[0];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> drawPilePlayer2 = (ArrayList<Integer>) drawPilesOfPlayers[1];
		
		System.out.println(" ");
		System.out.println("Draw Pile Player 1 " + drawPilePlayer1);
		System.out.println(" ");
		System.out.println("Draw Pile Player 2 " + drawPilePlayer2);
		
		
		


		
		Object[] gameResult = pg.comparingTwoCards(drawPilePlayer1, drawPilePlayer2);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultPlayer1 = (ArrayList<Integer>) gameResult[0];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultPlayer2 = (ArrayList<Integer>) gameResult[1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> gameResultSameCrad = (ArrayList<Integer>) gameResult[2];
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Game Result Player 1 " + gameResultPlayer1);
		System.out.println("Game Result Player 2 " + gameResultPlayer2);

		if (gameResultPlayer1.size() > gameResultPlayer2.size()) {
			System.out.println(" ");

			System.out.println("Player 1 wins the game with "+gameResultPlayer1.size()+" cards!");

		} else if (gameResultPlayer1.size() < gameResultPlayer2.size()) {
			System.out.println(" ");

			System.out.println("Player 2 wins the game with "+gameResultPlayer2.size()+" cards!");

		} else {
			System.out.println(" ");

			System.out.println("Game Draw");
		}
		
		if(gameResultSameCrad.size() != 0){
			System.out.println(" ");

			System.out.println("Remaining Same Card Pile as losing player doesnt have any card for the next round." +gameResultSameCrad);

		}

	}

}
