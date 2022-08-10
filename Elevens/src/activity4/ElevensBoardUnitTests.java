package activity4;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import testHelp.*;

public class ElevensBoardUnitTests
{
	String[] ranks = { "Jack", "Queen", "King", "Ace" };
	String[] suits = { "Hearts", "Clubs", "Spades" };
	int[] values = { 11, 12, 13, 1 };

	String[] ranks1 = { "Seven" };
	String[] suits1 = { "Hearts" };
	int[] values1 = { 7 };

	String[] ranks0 = {};
	String[] suits0 = {};
	int[] values0 = {};
	
	@Test
	public void BoardConstructorShouldNotThrow()
	{
		verify.that(() -> new ElevensBoard()).doesNotThrow();
	}

	@Test
	public void BoardShouldHoldNineCards()
	{
		IBoard board = new ElevensBoard();
		verify.that(board.getBoardSize()).isEqualTo(9);
	}

	@Test
	public void BoardShouldStartWithNineCards()
	{
		IBoard board = new ElevensBoard();
		verify.that(board.getCardIndices().size()).isEqualTo(9);
	}

	@Test
	public void NewGameShouldReplaceCards()
	{
		// Create a new ElevensBoard, use the getCards method
		// defined below to get all the cards on the board, create
		// a new game and do the same thing, then:
		// verify.that(firstGame).isNotEqualTo(secondGame);
		IBoard game = new ElevensBoard();
		game.newGame();
		ArrayList<Card> cards1 = new ArrayList<Card>(getCards(game));
		
		game.newGame();
		ArrayList<Card> cards2 = new ArrayList<Card>(getCards(game));
		verify.that(cards1).isNotEqualTo(cards2);
	}

	@Test
	public void DealShouldReplaceCardAtFirstIndex()
	{
		// Create a new ElevensBoard, get the card at position 0,
		// deal to position 0 on the board, verify that the new
		// card at position 0 is not equal to the original card at 0
		IBoard board = new ElevensBoard();
		Card card = board.getCard(0);
		board.deal(1);
		Card card2 = board.getCard(0);
		verify.that(card.equals(card2)).isFalse();
	}

	@Test
	public void DealShouldReplaceCardAtLastIndex()
	{
		// Same as above, but for position 8
		IBoard board = new ElevensBoard();
        Card card = board.getCard(8);
        board.deal(1);
        Card card2 = board.getCard(8);
        verify.that(card.equals(card2)).isFalse();
	}

	@Test
	public void GameIsWonIfDeckAndTableAreClear()
	{
		// Create an empty deck, create an ElevensBoard with this
		// deck, and verify that the game is won (since both the deck
		// and the board are empty)
		Deck deck = new Deck(ranks0, suits0, values0);
		IBoard board = new ElevensBoard(deck);
		verify.that(board.gameIsWon()).isTrue();
	}

	@Test
	public void GameIsNotOverIfDeckContainsCards()
	{
		IBoard board = new ElevensBoard();
		verify.that(board.gameIsWon()).isFalse();
	}

	@Test
	public void GameIsNotOverIfTableHasCards()
	{
		Deck d = new Deck(new String[] { "rank1", "rank2" }, new String[] { "suit1" }, new int[] { 1, 2 });
		IBoard board = new ElevensBoard(d); // will have 2 cards on table, none
											// left in deck
		verify.that(board.gameIsWon()).isFalse();
	}

	@Test
	public void TableSlotsAreEmptyWhenDeckRunsOut()
	{
		Deck d = new Deck(new String[] { "rank1", "rank2" }, new String[] { "suit1" }, new int[] { 1, 2 });
		IBoard board = new ElevensBoard(d);
		verify.that(board.getCardsLeftInDeck()).isEqualTo(0);

		// there should be just two card indices, 0 and 1
		verify.that(board.getCardIndices()).isEqualTo(Arrays.asList(new Integer[] { new Integer(0), new Integer(1) }));
	}

	private static ArrayList<Card> getCards(IBoard board)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		for (Integer i : board.getCardIndices())
			cards.add(board.getCard(i));
		return cards;
	}
}