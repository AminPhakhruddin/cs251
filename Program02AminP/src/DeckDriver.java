
public class DeckDriver {
public static void main (String [] args) {
		
		SmartDeck myDeck = new SmartDeck(); //change this to test both Deck myDeck = new Deck();
	
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		int myCard;
		myDeck.initDeck(myDeck);
		//myDeck.printInit(myDeck);
		
		//System.out.println("Hello World");
		
		
		System.out.println("\nHere is a shuffled deck ...\n");
		while (!myDeck.emptyDeck(myDeck))
		{
			myCard = myDeck.dealCard(myDeck);
			++cardsThisRow;
			if (cardsThisRow <= cardsPerRow)
			{
				myDeck.printCard(myCard);
				System.out.print(" ");
			}
			else
			{
				System.out.println("");
				cardsThisRow = 1;
				myDeck.printCard(myCard);
				System.out.print(" ");
			}
			
		}
		
		
		
		System.out.println('\n');
	} 

}
