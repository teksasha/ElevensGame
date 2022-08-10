package activity2;

/**
 * Card.java
 *
 * Card represents a playing card.
 */
public class Card
{
	private String rank;
	private String suit;
	private int pointValue;

	/**
	 * Creates a new Card instance.
	 *
	 * @param cardRank
	 *            a String value containing the rank of the card
	 * @param cardSuit
	 *            a String value containing the suit of the card
	 * @param cardPointValue
	 *            an int value containing the point value of the card
	 */
	public Card(String cardRank, String cardSuit, int cardPointValue)
	{
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}

	/**
	 * Accesses this Card's suit.
	 * 
	 * @return this Card's suit.
	 */
	public String getSuit()
	{
		return suit;
	}

	/**
	 * Accesses this Card's rank.
	 * 
	 * @return this Card's rank.
	 */
	public String getRank()
	{
		return rank;
	}

	/**
	 * Accesses this Card's point value.
	 * 
	 * @return this Card's point value.
	 */
	public int getValue()
	{
		return pointValue;
	}

	/**
	 * Compare this card with the argument.
	 * 
	 * @param other the other card to compare to this
	 * 
	 * @return true if the rank, suit, and point value of this card are equal to
	 *         those of the argument; false otherwise.
	 */
	
	@Override
    public boolean equals(Object other) 
    {
        // return false if the object is not a Card
        if(!(other instanceof Card)){
        	return false;
        }
        
        Card otherCard = (Card)other; // we know other is a Card now
        
        if(this.rank.equals(otherCard.rank) && this.suit.equals(otherCard.suit) && this.pointValue == otherCard.pointValue){
        	return true;
        }
        
        else{
        	return false;
        }
        
        // return true only if rank and suit and value are the same
        // between the two Cards, otherwise return false
  
    }

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 * "[Rank] of [Suit] (point value = [PointValue])". This provides a useful
	 * way of printing the contents of a Deck in an easily readable format or
	 * performing other similar functions.
	 *
	 * @return a String containing the rank, suit, and point value of the card.
	 */
	@Override
	public String toString()
	{
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}