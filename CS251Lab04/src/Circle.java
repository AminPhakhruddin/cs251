public class Circle
{
  public final String units = "cm";
  private static int instanceCnt = 0;
  private double radius;
  public static final double PI = Math.PI;
  
  



  public static int getInstanceCnt()
  {
    return Circle.instanceCnt;
  }

  private static void setInstanceCnt(int insCnt)
  {
    Circle.instanceCnt = insCnt;
  }

  public Circle() //default constructor
  {
    this(1);
  }

  public Circle(double newRadius)	//specifying constructor
  {
    Circle.setInstanceCnt(Circle.getInstanceCnt() + 1);
    this.setRadius(newRadius);
  }

  public Circle(Circle guest)
  {
   this(guest.getRadius()); 
  }

  public double getRadius()
  {
    return this.radius;
  }

  private void setRadius(double radius)
  {
    if (radius >= 0)
      this.radius = radius;
    else
      this.setRadius();
  }

  public void resize(double newRadius)
  {
    this.setRadius(newRadius);
  }

  public Circle clone()
  {
    return new Circle(this.getRadius());
  }

  public boolean equals(Circle guest)
  {
    return guest.getRadius() == this.getRadius();
  }
  
  public double area(Circle guest) {
	  double area = (Math.pow(guest.getRadius(), 2)*PI);
	  
	  return area;
  }
  
  public void print()
  {
    System.out.print("The circle\'s radius is " +
    this.getRadius() + " " + this.units);
  }
  
  public void setRadius() {
	  this.radius = 0;
  }
  
}

