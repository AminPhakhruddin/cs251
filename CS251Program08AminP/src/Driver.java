
public class Driver {
	public static void main (String[]args) {
		
		Car JamesBond = new Car(007, 500000, true, 2);
		Sled Santa = new Sled(1, 50 , false);
		Cycle Rossi = new Cycle(46, 100000, true);
		Inventory famous= new Inventory("Famous");
		famous.addVehicle(JamesBond);
		famous.addVehicle(Santa);
		famous.addVehicle(Rossi);
		famous.vehicleAudit();
		

		
	
		
		
		
		
		
		
	}
	
}
