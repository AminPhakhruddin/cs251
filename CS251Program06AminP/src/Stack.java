
public class Stack extends DynArray {
	private int size;
	
	public Stack() {
		super();
		this.size = 0;
	}
	
	public int size() {
	// returns the number of values which are currently on the stack}
		return this.size;
	}
	
	public boolean isEmpty() {
	// returns true only if there are no values on the stack
		boolean isEmpty = false;
		if (this.size() == 0)
			isEmpty = true;
		return isEmpty;
	}
	
	public void push(Double value) {
	// add the specified value onto the stack
		super.insert(value);
		this.size++;
		
	}
	
	public Double pop() {
	// if the stack is not empty,
	// remove and returns the most currently push’d value on the stack
	// otherwise,
	// returns Double.NaN
		Double pop;
		if (!this.isEmpty()) {
			pop = super.remove();
			this.size--;
		}
		else {
			pop = Double.NaN;
		}
		
		return pop;
	}
	
	public void stackDump() {
		// print all of the values currenty on the stack, in the order that
		// they would be pop’d off of the stack
		for(int i = this.size()-1; i>=0; i--) {
			System.out.println(super.at(i));
		}	
	}
}
