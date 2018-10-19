
public class Driver
{
	public static void main(String[] args)
	{
		Salaries company = new Salaries();
		String file = "Salaries1.txt";
		String file2 = "Salaries2.txt";
		String file3 = "Salaries3.txt";
		String file4 = "Salaries4.txt";
		String file5 = "Salaries5.txt";
		
		company.create(file);
		company.create(file2);
		company.create(file3);
		company.create(file4);
		company.create(file5);
		
		//company.addTo(file, file2, 2, 50000, 5);
		//company.addTo(file, file2, 4, 40000, 4);
		company.addTo(file, file2, 5, 35000, 3);
		//company.addTo(file, file2, 8, 30000, 1);
		//company.addTo(file, file2, 10, 30000, 2);
		company.display(file2);
		
		company.removeFrom(file, file2, 5, 30000, 3);
		System.out.println();
		company.display(file2);
		
		company.raise(file, file3, 3, 0.15);
		System.out.println();
		company.display(file3);
		
		company.mergeFiles(file, file4, file5);
		System.out.println();
		company.display(file5);
	}
}

