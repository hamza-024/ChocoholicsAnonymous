package extra;

import java.io.*;
import java.util.Hashtable;
/**
 * 
 * @author Christian Meraz-Santiago
 * The ProviderDirectory class. This class creates the text file of the provider directory.
 */
public class ProviderDirectory {
	
	public Hashtable<String, String> list;
	/**
	 * Creates a Hashtable with provider directory information.
	 */
	public ProviderDirectory() {
		list = new Hashtable<>();
		list.put("Dietician", "598470");
		list.put("Aerobics", "883948");
		list.put("Therapy", "123456");
		list.put("Physician", "567890");
	}
	/**
	 * Creates and writes the provider directory as a text file.
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void printProviderDirectory() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter directory = new PrintWriter("ProviderDirectory.txt", "UTF-8");
		directory.println("598470 : Session with dietitian");
		directory.println("883948 : Aerobics exercise session");
		directory.println("123456 : Therapy");
		directory.println("567890 : Visit with physician");
		directory.close();
		System.out.println("ProviderDirectory.txt Generated Successfully\n");
		
		System.out.println("598470 : Session with dietitian");
		System.out.println("883948 : Aerobics exercise session");
		System.out.println("123456 : Therapy");
		System.out.println("567890 : Visit with physician\n");
	}
}
