
public class Leader extends Person {

	private int term;
	
	 public Leader()
	  {
	    super();
	    this.term = 0;
	  }

	  public Leader(String name, int term)
	  {
	    super(name);
	    this.term = term;
	  }
	  
	  public int getTerm()
	  {
	    return this.term;
	  }
	  
	  public String toString()
	  {
	    return  super.toString() + " : Term - " + this.getTerm();
	  }

	
}
