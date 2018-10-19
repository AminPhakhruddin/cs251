
public class OrgDriver {
	
	public static void main (String[]args) {
			
		Member Jimmy = new Member("Jimmy", 1);
		Member Jenny = new Member("Jenny", 2);
		Leader John = new Leader("John Hawlks", 2);
		Org east = new Org("Eastcoast", "John Hawlks" , 2);
		east.addStudent(Jimmy);
		east.addStudent(Jenny);
		east.orgAudit();

		Member Billy = new Member("Billy", 3);
		//Student Jenny1 = new Student("Jenny", 3.8);
		Org west = new Org("New Berlin West", "Amy Hope" , 1);
		west.addStudent(Billy);
		west.addStudent(Jenny);
		west.orgAudit();
			
		
			
			
		

	}
}
