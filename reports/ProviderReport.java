package reports;

/**
 * @author Luke Hallenbeck
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import operator.Provider;

public class ProviderReport {
		
	// Constructor
	// Takes a given provider and writes all of their information to a text file in the provider report format.
	public ProviderReport (Provider provider) throws FileNotFoundException, UnsupportedEncodingException {
		
		//Creates a writer to write to text file
		PrintWriter writer = new PrintWriter("ProviderReport.txt", "UTF-8");
		
		//Writes all information to file.
		writer.println(provider.getProviderName());
		writer.println(provider.getProviderNumber());
		writer.println(provider.getProviderStreetAddress());
		writer.println(provider.getProviderCity());
		writer.println(provider.getProviderState());
		writer.println(provider.getProviderZIP());
		writer.println(provider.getProviderServices());
		writer.close();
	
		System.out.println(provider.getProviderName() + " Provider report generated." + "\n");
	}
	
	// Method to take report file, read it, and write contents to terminal
	public void printProviderReport() throws IOException {
		FileReader fr = new FileReader("ProviderReport.txt");
		int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)
 
            // Print all the content of a file
            System.out.print((char)i);
        fr.close();
	}
	
}
