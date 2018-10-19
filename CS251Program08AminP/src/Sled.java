
public class Sled extends Vehicle{
	
	public int getWheels() {
		return 3;
	};
	
	public Sled() {
		super();
	}
	
	public Sled(int id, int cost, boolean gas) {
		super(id, cost, gas);
	}
	
	public boolean equals(Object guest)
	  {
		
	    if ((guest == null) || !(guest instanceof Sled))
	      return false;
	    if (((Sled)guest).getCost() != this.getCost())
		      return false;
	    if (((Sled)guest).getGasoline() != this.getGasoline())
		      return false;
	    if (((Sled)guest).getId() != this.getId())
		      return false;
	    
	    return true;
	  }
	  
	  public String toString()
	  {
		  return "ID: " + this.getId() + "\n Cost: "+ this.getCost() + "\n Gasoline: " + this.getGasoline() + "\n Wheels: " + this.getWheels();
	  }

}
