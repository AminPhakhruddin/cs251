
public class DynArrayDriver {
	
	public static void main(String[] args)
	{
	DynArray myArray = new DynArray();
	
	System.out.println("array size = " + myArray.arraySize());
	System.out.println("size = " + myArray.size());
	System.out.println("\n");
	
	double pot = 1.0;
	for (int v = 0; v < 10; ++v)
	{
	myArray.insert(pot);
	System.out.println("myArray.at(" + v + ") = " + myArray.at(v));
	System.out.println("array size = " + myArray.arraySize());
	System.out.println("size = " + myArray.size() + "\n");
	pot *= 2;
	}
	
	System.out.println("myArray.at(10) = " + myArray.at(10));
	System.out.println("\n");
	
	
	for (int v = 0; v < 10; ++v)
	{
		double value = myArray.remove();
		System.out.println("value = " + value);
		System.out.println("array size = " + myArray.arraySize());
		System.out.println("size = " + myArray.size() + "\n");
	}
	
	double value = myArray.remove();
	
	System.out.println("value = " + value);
	System.out.println("array size = " + myArray.arraySize());
	System.out.println("size = " + myArray.size());
	System.out.println("\n");
	
	for (int i = 0; i < 5; ++i)
	{
		myArray.insertAt(i, 3.0 * i);
		System.out.println("myArray.at(" + i + ") = " + myArray.at(i));
		System.out.println("array size = " + myArray.arraySize());
		System.out.println("size = " + myArray.size() + "\n");
	}
	
	myArray.printArray();
	System.out.println();
	value = myArray.removeAt(2);
	
	System.out.println("value = " + value);
	System.out.println("array size = " + myArray.arraySize());
	System.out.println("size = " + myArray.size() + "\n");
	myArray.printArray();
	
	System.out.println();
	
	value = myArray.removeAt(4);
	System.out.println("value = " + value);
	System.out.println("array size = " + myArray.arraySize());
	System.out.println("size = " + myArray.size() + "\n");
	
	System.out.println();
	
	myArray.insertAt(4, 3.0);
	System.out.println("myArray.at(" + 4 + ") = " + myArray.at(4));
	System.out.println("array size = " + myArray.arraySize());
	System.out.println("size = " + myArray.size() + "\n");
	myArray.printArray();
	
	System.out.println();
	
	System.out.println("first location of the value 2.0 is " + myArray.indexOf(2.0));
	int loc = myArray.indexOf(3.0);
	System.out.println("first location of the value 3.0 is " + loc);
	loc = myArray.indexOf(loc+1, 3.0);
	System.out.println("second location of the value 3.0 is " + loc);
	loc = myArray.indexOf(loc+1, 3.0);
	System.out.println("third location of the value 3.0 is " + loc);
	
	
	}
	
}


