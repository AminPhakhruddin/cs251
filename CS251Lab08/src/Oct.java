
public class Oct extends Nat implements Mod8{
	public Oct() {
		
		super();
	
	}
	
	public Oct(int n) {
		super(n);
		
	}
	
	public Oct(Nat guest) {
		super(guest.getN());
	}
	
	protected void setN(int n)
	  {
	    super.setN(n%8);
	  }
	
	 public Oct clone()
	  {
	    
	    return new Oct(this); 
	  }
	 
	 public boolean equals(Object guest)
	  {
	    if ((guest == null) || !(guest instanceof Oct))
	      return false;
	    if (((Oct)guest).getN() != this.getN())
	      return false;
	    
	    return true;
	  }
	 
	 public void increment()
	  {
		 if(this.getN() < 7) {
			 this.setN(this.getN() + 1);
		 }
		 else
		 {
			 this.setN(0);
		 }
	  }
	  
	  void decrement()
	  {
	    if (this.getN() != 0)
	      this.setN(this.getN() - 1);
	    else if(this.getN() == 0)
	    	  this.setN(7);
	  }
	  
	  public Oct addition(Nat guest)
	  {
	    return new Oct(this.getN() + guest.getN());
	  }
	  
	  public Nat inverse(){
		  return new Oct(8-this.getN());
	  }
	 
	
}
