

public class Student extends Person 
{
  private double gpa;
  
  public Student()
  {
    super();
    this.gpa = 4.0;
  }

  public Student(String name, double gpa)
  {
    super(name);
    this.gpa = gpa;
  }
  
  public double getGpa()
  {
    return this.gpa;
  }
  
  public String toString()
  {
    return  super.toString() + " : " + this.getGpa();
  }
}

