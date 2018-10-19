import java.util.ArrayList;

public class Org {
	
	private String name;
	  private Leader leader;
	  private ArrayList<Member> members;
	  
	  public Org()
	  {
	    this("", "", 0);
	  }
	  
	  public Org(String sName, String pName, int term)
	  {
	    this.setName(sName);
	    this.leader = new Leader(pName, term);
	    this.members = new ArrayList<Member>();
	  }
	  
	  private void setName(String name)
	  {
	    this.name = name;
	  }
	  
	  public String getName()
	  {
	    return this.name;
	  }
	  
	  public void addStudent(Member member)
	  {
	    this.members.add(member);
	  }
	  
	  public void orgAudit()
	  {
	    System.out.println("Organization\'s Name: " + this.getName());
	    System.out.println("\tLeader\'s Name: " + this.leader.toString());
	    for (Member member : members )
	      System.out.println("\t\t" + member.toString());
	  }

}
