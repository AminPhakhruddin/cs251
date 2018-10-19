package pg8Solution;

public class pg8Solution {
	  public static void main(String[] args)
	  {
	    Scanner stdIn = new Scanner(System.in);
	    
	    // display the welcome / instructions
	    welcome();
	  
	    // the three Player dice
	    int pd1;
	    int pd2;
	    int pd3;
	    
	    // the three opponent dice
	    int od1;
	    int od2;
	    int od3;
	    
	    // keep track of results
	    int wins = 0;
	    int loses = 0;
	    int ties = 0;
	 
	    // play again response
	    String pa;
	    do
	    {
	      // roll the Player's dice
	      pd1 = rollDie();
	      pd2 = rollDie();
	      pd3 = rollDie();
	      
	      // display the Player's dice roll
	      displayRoll("   Player", pd1, pd2, pd3);

	      
	      // roll the Opponent's dice
	      od1 = rollDie();
	      od2 = rollDie();
	      od3 = rollDie();
	      
	      // display the Opponent's dice roll
	      displayRoll("  Opponent", od1, od2, od3);

	      
	      // determine outcome
	      int outcome = roundOutcome(pd1, pd2, pd3, od1, od2, od3);
	      
	      
	      // display and tally outcome
	      if ( outcome == 1 )
	      {
	        ++wins;
	        System.out.println("Congrats, you win!");        
	      }
	      else if ( outcome == 0 )
	      {
	        ++ties;
	        System.out.println("Its a push!");
	      }
	      else // outcome == -1
	      {
	        ++loses;
	        System.out.println("Sorry, you lose!");
	      }
	      System.out.println();
	      
	      // play again question / answer
	      do
	      {
	        System.out.print("Do you wish to play again [y, n] : ");
	        pa = stdIn.next();
	      } while (!(pa.equalsIgnoreCase("y") || pa.equalsIgnoreCase("n")));

	      System.out.println("\n");

	    } while (pa.equalsIgnoreCase("y"));

	    // display final report
	    report(wins, ties, loses);  
	    
	    stdIn.close();
	  }

	  
	  //displays a brief accounting of the rules and format of the game
	  public static void welcome()
	  {
	    System.out.println();
	    System.out.println();
	    System.out.println("                Welcome to opponent Dice");
	    System.out.println("---------------------------------------------------------");
	    System.out.println("You will be playing dice against the opponent");
	    System.out.println();
	    System.out.println("High beats low, and same ties");
	    System.out.println("Triples beat Straights, Pairs and Junk");
	    System.out.println("Straights beat Pairs and Junk");
	    System.out.println("Pairs beat Junk");
	    System.out.println("In the case of two identical Pairs - high card decides");
	    System.out.println("in the case of two Nothings - its a tie");
	    System.out.println("---------------------------------------------------------");
	    System.out.println();
	    System.out.println();
	  }

	  //returns a randomly selected int in the set {2, 3, 5, 7}
	  public static int rollDie()
	  {
	    String vals = "2357";
	    return vals.charAt( (int)(Math.random() * 4) ) - '0';
	  }

	  // display dice
	  public static void displayRoll(String header, int d1, int d2, int d3)
	  {
	    System.out.println(header);
	    System.out.println("------------");
	    System.out.print("  " + d1 + "  " + d2 + "  " + d3);
	    System.out.print("\n\n");
	  }
	  
	  //returns true only when triple
	  public static boolean isTriple(int d1, int d2, int d3)
	  {
	    return (d1 == d2) && (d2  == d3) ;
	  }

	  //returns true only when pair
	  public static boolean isPair(int d1, int d2, int d3)
	  {
	    return (d1 == d2) || (d1 == d3) || (d2 == d3) && !isTriple(d1, d2, d3);
	  }

	  //returns true only when straight
	  public static boolean isStraight(int d1, int d2, int d3)
	  {
	    int roll = d1 * d2 * d3; 
	    return (roll % (2*3*5) == 0) || (roll % (3*5*7) == 0); 
	  }

	  public static int reduceRoll(int d1, int d2, int d3)
	  {
	    if ( isTriple(d1, d2, d3) )
	      return 1000 * d1;
	    else if ( isStraight(d1, d2, d3) )
	      return 10 * d1 * d2 * d3;
	    else if ( isPair(d1, d2, d3) )
	    {
	      if ( (d1 == d2) )
	        return 10 * d1 + d3;
	      else if (d1 == d3)
	        return 10 * d1 + d2;
	      else
	        return 10 * d2 + d1;
	    }
	    return 0;
	  }
	  
	  //returns true only when pair
	  public static int roundOutcome (int p1, int p2, int p3, int o1, int o2, int o3)
	  {
	    int playerRoll = reduceRoll(p1, p2, p3);
	    int opponentRoll = reduceRoll(o1, o2, o3);

	    if ( playerRoll > opponentRoll )
	      return 1;
	    else if ( playerRoll == opponentRoll )
	      return 0;
	    else // ( playerRoll < opponentRoll )
	      return -1;
	  }
	  
	  //displays a report of the game's outcomes to the screen
	  public static void report(int wins, int ties, int loses)
	  {
	    System.out.println();
	    System.out.println("opponent Dice Results");
	    System.out.println("---------------------");
	    System.out.println("You played " + (wins + ties + loses) + " rounds");
	    System.out.println();
	    System.out.println("Rounds won\t:" + wins);
	    System.out.println("Rounds tied\t:" + ties);
	    System.out.println("Rounds lost\t:" + loses);
	    System.out.println("---------------------");
	    System.out.println();    
	  }
}
