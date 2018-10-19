
public class MyInteger extends Number {

	private int data;
	
	public MyInteger() {
		super();
	}
	
	public MyInteger(int value) {
		super();
		this.setData(value);
	}
	
	protected void setData(int value)
	  {
	    this.data = value;
	    super.setSet(true);
	  }
	
	public int getData()
	  {
	    return this.data;
	  }
	
	public boolean equals(MyInteger guest)
	  {
	    return this.getData() == guest.getData();
	  }
	  
	 public String toString()
	  {
	    if (isSet())
	      return super.toString() + this.getData();
	    else
	      return super.toString();
	  }
	 
	 public Number division(Number guest)
	  {
	    double val;

	    if (guest instanceof MyInteger) {
	      val = this.getData() / ((MyInteger)guest).getData();
	    		int m = (int) val;
	    		return new MyInteger(m);
	    }
	    else
	    {
	      val = this.getData() / ((MyDouble)guest).getData();
	      return new MyDouble(val);
	    }
	  }
	  

}
