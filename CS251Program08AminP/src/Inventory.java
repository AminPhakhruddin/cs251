import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private String name;
	private ArrayList<Vehicle> vehicles;
	
	public Inventory()
	{
		this("");
	}
	
	public Inventory(String name)
	{
		this.setName(name);
		this.vehicles = new ArrayList<Vehicle>();
	}
	
	private void setName(String name)
	  {
	    this.name = name;
	  }
	
	public String getName()
	  {
	    return this.name;
	  }
	
	public void addVehicle(Vehicle vehicle)
	  {
	    this.vehicles.add(vehicle);
	  }
	
	public void vehicleAudit()
	  {
	    System.out.println("Inventory\'s Title: " + this.getName());
	    for (Vehicle vehicle : vehicles )
	    {
	      System.out.println("\t\t" + vehicle.toString());
	    	  System.out.println("Taxes: $" + this.taxAudit(vehicle));
	    }
	  }
	
	public double taxAudit(Vehicle vehicle)
	 {
		double tax;
		if(vehicle.getGasoline())
		{
			if(vehicle instanceof Car && ((Car) vehicle).getWeight() > 1)
			{
				tax = 0.06 * (vehicle.getCost() + 100 * vehicle.getWheels()) + 200;
			}
			tax = 0.06 * (vehicle.getCost() + 100 * vehicle.getWheels());
		}
		else
		{
			tax = 0.04 * (vehicle.getCost() + 100 * vehicle.getWheels());
		}
		return tax;
	 }
	
	
	
}
