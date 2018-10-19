import java.util.Scanner;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Files 
{
  public static void main(String[] args) 
  {
    String[] words = {"hello", "world", "and", "stuff"};
    String[] moreWords = {"the", "end"};
    Scanner stdIn = new Scanner(System.in);
    PrintWriter fileOut;
    String fileOutName;
    String appendName;
    String inFileName;
    
    BufferedWriter bw = null;
    
    try
    {
      System.out.print("Enter the file name for output: ");
      fileOutName = stdIn.next();
      
      fileOut = new PrintWriter(fileOutName);
      for (int i = 0; i < words.length; ++i)
        fileOut.println("words[" + i + "] = " + words[i]);
      fileOut.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File Error : " + e.getMessage());
    }
    

    try {
        // APPEND MODE SET HERE
    	
    		System.out.print("Enter the file name to append to: ");
        appendName = stdIn.next();
    		
        bw = new BufferedWriter(new FileWriter(appendName, true));
        for (int i = 0; i < moreWords.length; ++i)
        {
        		bw.write("moreWords[" + i + "] = " + moreWords[i]);
        		bw.newLine();
        }
        bw.close();
     } catch (IOException ioe) {
	 ioe.printStackTrace();
     } finally {                       // always close the file
	 if (bw != null) try {
	    bw.close();
	 } catch (IOException ioe2) {
	    // just ignore it
	 }
     } // end try/catch/finally
    
    String line;
    System.out.println("Enter the file name for input: ");
	inFileName = stdIn.next();
    try ( // use the auto close feature - try with resources
    		Scanner fileIn = new Scanner(Paths.get(inFileName)); 
        )
    {
      while ( fileIn.hasNextLine() )  // while the input file is not empty
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
    
    stdIn.close();

    
  }
}