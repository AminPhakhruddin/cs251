import java.util.Arrays;

public class DynArray {
	
	private double[] array;
	  private int size;
	  private int nextIndex;
	  
	  public int arraySize()
	  {
		  return size;
	  }
	  
	  public int elements()
	  {
		  return nextIndex;
	  }
	  
	  public DynArray()
	  {
		  size = 1;
		  array = new double[size];
		  nextIndex = 0;

	  }
	  
	  private void grow()
	  {
		  array = Arrays.copyOf(array, array.length * 2);
		  size = size * 2;
	  }
	  
	  private void shrink()
	  {
		  array = Arrays.copyOf(array, array.length/2);
		  size = size/2;
	  }
	  
	  public void insert(double num) 
	  {
		  if(this.elements() == this.arraySize()/2)
			  this.grow();
		  array[nextIndex++] = num;
		  
	  }
	  
	  public double remove(int index) {
		  double num = 0;
		  num = array[index];
			if (index < nextIndex) {
				num = array[index];
				int temp = index;

				while (temp < nextIndex) {
					array[temp] = array[temp + 1];
					temp++;
				}

				nextIndex--;
			}
			return num;
	  }
	  
	  public Double get(int index) {
		  Double num = 0.0;
			if (index < nextIndex) {
				num = array[index];
			}
			return num;
		
	  }
	  
}

	
	
