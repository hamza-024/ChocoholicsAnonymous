package reports;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


import operator.Management;
/**
 * @author Luke Hallenbeck
 */

public class SummaryReport {
	
	// Constructor
	// Takes information from all providers in database and creates a summary report of all their information.
	public SummaryReport(Management accounts) throws FileNotFoundException, UnsupportedEncodingException {
		
		//Creates a writer to write to text file
		PrintWriter writer = new PrintWriter("SummaryReport.txt", "UTF-8");
		
		//Writes all information to file.
		writer.println(accounts.printProviders());
		writer.println(accounts.getNumProviders());
		writer.println(accounts.getTotalConsult());
		writer.println(accounts.getTotalFee());
		writer.close();
		
		System.out.println("Summary report generated." + "\n");
		
	}
	
	// Method to take report file, read it, and write contents to terminal
	public void printSummaryReport() throws IOException {
		FileReader fr = new FileReader("SummaryReport.txt");
		int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)
 
            // Print all the content of a file
            System.out.print((char)i);
        
        fr.close();
	}
	
}
