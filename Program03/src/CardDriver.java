
public class CardDriver {
	public static void main(String[] args) {
		
		Card [] deck = new Card[52];
		final int cardsPerRow = 8;
		int cardsThisRow = 0;
		int myCard;
		
		
		for(int i = 0; i < deck.length; ++i) {
			
			String [] suits = {"D", "H", "S", "C"};
			String [] vals = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};//this has to be an array, so fix it
			//System.out.print(vals[12]);
			
			int x  = 0;
			  for(int i1 = 0; i1 < 4; ++i1)
			  {
				  for(int j = 0; j < 13; ++j)
				  {
					  deck[x] = new Card(suits[i1], vals[j]);
					  ++x;
				  }
			  }
			  
			}
		
		
		  for(int i = 0; i <= 100; ++i)
		  {
		  int index1 = (int)(Math.random()*51);
		  int index2 = (int)(Math.random()*51);
			  
		  Card tmp = deck[index1];
		  deck[index1] = deck[index2];
		  deck[index2] = tmp;
			  
		  }
		  
		 
		  System.out.println("\nHere is a shuffled deck ...\n");
		  for(int i = 0; i < deck.length; ++i) {
				++cardsThisRow;
				if (cardsThisRow <= cardsPerRow)
				{
					System.out.print(deck[i].toString());
					System.out.print(" ");
				}
				else
				{
					System.out.println("");
					cardsThisRow = 1;
					System.out.print(deck[i].toString());
					System.out.print(" ");
				}
		  }
			
			
			System.out.println('\n');
		  
			  //System.out.println(index1);
			  //System.out.println(index2);
		  
		  
	
		  
		  
		  
		  
		  System.out.println();
		  
		  Card queenOfClubs = new Card("C","Q");
		  int foundQ = 0;
		  
		  /*
		  System.out.println(deck[50].getSuit());
		  System.out.println(deck[50].getRank());
		  System.out.println(deck[50].equals(queenOfClubs));
		  System.out.println(queenOfClubs.getSuit());
		  System.out.println(queenOfClubs.getRank());
		  System.out.println(deck[50].getSuit() == queenOfClubs.getSuit());
		  */
		
		  for(int i = 0; i < deck.length; ++i) 
		  {
			  if(deck[i].equals(queenOfClubs)) {
				  foundQ = i;
				  
			  }
		  }
		  
		  System.out.println("The Queen of Clubs was found at location " + foundQ);
		
		
	}
	
	
	



}


