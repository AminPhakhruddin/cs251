import java.util.Scanner;

public class TestScore
{
  public static void main(String[] args)
  {
     Scanner stdIn = new Scanner(System.in);
     String scoreStr; //user entry
     boolean valid = false;
     double score = -1;
     
     System.out.print("Please enter a test score [0, 100] : ");
     scoreStr = stdIn.next();
     do
     {
    	 	
 		try
 		{
 		    //System.out.print("Please enter a test score [0, 100] : ");
 			//valid = false;
 			score = Double.parseDouble(scoreStr);
 			//valid = true;fr
 			
 			if (!(score >= 0 && score <= 100))
 			{
 				System.out.print("Please enter a test score [0, 100] : ");
 				scoreStr = stdIn.next();
 				//valid = false;
 			}
 			else {
 				valid = true;
 			}

 		}
 		catch (NumberFormatException nfe)
 		{
 			System.out.print("Please enter a numeric test score: ");
 			scoreStr = stdIn.next();
 		}



     } while (!valid);
     
     
     System.out.println("The valid score entered was " + score);
  }
}

