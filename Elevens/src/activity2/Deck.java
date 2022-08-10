package activity2;

import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards. It provides several
 * operations including initialize, shuffle, deal, and check if empty.
 */
public class Deck
{
	ArrayList<Card> cardDeck = new ArrayList<Card>();
	Card c = new Card("Ace", "Spades", 1);

	/**
	 * Creates a new Deck instance. It pairs each element of ranks with each
	 * element of suits, and produces one of the corresponding card.
	 * 
	 * @param ranks
	 *            is an array containing all of the card ranks.
	 * @param suits
	 *            is an array containing all of the card suits.
	 * @param values
	 *            is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values)
	{
		// Traverses all the suits
		for (int i = 0; i < suits.length; i++)
		{
			// Traverses all the ranks and creates a new card with each suit,
			// rank, and point values
			for (int j = 0; j < ranks.length; j++)
			{
				Card temp = new Card(ranks[j], suits[i], values[j]);
				cardDeck.add(temp);
			}
		}
		
		shuffle();
	}

	/**
	 * Determines if this deck is empty (no undealt cards).
	 * 
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		if (cardDeck.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * 
	 * @return the number of undealt cards in this deck.
	 */
	public int getCardsLeft()
	{
		return cardDeck.size();
	}

	/**
	 * Randomly permute the given collection of cards and reset the size to
	 * represent the entire deck.
	 */
	public void shuffle()
	{
		// Insert code that rearranges the cards in the deck so they are in
		// random order.
		for (int i = 0; i < cardDeck.size() - 1; i++)
		{
			Card card = cardDeck.get(i);
			int value = (int) (Math.random() * cardDeck.size());
			Card shuffleCard = cardDeck.get(value);
			cardDeck.set(i, shuffleCard);
			cardDeck.set(value, card);
		}
	}

	/**
	 * Deals a card from this deck.
	 * 
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal()
	{
		// return the top (undealt) card from the deck
		// and update the undealt instance variable.
		if (getCardsLeft() == 0){
			return null;
		}
		else {
			Card top = cardDeck.get(0);
			cardDeck.remove(cardDeck.get(0));
			return top;
		}
		
	}
}