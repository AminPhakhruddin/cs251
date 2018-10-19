
public class Cycle extends Vehicle {
	
	
	public int getWheels() {
		return 2;
	};
	
	public Cycle() {
		super();
	}
	
	public Cycle(int id, int cost, boolean gas) {
		super(id, cost, gas);
	}
	
	public boolean equals(Object guest)
	  {
		
	    if ((guest == null) || !(guest instanceof Cycle))
	      return false;
	    if (((Cycle)guest).getCost() != this.getCost())
		      return false;
	    if (((Cycle)guest).getGasoline() != this.getGasoline())
		      return false;
	    if (((Cycle)guest).getId() != this.getId())
		      return false;
	    
	    return true;
	  }
	  
	  public String toString()
	  {
		  return "ID: " + this.getId() + "\n Cost: "+ this.getCost() + "\n Gasoline: " + this.getGasoline() + "\n Wheels: " + this.getWheels();
	  }

	
	
}
