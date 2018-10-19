
public class Member extends Person {

	private int id;
	  
	  public Member()
	  {
	    super();
	    this.id = 0;
	  }

	  public Member(String name, int id)
	  {
	    super(name);
	    this.id = id;
	  }
	  
	  public int getId()
	  {
	    return this.id;
	  }
	  
	  public String toString()
	  {
	    return  super.toString() + " : Id - " + this.getId();
	  }
}
