
public class Queue extends DynArray{
	private int size;
	
	public Queue() {
		super();
		this.size = 0;
	}
	
	public int size() {
	// returns the number of values which are currently in the queue
		return this.size;
	}
	
	public boolean isEmpty() {
	// returns true only if there are no values in the queue
		boolean isEmpty = false;
		if (this.size() == 0) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	public void que(Double value) {
	// add the specified value into the queue
		super.insert(value);
		this.size++;
	}
	
	public Double deQue() {
	// if the queue is not empty,
	// remove and returns the least currently que’d value in the queue
	// otherwise,
	// returns Double.NaN
		Double deQue;
		if (!this.isEmpty()) {
			deQue = super.removeAt(0);
			this.size--;
		}
		else {
			deQue = Double.NaN;
		}
		
		return deQue;
	}
	
	public void queueDump() {
	// print all of the values currenty in the queue, in the order that
	// they would be deQue’d from the queue
		for(int i = 0; i<=this.size()-1; i++) {
			System.out.println("array.at(" + i +  ") = " + super.at(i));
		}	
	}
}
