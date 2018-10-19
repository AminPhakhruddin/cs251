import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SalaryData implements raiseable {

	
	public void create(String fileName) {
		try
	    {
	      
	     PrintWriter fileOut = new PrintWriter(fileName);
	    }
	    catch (FileNotFoundException e)
	    {
	      System.out.println("File Error : " + e.getMessage());
	    }
	}


	public void display(String fileName) {
		String line;
		try ( // use the auto close feature - try with resources
	    		Scanner fileIn = new Scanner(Paths.get(fileName)); 
	        )
	    {
	      while ( fileIn.hasNextLine())  // while the input file is not empty
	      {
	        line = fileIn.nextLine(); // read a line from input file
	        System.out.println(line);    // write a line to the output file
	      }
	    }
	    catch (Exception e) // catch any exception that may be thrown
	    {
	      System.out.print("\n\n" + e.getClass() + " : ");
	      System.out.println(e.getMessage());
	    }
		
	}

	public boolean addTo(String inFileName, String outFileName, int id, double salary, int yearsOfService) {
		
		boolean addTo = false;
		boolean found = false;
		String line;
		int c1Index = -1;
		int c2Index = -1;
		int id1 = -1;
		double salary1;
		int yrs1;
		
		try( 
			PrintWriter fileOut = new PrintWriter(outFileName);
			Scanner fileIn = new Scanner(Paths.get(inFileName));
				)
	    {
	      
	      if(!fileIn.hasNextLine()) {
	    	  	fileOut.println(id + salary + yearsOfService);
	      }
	     
	      fileOut.close();
	    }
	    catch (FileNotFoundException e)
	    {
	      System.out.println("File Error : " + e.getMessage());
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
		
	return addTo;
	}
	

	
	public boolean removeFrom(String inFileName, String outFileName, int id, double salary, int yearsOfService) {
		
		return false;
	}


	public int raise(String inFileName, String outFileName, int yearsOfService, double salaryIncPercent) {
		return 0;
	}


	public void mergeFiles(String inFileName1, String inFileName2, String outFileName) {
		String line1;
		String line2;
		int c1Index = -1;
		int c2Index = -1;
		int c3Index = -1;
		int c4Index = -1;
		int id1 = -1;
		int id2 = -1;
		double salary1;
		double salary2;
		int yrs1;
		int yrs2;

		
		try (
			Scanner fileIn1 = new Scanner(Paths.get(inFileName1));
			Scanner fileIn2 = new Scanner(Paths.get(inFileName2));
			PrintWriter fileOut = new PrintWriter( new FileWriter(outFileName, true));
			)
		{
				
				while(fileIn1.hasNextLine() || fileIn2.hasNextLine()) {
					
					line1 = fileIn1.nextLine();
	        			c1Index = line1.indexOf(":");
	        			c2Index = line1.lastIndexOf(":");
	        			id1 = Integer.parseInt(line1.substring(0, c1Index));
	        			salary1 = Double.parseDouble(line1.substring(c1Index + 1, c2Index));
		        		yrs1 = Integer.parseInt(line1.substring(c2Index+1));
	        			
	        			line2 = fileIn2.nextLine();
	        			c3Index = line2.indexOf(":");
	        			c4Index = line2.lastIndexOf(":");
	        			id2 = Integer.parseInt(line2.substring(0, c3Index));
	        			salary2 = Double.parseDouble(line2.substring(c1Index + 1, c4Index));
		        		yrs2 = Integer.parseInt(line2.substring(c4Index+1));
	        			
	        			if(id1 < id2) {
	        				fileOut.println(line1);
	        			}else if(id2 > id1) {
	        				fileOut.println(line2);
	        			}else if(id1 == id2) {
	        				if(salary1 < salary2) {
	        					fileOut.println(line1);
	        				} else if(salary1 > salary2) {
	        					fileOut.println(line2);
	        				} 
	        			}
				}
				
			fileOut.close();
		}catch (Exception e)
		{
			 System.out.print("\n\n" + e.getClass() + " : ");
		      System.out.println(e.getMessage());
		}
	}


}
