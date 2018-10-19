
public abstract class Vehicle {
	private int id;
	private int cost;
	private boolean gasoline;
	
	public abstract Vehicle getWheels();
	
	
	public Vehicle()
	  {
	   this(0,0,true);
	  }
	  
	public Vehicle(int id, int cost, boolean gasoline)
	  {
	    this.setId(id);
	    this.setCost(cost);
	    this.setGasoline(gasoline);
	  }
	  
	protected void setId(int n)
	  {
	    if (n >= 0)
	      this.id = n;
	    else
	      this.id = 0;
	  }
	  
	protected void setCost(int n)
	  {
	    if (n >= 0)
	      this.cost = n;
	    else
	      this.cost = 0;
	  }
	  
	protected void setGasoline(boolean n)
	  {
		  this.gasoline = n;
	  }
	
	public int getId()
	  {
	    return this.id;
	  }
	
	public int getCost()
	  {
	    return this.cost;
	  }
	
	public boolean getGasoline()
	  {
	    return this.gasoline;
	  }
	
	public boolean equals(Object guest)
	  {
		
	    if ((guest == null) || !(guest instanceof Vehicle))
	      return false;
	    if (((Vehicle)guest).getId() != this.getId())
	      return false;
	    if (((Vehicle)guest).getCost() != this.getCost())
		      return false;
	    if (((Vehicle)guest).getGasoline() != this.getGasoline())
		      return false;
	    
	    return true;
	  }
	  
	  public String toString()
	  {
	    return "" + this.getId() + ""+ this.getCost() + "" + this.getGasoline();
	  }
	
	
	
	
	
}

