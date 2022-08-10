package activity2;

import java.util.ArrayList;

import org.junit.Test;

import testHelp.verify;

public class DeckTests
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
	public void DeckConstructorShouldNotCrash()
	{
		Deck test = new Deck(ranks, suits, values);
		verify.that(test).isOfType(Deck.class);
	}

	@Test
	public void DeckConstructorShouldHandleSingleCard()
	{
		Deck test = new Deck(ranks1, suits1, values1);
		verify.that(test.getCardsLeft()).isEqualTo(1);
	}

	@Test
	public void DealReturnsCorrectCardInOneCardDeck()
	{
		Deck test = new Deck(ranks1, suits1, values1);
		Card expected = new Card("Seven", "Hearts", 7);
		verify.that(test.deal()).isEqualTo(expected);
	}

	@Test
	public void DeckShouldReturnCorrectSizeWithMultipleCards()
	{
		Deck test = new Deck(ranks, suits, values);
		verify.that(test.getCardsLeft()).isEqualTo(12);
	}

	@Test
	public void DeckShouldReturnZeroAfterDealingAllCards()
	{
		Deck test = new Deck(ranks, suits, values);
		while (test.getCardsLeft() != 0)
		{
			test.deal();
		}
		verify.that(test.getCardsLeft() == (0)).isTrue();
	}

	@Test
	public void DeckShouldReturnCorrectSizeAfterDealingOneCard()
	{
		Deck test = new Deck(ranks, suits, values);
		int deckSize = test.getCardsLeft() - 1;
		test.deal();
		verify.that(test.getCardsLeft() == deckSize).isTrue();
	}

	@Test
	public void DealShouldReturnNullIfDeckIsEmpty()
	{
		Deck test = new Deck(ranks0, suits0, values0);
		verify.that(test.deal() == null).isTrue();
	}

	@Test
	public void ShuffleShouldChangeCardOrder()
	{
		Deck test = new Deck(ranks, suits, values);
		Deck test2 = new Deck(ranks, suits, values);
		int deckLength = test.getCardsLeft();
		int diffs = 0;
		for (int i = 0; i < deckLength; i++)
		{
			Card temp = test.deal();
			Card temp2 = test2.deal();
			if (!(temp.equals(temp2)))
			{
				diffs++;
			}
		}
		verify.that((diffs != 0)).isTrue();
	}
	
	
}