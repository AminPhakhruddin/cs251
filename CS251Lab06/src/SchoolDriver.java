
public class SchoolDriver {
	public static void main (String[]args) {
		
		Student Jimmy = new Student("Jimmy", 3.5);
		Student Jenny = new Student("Jenny", 3.8);
		Principle John = new Principle("John Hawlks", 35000.0);
		School east = new School("Somewhere East", "John Hawlks" , 35000);
		east.addStudent(Jimmy);
		east.addStudent(Jenny);
		east.schoolAudit();
		
		Student Billy = new Student("Billy", 3.8);
		//Student Jenny1 = new Student("Jenny", 3.8);
		School west = new School("Somewhere West", "Amy Hope" , 40000);
		west.addStudent(Billy);
		west.addStudent(Jenny);
		west.schoolAudit();
		
	
		
		
		
		
		
		
	}

}
