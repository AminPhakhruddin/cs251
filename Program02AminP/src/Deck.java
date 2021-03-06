
public class Deck {
	
	private boolean [] deck = new boolean[52];
	private int length = deck.length;
	
	
	public void initDeck(Deck myDeck) {
		// set the values of deck to indicate that they are all
		// present - not dealt yet.
			  for(int i = 0; i < 52; ++i)
			  {
				  this.deck[i] = true;
			  }
		}
		
		public void printInit(Deck myDeck)
		  {
			  System.out.println();
			  System.out.println();
			  
			  
			  for(int i = 0; i < length; ++i)
				  System.out.print(this.deck[i] + " ");
			  System.out.println();
		  }
		
		public boolean emptyDeck(Deck myDeck) {
			// returns whether or not all the cards in the deck
			// have already been dealt.
				Boolean isEmpty = true;
				
				for (int i = 0; i < 52 && isEmpty; ++i) {
					if (this.deck[i] == true) 
						isEmpty = false;			
					
				}
				
				return isEmpty;
			}
		
		public int dealCard(Deck myDeck) {
			// returns a card (an int in the range 0 to 51) at random
			// that has not been dealt since the deck was initialize
			// via intDeck. Also notes (in deck) that this card is
			// no longer available.
				int randomCard;
				
				do {
					randomCard = (int)(Math.random()*52);
					
				} while (this.deck[randomCard] == false);
				
				this.deck[randomCard] = false;
				
				return randomCard;

			}
		
		public void printCard(int card) {
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
