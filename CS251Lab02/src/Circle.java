
public class Circle {
	
	private double radius = 1;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius > 0)
			this.radius = radius;
	}
	
	public void resize(double newRadius) {
		
			this.setRadius(newRadius);
	}
	
	public Circle clone(){
	    
	    Circle circle = new Circle();
	    circle.setRadius( this.getRadius());
	    return circle;
	}
	  
	
	public boolean equals(Circle guest) {
		
		return this.getRadius() == guest.getRadius();
	
	}
	
	public void print() {
		
		System.out.println("The radius of the circle is: " + this.getRadius());
	}
	
	

}
