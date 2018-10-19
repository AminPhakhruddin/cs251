
public class Program01Amin {
	public static void main (String [] args) {
		
		boolean[] myDeck = new boolean[52];
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		int myCard;
		initDeck(myDeck);
		
		/*
		printInit(myDeck);
		System.out.println(emptyDeck(myDeck));
		
		Boolean isEmpty = true;
		
		System.out.println(myDeck[2]);
		
		if(myDeck[2] == true) {
			
			isEmpty = false;
			
		}
		
		System.out.println(isEmpty);
		*/
		
		
		System.out.println("\nHere is a shuffled deck ...\n");
		while (!emptyDeck(myDeck))
		{
			myCard = dealCard(myDeck);
			++cardsThisRow;
			if (cardsThisRow <= cardsPerRow)
			{
				printCard(myCard);
				System.out.print(" ");
			}
			else
			{
				System.out.println("");
				cardsThisRow = 1;
				printCard(myCard);
				System.out.print(" ");
			}
		}
		
		System.out.println('\n');
		
		
	}
	
	public static void initDeck(boolean[] deck) {
	// set the values of deck to indicate that they are all
	// present - not dealt yet.
		  for(int i = 0; i < 52; ++i)
		  {
			  deck[i] = true;
		  }
	}
	
	public static void printInit(boolean [] tmpArr)
	  {
		  System.out.println();
		  System.out.println();
		  
		  for(int i = 0; i < tmpArr.length; ++i)
			  System.out.print(tmpArr[i] + " ");
		  System.out.println();
	  }
	
	
	public static boolean emptyDeck(boolean[] deck) {
	// returns whether or not all the cards in the deck
	// have already been dealt.
		Boolean isEmpty = true;
		
		for (int i = 0; i < 52 && isEmpty; ++i) {
			if (deck[i] == true) 
				isEmpty = false;			
			
		}
		
		return isEmpty;
	}
	
	public static int dealCard(boolean[] deck) {
	// returns a card (an int in the range 0 to 51) at random
	// that has not been dealt since the deck was initialize
	// via intDeck. Also notes (in deck) that this card is
	// no longer available.
		int randomCard;
		
		do {
			randomCard = (int)(Math.random()*52);
			
		} while (deck[randomCard] == false);
		
		deck[randomCard] = false;
		
		return randomCard;

	}
	
	public static void printCard(int card) {
	// given a card (an int in the range 0 to 51) prints
	// an appropriate representation of this card based
	// on a 1-1 and onto mapping of the set [0, 51] to
	// the cards described above.
		
		String suits = "DHSC";
		String vals = "A2345678910JQK";
		
		String[] deckOfCards = new String[52];
		int x  = 0;
		  for(int i = 0; i < 4; ++i)
		  {
			  for(int j = 1; j <= 13; ++j)
			  {
				  deckOfCards[x] = String.valueOf(suits.charAt(i)) + String.valueOf(vals.charAt(j));
				  ++x;
			  }
		  }
		  
		  System.out.print(deckOfCards[card]);
		
	
	}
	

}
