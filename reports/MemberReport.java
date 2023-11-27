package reports;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import operator.Member;
/**
 * @author Luke Hallenbeck
 */
public class MemberReport {
	
	// Constructor
	// Takes a given member and writes all of their information to a text file in the member report format.
	public MemberReport(Member member) throws FileNotFoundException, UnsupportedEncodingException{
		
		//Creates a writer to write to text file
		PrintWriter writer = new PrintWriter("MemberReport.txt", "UTF-8");
		
		//Writes all information to file.
		writer.println(member.getMemberName());
		writer.println(member.getMemberNumber());
		writer.println(member.getMemberStreetAddress());
		writer.println(member.getMemberCity());
		writer.println(member.getMemberState());
		writer.println(member.getMemberZIP());
		writer.println(member.getMemberServices());
		writer.close();
	
		System.out.println(member.getMemberName() + " Member report generated." + "\n");
	}
	
	// Method to take report file, read it, and write contents to terminal
	public void printMemberReport() throws IOException {
		FileReader fr = new FileReader("MemberReport.txt");
		int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)
 
            // Print all the content of a file
            System.out.print((char)i);
        
        fr.close();
	}
	
}
