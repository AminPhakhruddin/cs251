interface Raiseable
{
	// Creates a new (empty) file that can later be used to add entries of the above
	// format
	void create(String fileName);
	// Formats and displays the contents of the specified file to the screen
	void display(String fileName);
	// Creates a new file that is a copy of the given input file - with the new
	// entry added such that the new file is sorted by the entriesí ids
	// Return true if no match was found and the entry was added; false if a duplicate id
	boolean addTo(String inFileName, String outFileName, int id, double salary,
			int yearsOfService);
	// Creates a new file that is a copy of the given input file - with the specified
	// entry removed
	// Returns true if a matching entry was found / removed; false if no such entry exists
	boolean removeFrom(String inFileName, String outFileName, int id, double salary,
			int yearsOfService);
	// Creates a new file that is a copy of the given input file - where all entries whose
	// years of service are greater than or equal to yearsOfService have had their salaries
	// increased by salaryIncPercent
	// Return the number of entries that the raise was applied to
	int raise(String inFileName, String outFileName, int yearsOfService,
			double salaryIncPercent);
	// Creates a new file that is a sorted merge of the two given (sorted) input files
	// In case of duplicate entries, only the one with the highest salary is kept in
	// outFileName
	void mergeFiles(String inFileName1, String inFileName2, String outFileName);
}