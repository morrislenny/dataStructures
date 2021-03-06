//Lenny Scott, Lab 1, Problem 3
public class CountSubstrings {
	/*
	Note: command line arguments do not work with bangs
	
	Tests: 
		""     , ""      -should print 0
		""     , "stuff" -should print 0
		"stuff", ""      -should print 0
		"s"    , "s"	 -should print 1
		"stuff", "stuff" -should print 1
		"stuff", "f"     -should print 2
		"stuff", "ff"    -should print 1
		"stuff", "fff"   -should print 0
		"sis"  , "s"     -should print 2
		
	*/
	
	// this makes stringInput visible to the entire class so it will be availible to test() and the recursive function
	static String stringInput; 
	static String scanningArgument; 
	public static int scannedResults;
	static boolean validationError;
	
	public static void main(String[] args) {
		// getting inputs from cd line
		stringInput = args[0];
		scanningArgument = args[1];
		
		// vailidate handles invalid inputs and passes off to scanString()
		vailidate();
		System.out.println(scannedResults);
		// test() TDD designed tests
		//tests();
	}
	/*
	Note: test() is now a shell of what it used to be. From test I was able to monitor
		every step of the code but due to validation constraints, I had to remove
		a lot of what it did and comment it out. Instead of printing from here,
		I am printing from iterate string :(
	*/
	public static void tests() {
		// pre tests
		System.out.println("the string you want me to scan through: " + stringInput);
		System.out.println("the string you want to search for: " + scanningArgument);
		System.out.println("the output from your search: " + scannedResults);
		// validation
		System.out.println("Validation Error: " + validationError);
	}
	
	public static void vailidate() {
		// handles invalid inputs
		if(stringInput.length() == 0 || scanningArgument.length() == 0) {
			scannedResults = 0;
			validationError = true;
		}
		else if(scanningArgument.length() > stringInput.length()) {
			scannedResults = 0;
			validationError = true;
		}
		else {
			iterateString();	
		}
	}
	
	public static void iterateString() {;
		for(int i = 0; i < stringInput.length(); i++) {
			if(stringInput.charAt(i) == scanningArgument.charAt(0)) {
				scannedResults += scanString(i, 0, i);	
			}
		}
	}
	
	public static int scanString(int stringPos, int searchPos, int firstStringPos) {		
		
		if((stringPos - firstStringPos) == scanningArgument.length() -1 && stringInput.charAt(stringPos) == scanningArgument.charAt(searchPos)) {
			// this has to be on top because if it is not tripped, there will be an arrayOutOfBounds exception
			return 1;
		}
		else if(stringInput.charAt(stringPos) != scanningArgument.charAt(searchPos)) {
			return 0;		
		}
		else if((stringInput.length() - firstStringPos) < scanningArgument.length()) {
			return 0;
		}
		return scanString(stringPos + 1, searchPos+1, firstStringPos);
	}
}
