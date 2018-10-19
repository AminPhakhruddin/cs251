import java.util.Arrays;

public class DynArray
{
	private Double[] array; //NOTE: that is Double NOT double
	private int physicalSize; // size of array
	private int effectiveSize; // number of elements used in array
	
	public DynArray() { // constructor
	// set array to a new array of Double, of size one
	// set physicalSize to one,
	// and set effectiveSize to zero.
		  array = new Double[1];
		  physicalSize = 1;
		  effectiveSize = 0;
	}
	
	public int arraySize() { // accessor
	// return the value of physicalSize.
	// this is only for debugging purposes
		return physicalSize;
	}
	
	public int size() { // accessor
	// return the value of effectiveSize.
		return effectiveSize;
	}
	
	public Double at(int index) { // accessor
	// if 0 <= index < effectiveSize
	// return the value of array[index].
	// else
	// return Double.NaN
		if (index >= 0 && index <effectiveSize) {
			return array[index];
		} else {
			return Double.NaN;
			
		}
	}
	
	private void grow() {
	// make array a reference to an array that is twice as large
	// that contains the same values for indicies 0 through
	// effectiveSize - 1, and adjust physicalSize appropriately.
		array = Arrays.copyOf(array, array.length * 2);
		physicalSize = physicalSize * 2;
	}
	
	private void shrink() {
	// make array a reference to an array that is half as large
	// that contains the same values for indicies 0 through
	// effectiveSize - 1, and adjust physicalSize appropriately.
		
		array = Arrays.copyOf(array, array.length/2);
		physicalSize = physicalSize/2;
	}
	
	public void insertAt(int index, Double value) { // mutator
	// if 0 <= index <= effectiveSize
	// move the necessary values forward one so that value can
	// be inserted at the location index in array, inserts
	// value at the location index, and adjust effectiveSize
	// appropriately.
	// Note: a grow() may be necessary beforehand.
	// else
	// do nothing.

		
		if(index >= 0 && index <= this.size()) {
			
			
			if(this.size() == this.arraySize()) {
				this.grow();
				
			}
			
			
			
			int temp = this.size();
			
			while (temp > index) {
				array[temp] = array[temp - 1];
				temp--;
			}
			
			array[index] = value;
			
			effectiveSize++;
			
		} else {
			
			
		}
		
	}
	
	
	
	public void insert(Double value) {// mutator
	// insert value at location effectiveSize.
		
		if(this.size() == this.arraySize())
			  this.grow();
		  array[effectiveSize++] = value;
		
	}
	
	public Double remove() { // mutator
	// return the removal of the value at location effectiveSize-1.
		Double num;
		
		if (this.size() > 0) {
			num = array[this.size()-1];
			effectiveSize = effectiveSize - 1;
			if(this.size() < this.arraySize()/2)
				this.shrink();
			
			
		} else {
			return Double.NaN;
			
		}
		
		return num;
		
	}
	
	public Double removeAt(int index) { // mutator
	// if 0 <= index < effectiveSize
	// move the necessary values backwards one as to
	// eliminate the value at the location index in array, adjust
	// effectiveSize appropriately, and return the value that
	// was at the location index .
	// Note: a shrink() may be necessary before return.
	// else
	// return Double.NaN
		Double num;
		
		if(index >= 0 && index <= this.size()-1) {
			
			num = array[index];
			effectiveSize = effectiveSize - 1;
			if(this.size() < this.arraySize()/2)
				this.shrink();
			
			int temp = index;
			
			//effectiveSize--;
			
			while (temp < this.size()) {
				array[temp] = array[temp + 1];
				temp++;
			}
			
			//effectiveSize--;
			
		

			
		} else {
			
			return Double.NaN;
				
		}
		
		return num;
			
	}
	
	public void printArray() { //accessor
	// prints the values of all occupied locations of the array to
	// the screen
		for(int i = 0 ; i < this.size(); ++i) {
			System.out.println("array.at(" + i + ") = " + this.at(i));
		}
		
	}
	
	public int indexOf(int start, Double value) {
	// return the smallest index (that is greater than or equal to start)
	// such that the Double at that index is equal to the given value
	// if no such index exists, return -1
		int location = -1;
	
		
		if(start < this.size()) {
		
			for(int i = start; i <= this.size() && location == -1; ++i) {
				if(value.equals(this.at(i)))
					location = i;
			}
		}
		
		return location;
		
	}
	
	public int indexOf(Double value) {
	// return the smallest index
	// such that the Double at that index is equal to the given value
	// if no such index exists, return -1
		int location = -1;
		
		//System.out.print(array[1]);
		//System.out.print(this.at(1) == value);
		
		location = this.indexOf(0, value);
		
		
		return location;
	}
}