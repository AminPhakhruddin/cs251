
public class DynArrayDriver {
	public static void main(String[]args) {
		DynArray myArray = new DynArray();

		for(int i = 0; i<= 10 ; ++i) {
			myArray.insert(i);
			System.out.println("array size = " + myArray.arraySize());
			System.out.println("size = " + myArray.elements());
			System.out.println("\n");
		}
		
		for(int i = 0; i <= 10; ++i) {
			System.out.print(myArray.get(i) + " ");

		}
		
		System.out.println();

		System.out.println(myArray.remove(3));
		
		for(int i = 0; i <= 10; ++i) {
			System.out.print(myArray.get(i) + " ");

		}
		
		System.out.println();
		System.out.println("array size = " + myArray.arraySize());
		System.out.println("size = " + myArray.elements());
		System.out.println("\n");
		
		System.out.println(myArray.remove(3));
		
		for(int i = 0; i <= 10; ++i) {
			System.out.print(myArray.get(i) + " ");

		}
		
		System.out.println();
		System.out.println("array size = " + myArray.arraySize());
		System.out.println("size = " + myArray.elements());
		System.out.println("\n");
		
		
		
		
		
	}

}
