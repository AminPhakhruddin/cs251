public class Circle
{
  private double radius;
  private static int count = 0;


  public double getRadius()
  {
    return this.radius;
  }

  private void setRadius(double radius)
  {
    if (radius >= 0)
      this.radius = radius;
    else
      this.radius = 0;
  }

  public void resize(double newRadius)
  {
    this.setRadius(newRadius);
  }

  public boolean equals(Circle guest)
  {
    return guest.getRadius() == this.getRadius();
  }
  
  public void print()
  {
    System.out.print("The circle\'s radius is " +
    this.getRadius());
  }
  
  
  public Circle()
  {
    //this.setValue(0);
    this(0); // just call specifying constructor
  }
  
  public Circle(double radius)
  {
    this.setRadius(radius);
    this.setCount(count + 1);
  }
  
  //copy constructor
  public Circle(Circle guest)
  {
    //this.setValue(guest.getValue());
    this(guest.getRadius()); // just call specifying constructor
  }
  
  public Circle clone()
  {
    
    return new Circle(this); // use copy constructor
    //resize???
  }

public static int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}
  
}
