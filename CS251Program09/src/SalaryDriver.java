
public class SalaryDriver {
	public static void main(String[] args) 
	  {
		SalaryData sData = new SalaryData();
		sData.display("Salarydoc.txt");
		sData.create("test1.txt");
		sData.addTo("test1.txt", "test1.txt", 3, 5, 5);
		sData.addTo("test1.txt", "test1.txt", 6, 5, 5);
		sData.addTo("test1.txt", "test1.txt", 7, 5, 5);
		sData.addTo("test1.txt", "test1.txt", 10, 5, 5);
		sData.addTo("test1.txt", "test1.txt", 9, 5, 5);
		sData.addTo("test1.txt", "test1.txt", 5, 5, 5);
		//boolean copy1 = sData.addTo("test1.txt", "test1.txt", 6, 5, 5);
		//System.out.println("Method Returned did it add? " + copy1);
		//boolean n1 = sData.addTo("test1.txt", "test1.txt", 6, 5, 5);
		//System.out.println(n1);
	  }

}
