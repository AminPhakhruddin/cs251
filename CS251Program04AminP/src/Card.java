
public class Card {
	
	private String suit;
	private String rank;
	
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