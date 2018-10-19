
public class Principle extends Person 
{
	private double salary;
	
	 public Principle()
	  {
	    super();
	    this.salary = 0.0;
	  }

	  public Principle(String name, double salary)
	  {
	    super(name);
	    this.salary = salary;
	  }
	  
	  public double getSalary()
	  {
	    return this.salary;
	  }
	  
	  public String toString()
	  {
	    return  super.toString() + " : " + this.getSalary();
	  }

}
