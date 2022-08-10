package activity2;

import org.junit.Test;

import testHelp.*;

public class CardTests
{

	@Test
	public void CardConstructorShouldNotCrash()
	{
		Card test = new Card("Two", "Hearts", 2);
		verify.that(test).isOfType(Card.class);
	}

	@Test
	public void CardShouldReturnRank()
	{
		Card test = new Card("Two", "Hearts", 2);
		verify.that(test.getRank()).isEqualTo("Two");
	}

	@Test
	public void CardShouldReturnSuit()
	{
		Card test = new Card("Two", "Hearts", 2);
		verify.that(test.getSuit()).isEqualTo("Hearts");
	}

	@Test
	public void CardShouldReturnPointValue()
	{
		Card test = new Card("Two", "Hearts", 2);
		verify.that(test.getValue()).isEqualTo(2);
	}

	@Test
	public void RankSuitAndPointValueAreEqual()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Ace", "Spades", 1);
		verify.that(a.equals(b)).isTrue();
	}

	@Test
	public void DifferentRankReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Queen", "Spades", 1);
		verify.that(a.equals(b)).isFalse("because rank is different");
	}

	@Test
	public void DifferentSuitReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Ace", "Hearts", 1);
		verify.that(a.equals(b)).isFalse("because suit is different");
	}

	@Test
	public void DifferentValueReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Ace", "Spades", 2);
		verify.that(a.equals(b)).isFalse("because value is different");
	}

	@Test
	public void DifferentRankAndSuitReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Queen", "Hearts", 1);
		verify.that(a.equals(b)).isFalse("because rank and suit are different");
	}

	@Test
	public void DifferentRankAndValueReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Queen", "Spades", 2);
		verify.that(a.equals(b)).isFalse("because rank and value are different");
	}

	@Test
	public void DifferentSuitAndValueReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Ace", "Hearts", 2);
		verify.that(a.equals(b)).isFalse("because suit and value are different");
	}

	@Test
	public void DifferentRankSuitAndValueReturnsFalseForEquals()
	{
		Card a = new Card("Ace", "Spades", 1);
		Card b = new Card("Queen", "Hearts", 2);
		verify.that(a.equals(b)).isFalse("because rank, suit, and value are different");
	}

	@Test
	public void ReturnsFalseWhenObjectIsNotACard()
	{
		String a = "hi";
		Card b = new Card("Ace", "Spades", 1);
		verify.that(a.equals(b)).isFalse("because object a is not a card");
	}

	@Test
	public void ReturnsFalseWhenCardIsNull()
	{
		Card a = null;
		Card b = new Card("Ace", "Spades", 1);
		verify.that(b.equals(a)).isFalse();
	}

	@Test
	public void ReturnsTrueWhenCardIsComparedToSelf()
	{
		Card a = new Card("Ace", "Spades", 1);
		verify.that(a.equals(a)).isTrue();
	}

	@Test
	public void toStringReturnsPropervalue() // needs fixing
	{
		Card a = new Card("Ace", "Spades", 1);
		verify.that(a.toString())
				.isEqualTo(a.getRank() + " of " + a.getSuit() + " (point value = " + a.getValue() + ")");
	}
}