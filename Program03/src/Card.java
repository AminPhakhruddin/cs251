
public class Card {
	
	private String suit;
	private String rank;
	
	public void HelloWorld() {
		System.out.println("Hello world");
	}



	public String getSuit() {
		return suit;
	}



	private void setSuit(String suit) {
		this.suit = suit;
	}



	public String getRank() {
		return rank;
	}



	private void setRank(String rank) {
		/*
		String [] vals = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		boolean possible;
		for ( int i = 0; i <= 12 && (possible = false); ++i)
			if(rank.equals(vals[i]))
		*/
			this.rank = rank;
	}
	
	//default constructor
	public Card() {
		this("C", "A");
	}
	
	//Specifying instructor
	public Card(String suit, String rank) {
		
		this.setSuit(suit);
		this.setRank(rank);
	}
	
	public Card clone() {
		
		Card card = new Card();
		card.setRank(this.getRank());
		card.setSuit(this.getSuit());
		return card;
		
	}
	
	public String toString() {
		String card = (this.getSuit() + this.getRank());
		return card;
		
		
		
	}
	
	public boolean equals(Card guest) {
		boolean equal = false;
		if((this.getSuit().equals(guest.getSuit())) && (this.getRank().equals(guest.getRank()))){
			equal = true;
		}
		
		return equal;
		
	}
	

}

