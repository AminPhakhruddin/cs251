
public class Deck {
	
		private Card[] deck = new Card[52];
		private int cardsDealt;
		
		public Card[] getDeck() {
			
			return this.deck;
		}
		
		public Deck() {
		// constructor
		// set each element of deck to a unique Card object,
		// and sets cardsDealt to zero.
			for(int i = 0; i < this.deck.length; ++i) {
				
				String [] suits = {"D", "H", "S", "C"};
				String [] vals = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};//this has to be an array, so fix it
				//System.out.print(vals[12]);
				
				int x  = 0;
				  for(int i1 = 0; i1 < 4; ++i1)
				  {
					  for(int j = 0; j < 13; ++j)
					  {
						  this.deck[x] = new Card(suits[i1], vals[j]);
						  ++x;
					  }
				  }
				  
				}
			
			
		}
		
		
		public int getCardsDealt() {
		// accessor
		// return the value of cardsDealt.
			return this.cardsDealt;
		}
		
		private void setCardsDealt(int cardsDealt)
		{
		// mutator
		// sets cardsDealt specified value (cardsDealt)
			if (this.getCardsDealt() >= 0 && this.getCardsDealt() <= 52)
			      this.cardsDealt = cardsDealt;
			    else
			      this.cardsDealt = 0;
		}
		
		
		public boolean emptyDeck()
		{
		// returns whether or not all the cards in deck
		// have already been dealt (cardsDealt == 52).
			boolean emptyDeck;
			
			if(this.getCardsDealt() == 52)
				emptyDeck = true;
			else
				emptyDeck = false;
			
			return emptyDeck;
			
		}
		
		public void collectCards() {
		// set cardsDealt to zero.
			this.setCardsDealt(0);
		}
		
		public void collectCards(int cardCnt) 					////check this for accessors
		{
		// decrement cardsDealt by cardCnt.
			
			this.cardsDealt = this.getCardsDealt()-cardCnt;
		}
		
		
		public Card dealCard()
		{
		// if emptyDeck() is false ...
		// returns the card at location cardsDealt in deck,
		// and increments cardsDealt by 1.
		// else ...
		// returns null
			Card myCard = null;
			
			if (!this.emptyDeck())
			{
			
				 myCard = this.deck[this.getCardsDealt()];
				 myCard.toString();
				 this.setCardsDealt(this.getCardsDealt() + 1);
				
			}
			
			return myCard;

		}
		
		
		
		public void shuffleDeck()
		{
		// apply 100 random card swaps within deck
			this.shuffleDeck(100);
		}
		
		
		public void shuffleDeck(int swapCnt) {
		// apply swapCnt random card swaps within deck
			for(int i = 0; i <= swapCnt; ++i)
			  {
			  int index1 = (int)(Math.random()*51);
			  int index2 = (int)(Math.random()*51);
				  
			  Card tmp = deck[index1];
			  deck[index1] = deck[index2];
			  deck[index2] = tmp;
				  
			  }
			

		}

}
