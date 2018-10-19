import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class test {

	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		String fileName, openOption;
 
		System.out.print("Enter filename: ");
		fileName = stdIn.nextLine();
		System.out.print("Enter TRUNCATE_EXISTING or APPEND: ");
		openOption = stdIn.nextLine();
		
		try (BufferedWriter fileOut = Files.newBufferedWriter(
			Paths.get(fileName),
			Charset.defaultCharset(),
			StandardOpenOption.CREATE,
			StandardOpenOption.valueOf(openOption)))
		{
			System.out.println("Enter a line of text:");
			fileOut.write(stdIn.nextLine() + "\n");
		} // end try
		catch (Exception e)
		{
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	} // end main
	
	
}
