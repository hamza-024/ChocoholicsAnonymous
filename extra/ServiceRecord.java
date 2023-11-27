package extra;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import operator.Member;
import operator.Provider;
import extra.ProviderDirectory;

/**
 * @author Christian Meraz-Santiago
 */

public class ServiceRecord {
    public ServiceRecord(Provider provider, Member member, ProviderService providerService, String comment) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("ServiceRecord.txt", "UTF-8");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        writer.println("Current date and time: " + formattedDateTime);
        writer.println("Date Service was provided: " + providerService.getServiceDate());
        writer.println("Provider Number: " + provider.getProviderNumber());
        writer.println("Member Number: " + member.getMemberNumber());
        writer.println("Service Code: " + providerService.getServiceCode());
        writer.println("Comments: " + comment);
        writer.close();
        System.out.println("Service Record Generated: ServiceRecord.txt");
    }
    
    public void printServiceRecord() throws IOException {
		FileReader fr = new FileReader("ServiceRecord.txt");
		int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)
 
            // Print all the content of a file
            System.out.print((char)i);
	}
}
