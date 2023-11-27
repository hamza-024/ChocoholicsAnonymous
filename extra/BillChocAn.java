package extra;
import java.io.*;
import java.util.*;
import java.util.Dictionary;
import java.util.Objects;
import java.util.Scanner;
import java.util.Hashtable;
import extra.ProviderService;
import operator.Member;
import operator.Provider;
import operator.Management;
import extra.ServiceRecord;
import extra.ProviderDirectory;
/**
* @author Mae Olsen
* The Bill ChocAn class. Verifies member and takes in service information to write service record and record provider service.
*/
public class BillChocAn{
	/**
	 * Performs the billing sequence.
	 * @param accountManagement to verify member and identify provider for logging purposes.
	 * @throws IOException 
	 */
	
	public static void billing(Management accountManagement) throws IOException{
		String memberID;
		int idNum;
		Scanner reader = new Scanner(System.in);
		
		//Verify member before billing
		System.out.println("Verify Member");
		System.out.println("Enter Member ID:");
		memberID = reader.nextLine();
		idNum = Integer.parseInt(memberID);
		boolean verified = verifyMember(idNum, accountManagement);
		
		/**
		 * Member is verified.
		 */
		if(verified) {

			int providerID;
			double fee;
			String date, userInput, time, memberName, serviceCode, serviceName, providerName;

			String comment = "";
			

			Provider provider;
			Member member;
			
			//Prompt for provider number
			System.out.println("Bill ChocAn:");
			System.out.println("Enter provider number:");
			providerID = Integer.parseInt(reader.nextLine());
			
			//Find provider
			provider = accountManagement.findProvider(providerID);
			/**
			 * Invalid provider number; Exit
			 */
			if (provider == null) {
				System.out.println("This is not a valid providerNumber");
				return;
			}
			
			//Find member
			member = accountManagement.findMember(idNum);
			/**
			 * Invalid member number; Exit
			 */
			if (member == null) {
				System.out.println("This is not a valid memberNumber");
				return;
			}
			
			//Prompt for date entry
			System.out.println("Enter date of service in MM-DD-YYYY format:");
			date = reader.nextLine();
			
			//Prompt for time entry
			System.out.println("Enter time of service in HH:MM:SS format:");
			time = reader.nextLine();
			
			//Prompt for service name entry. Find service code from Provider Directory.
			System.out.println("Choose one of the following services:");
			System.out.println("1 for Dietician\n2 for Aerobics\n3 for Therapy\n4 for Physician");
			serviceName = reader.nextLine();
			serviceCode = findServiceCode(serviceName);
			/**
			 * Returned service code did not exist in Provider Directory; Exit
			 */
			if(serviceCode == "Stop") {
				return;
			}
			
			//Prompt for optional comment entry
			System.out.println("Would you like to enter comments about the service provided? Answer 1 for yes or 2 to skip this step.");
			userInput = reader.nextLine();
			/**
			 * Opted for comments.
			 */
			if(userInput.equals("1")) {
				System.out.println("Enter comments:");
				comment = reader.nextLine();
			}
			/**
			 * Invalid response.
			 */
			else if(!userInput.equals("2")) {
				System.out.println("Not a valid option. No comments will be added.");
			}
			
			//Prompt for fee amount
			System.out.println("Enter fee amount:");
			String input = reader.nextLine();
			fee = Double.parseDouble(input);
			
			
			//add provider service
			ProviderService service = new ProviderService(date, time, member.getMemberName(), memberID, serviceCode, fee);
			
			//add service to provider's list
			provider.addProviderService(date, time, member.getMemberName(), memberID, serviceCode, fee);
			
			//add service to member's list
			member.addMemberService(date, provider.getProviderName(), serviceName);
			
			//write record
			ServiceRecord record = new ServiceRecord(provider, member, service, comment);
			record.printServiceRecord();
		}
		return;
	}
	/**
	 * @param serviceName to find service code in hash table
	 * @param reader to read user inputs
	 * @return String service code or to indicate end of billing sequence
	 */
	
	public static String findServiceCode(String serviceName) {
		/**
		 * Invalid response; Exit
		 */
		if(!serviceName.equals("1")&&!serviceName.equals("2")&&!serviceName.equals("3")&&!serviceName.equals("4")) {
			System.out.println("Invalid service option. Billing discontinued.");
			return "Stop";
		}
		
		if(serviceName.equals("1")) {
			serviceName = "Dietician";
		}
		else if(serviceName.equals("2")) {
			serviceName = "Aerobics";
		}
		else if(serviceName.equals("3")) {
			serviceName = "Therapy";
		}
		else if(serviceName.equals("4")) {
			serviceName = "Physician";
		}
		
		/**
		 * Search Provider Directory
		 */
		ProviderDirectory directory = new ProviderDirectory();
		String serviceCode = directory.list.get(serviceName);
		return serviceCode;
	}
	
	/**
	 * @param idNum to search for member
	 * @param accountManagement to access member information
	 * @return boolean representing whether member is verified or not
	 */
	public static boolean verifyMember(int idNum, Management accountManagement) {
		/**
		 * Member verified.
		 */
		if(accountManagement.findMember(idNum) != null) {
			System.out.println("Verified");
			return true;
		}
		/**
		 * Invalid ID was entered or member has been suspended due to late fees.
		 */
		else {
			System.out.println("Invalid ID or Member Suspended");
			return false;
		}
	}
}
