
public class Car extends Vehicle {
	private int weight;
	
	public int getWheels() {
		return 4;
	};
	
	public Car() {
		this(0,0, true,0);
	}
	
	public Car(int id, int cost, boolean gas, int weight) {
		super(id, cost, gas);
		this.setWeight(weight);
	}
	
	protected void setWeight(int n)
	  {
	    if (n >= 0)
	      this.weight = n;
	    else
	      this.weight = 0;
	  }
	
	public int getWeight()
	  {
	    return this.weight;
	  }
	
	public boolean equals(Object guest)
	  {
		
	    if ((guest == null) || !(guest instanceof Car))
	      return false;
	    if (((Car)guest).getWeight() != this.getWeight())
	      return false;
	    if (((Car)guest).getCost() != this.getCost())
		      return false;
	    if (((Car)guest).getGasoline() != this.getGasoline())
		      return false;
	    if (((Car)guest).getId() != this.getId())
		      return false;
	    
	    return true;
	  }
	  
	  public String toString()
	  {
	    return "ID: " + this.getId() + "\n Cost: "+ this.getCost() + "\n Gasoline: " + this.getGasoline() + "\n Wheels: " + this.getWheels() + "\n Weight(tons): " + this.getWeight();
	  }
	
	
}
