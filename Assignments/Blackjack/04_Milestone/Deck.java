// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	// define fields here
	Card[] d;
	int index;
	// This constructor builds a deck of 52 cards.
	public Deck(Card[] deck)
	{
		d = deck;
		index = -1;
	}

	
	// This method takes the top card off the deck and returns it.
	public Card deal()
	{
		if (index == d.length)
			return null;
		else {
			index++;
			return d[index];
		}
	}
	
	
	public boolean isEmpty()
	{
		return index == d.length ; 
	}
}

