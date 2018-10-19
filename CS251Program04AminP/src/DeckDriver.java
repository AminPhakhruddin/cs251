
public class DeckDriver {
	public static void main(String[]args) 
	{
		Deck myDeck = new Deck(); //change this to test both Deck myDeck = new Deck();
		
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		Card myCard;
		
		//System.out.println("Hello World");
		
		myDeck.shuffleDeck();
		
		
		System.out.println("\nHere is a shuffled deck ...\n");
		while (!myDeck.emptyDeck())
		{
			++cardsThisRow;
			if (cardsThisRow <= cardsPerRow)
			{
				myCard = myDeck.dealCard();
				System.out.print(myCard.toString());
				System.out.print(" ");
			}
			else
			{
				System.out.println("");
				cardsThisRow = 1;
				myCard = myDeck.dealCard();
				System.out.print(myCard.toString());
				System.out.print(" ");
			}
			
		}
		
		
		
	}

}
