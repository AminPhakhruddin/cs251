import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class Salaries implements Raiseable
{
	// Creates a new (empty) file that can later be used to add entries of the above
	// format
	public void create(String fileName)
	{
		File file = new File(fileName);
		try
		{
			file.createNewFile();
		}
		catch(IOException e)
		{
			System.out.print("\n" + e.getClass() + " : ");
			System.out.println(e.getMessage());
		}
		
		
	}
	
	// Formats and displays the contents of the specified file to the screen
	public void display(String fileName)
	{
		try(Scanner fileRead = new Scanner(Paths.get(fileName));)
		{
			while (fileRead.hasNextLine())
			{
				String line = fileRead.nextLine();
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.out.print("\n" + e.getClass() + " : ");
			System.out.println(e.getMessage());
		}
	}
	
	// Creates a new file that is a copy of the given input file - with the new
	// entry added such that the new file is sorted by the entriesí ids
	// Return true if no match was found and the entry was added; false if a duplicate id
	public boolean addTo(String inFileName, String outFileName, int id, double salary, int yearsOfService)
	{
		boolean placed = false;
		boolean unique = true;
		try(Scanner fileRead = new Scanner(Paths.get(inFileName)); PrintWriter p = new PrintWriter(outFileName))
		{
			while (fileRead.hasNextLine())
			{
				String line = fileRead.nextLine();
				int n = line.indexOf(":");
				String oldIdS = line.substring(0, n);
				int oldId = Integer.parseInt(oldIdS);
				if (placed == false)
				{
					if (oldId < id)
					{
						p.println(line);
					}
					else if (oldId == id)
					{
						p.println(line);
						placed = true;
						unique = false;
					}
					else
					{
						p.println(id + ":" + salary + ":" + yearsOfService);
						placed = true;
						p.println(line);
					}
				}
				else
				{
					p.println(line);
				}
			}
			if (placed == false)
			{
				p.println(id + ":" + salary + ":" + yearsOfService);
				placed = true;
			}
		}
		catch(IOException e)
		{
			System.out.print("addTo Error");
			System.out.print("\n" + e.getClass() + " : ");
			System.out.println(e.getMessage());
		}
		return unique;
	}
	
	// Creates a new file that is a copy of the given input file - with the specified
	// entry removed
	// Returns true if a matching entry was found / removed; false if no such entry exists
	public boolean removeFrom(String inFileName, String outFileName, int id, double salary, int yearsOfService)
	{
		boolean removed = false;
		boolean match = false;
		try(Scanner fileRead = new Scanner(Paths.get(inFileName)); PrintWriter p = new PrintWriter(outFileName))
		{
			while (fileRead.hasNextLine())
			{
				String line = fileRead.nextLine();
				int n = line.indexOf(":");
				String oldIdS = line.substring(0, n);
				int oldId = Integer.parseInt(oldIdS);
				int m = line.indexOf(":", n+1);
				String oldSalS = line.substring(n+1, m);
				double oldSal = Double.parseDouble(oldSalS);
				String oldYearS = line.substring(m+1);
				int oldYear = Integer.parseInt(oldYearS);
				if (removed == false)
				{
					if (oldId == id && oldSal == salary && oldYear == yearsOfService)
					{
						removed = true;
						match = true;
					}
					else
					{
						p.println(line);
					}
				}
				else
				{
					p.println(line);
				}
			}
		}
		catch(IOException e)
		{
			System.out.print("addTo Error");
			System.out.print("\n" + e.getClass() + " : ");
			System.out.println(e.getMessage());
		}
		return match;
	}
	
	// Creates a new file that is a copy of the given input file - where all entries whose
	// years of service are greater than or equal to yearsOfService have had their salaries
	// increased by salaryIncPercent
	// Return the number of entries that the raise was applied to
	public int raise(String inFileName, String outFileName, int yearsOfService, double salaryIncPercent)
	{
		int raises = 0;
		try(Scanner fileRead = new Scanner(Paths.get(inFileName)); PrintWriter p = new PrintWriter(outFileName))
		{
			while (fileRead.hasNextLine())
			{
				String line = fileRead.nextLine();
				int n = line.indexOf(":");
				int m = line.indexOf(":", n+1);
				String oldYearS = line.substring(m+1);
				int oldYear = Integer.parseInt(oldYearS);
				if (yearsOfService <= oldYear)
				{
					String oldSalS = line.substring(n+1, m);
					double oldSal = Double.parseDouble(oldSalS);
					double newSal = oldSal * (1 + salaryIncPercent);
					String id = line.substring(0, n);
					p.println(id + ":" + newSal + ":" + oldYear);
				}
				else
				{
					p.println(line);
				}
			}
		}
		catch(IOException e)
		{
			System.out.print("addTo Error");
			System.out.print("\n" + e.getClass() + " : ");
			System.out.println(e.getMessage());
		}
		return raises;
	}
	
	// Creates a new file that is a sorted merge of the two given (sorted) input files
	// In case of duplicate entries, only the one with the highest salary is kept in
	// outFileName
	public void mergeFiles(String inFileName1, String inFileName2, String outFileName)
	{
		try(Scanner fileRead1 = new Scanner(Paths.get(inFileName1)); Scanner fileRead2 = new Scanner(Paths.get(inFileName2)); 
			PrintWriter p = new PrintWriter(outFileName))
		{
			int id1 = 0;
			int id2 = 0;
			String line1 = "";
			String line2 = "";
			while (fileRead1.hasNextLine() &&  fileRead2.hasNextLine())
			{
				if (id1 == id2)
				{
					line1 = fileRead1.nextLine();
					line2 = fileRead2.nextLine();
				}
				else if (id1 < id2)
				{
					line1 = fileRead1.nextLine();
				}
				else if (id1 > id2)
				{
					line2 = fileRead2.nextLine();
				}
				
				int n1 = line1.indexOf(":");
				String ids1 = line1.substring(0, n1);
				id1 = Integer.parseInt(ids1);
				
				int n2 = line2.indexOf(":");
				String ids2 = line2.substring(0, n2);
				id2 = Integer.parseInt(ids2);
				
				if (id1 < id2)
				{
					p.println(line1);
				}
				else if (id1 > id2)
				{
					p.println(line2);
				}
				else
				{
					int m1 = line1.indexOf(":", n1+1);
					String sals1 = line1.substring(n1+1, m1);
					double sal1 = Double.parseDouble(sals1);
					
					int m2 = line2.indexOf(":", n2+1);
					String sals2 = line2.substring(n2+1, m2);
					double sal2 = Double.parseDouble(sals2);
					
					if (sal1 > sal2)
					{
						p.println(line1);
					}
					else if (sal1 < sal2)
					{
						p.println(line2);
					}
					else
					{
						String years1 = line1.substring(m1+1);
						int year1 = Integer.parseInt(years1);
						
						String years2 = line1.substring(m2+1);
						int year2 = Integer.parseInt(years2);
						
						if (year1 > year2)
						{
							p.println(line1);
						}
						else if (year1 < year2)
						{
							p.println(line2);
						}
						else
						{
							p.println(line1);
						}
					}
				}
				
			}
			int i = 0;
			while(fileRead1.hasNextLine())
			{
				if (i == 0)
				{
					p.println(line1);
					++i;
				}
				line1 = fileRead1.nextLine();
				p.println(line1);
			}
			while(fileRead2.hasNextLine())
			{
				if (i == 0)
				{
					p.println(line1);
					++i;
				}
				line2 = fileRead2.nextLine();
				p.println(line2);
			}
		}
		catch(IOException e)
		{
			System.out.print("addTo Error");
			System.out.print("\n" + e.getClass() + " : ");
			System.out.println(e.getMessage());
		}
	}
}
