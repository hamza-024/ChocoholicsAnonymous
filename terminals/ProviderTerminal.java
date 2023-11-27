package terminals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Objects;
import java.util.Scanner;

import operator.Provider;
import operator.Management;
import operator.Member;
import extra.BillChocAn;
import extra.ProviderDirectory;
import extra.ProviderService;
import extra.ServiceRecord;
/**
 * @author Christian Meraz-Santiago
 */
public class ProviderTerminal{
	boolean verified = false;
	private int providerID = 0;
	
	//Default Constructor
	public ProviderTerminal(){
	}
	
	public void runTerminal(Dictionary userAccounts, Management accountManagement, Scanner reader) throws IOException {
		boolean verified = false;
//		ArrayList<ProviderService> providerServices = new ArrayList<>();
		
		while(true) {
			System.out.println("Provider Terminal");
			System.out.println("Enter [1] for login.");
			System.out.println("Enter [2] to quit.");
			String loginInput = reader.nextLine();
			
			//Option [1] login
			if(loginInput.equals("1")) {
				verified = verifyProvider(userAccounts, reader);
				if(verified) {
					System.out.println("Provider Verified");
					break;
				}
			}
			//Option [2] quit
			else if (loginInput.equals("2")) {
				System.out.println("Thank you for using ChocAn!");
				break;
			}
			//Invalid Input
			else {
				System.out.println("Invalid Input, please try again.");
			}
		}
		//Verified provider menu
		if(verified) {
			while(true) {
				//TEMP: IF we need another one, create one, we probably will for add service record so create a [4]!
				System.out.println("Provider Terminal");
				System.out.println("Enter [1] to request provider directory.");
				System.out.println("Enter [2] to bill ChocAn.");
				System.out.println("Enter [3] to add/view services.");
				System.out.println("Enter [4] to exit.");
				String menuInput = reader.nextLine();
				//[1] Provider Directory
				if(menuInput.equals("1")) {
					getProviderDirectory();
				}
				//[2] Bill ChocAn
				else if(menuInput.equals("2")) {
					BillChocAn billChocAn = new BillChocAn();
					billChocAn.billing(accountManagement);
				}
				//[3]Service Record
				else if(menuInput.equals("3")) {
					while(true) {
						System.out.println("Enter [1] to view service record.");
						System.out.println("Enter [2] to add service.");
						System.out.println("Enter [3] to exit.");
						String serviceInput = reader.nextLine();
						//[3.1] View service record
						if(serviceInput.equals("1")) {
							System.out.println("For which provider do you want to view services?");
							accountManagement.printProvider();
							String num = reader.nextLine();
							int ID = Integer.parseInt(num);
							System.out.println(accountManagement.findProvider(ID).getProviderServices());	
						}
						//[3.2] Add Service
						else if(serviceInput.equals("2")) {
							System.out.println("For which provider do you want to view services?");
							accountManagement.printProvider();
							String num = reader.nextLine();
							int ID = Integer.parseInt(num);
							System.out.println("Input date of service (MM-DD-YYYY):");
							String addDateInput = reader.nextLine();
							System.out.println("Input time of service: ");
							String addTimeInput = reader.nextLine();
							System.out.println("Input Member name: ");
							String addMemberNameInput = reader.nextLine();
							System.out.println("Input Member number: ");
							String addMemberNumInput = reader.nextLine();
							System.out.println("Input service code: ");
							String addServiceCodeInput = reader.nextLine();
							System.out.println("Input fee to be paid (Number): ");
							String addFeeInput = reader.nextLine();
							double addFeeInputDouble = Double.parseDouble(addFeeInput);
							accountManagement.findProvider(ID).addProviderService(addDateInput, addTimeInput, addMemberNameInput, addMemberNumInput, addServiceCodeInput,addFeeInputDouble);
							System.out.println("Service added.");
//							providerServices.add(new ProviderService(addDateInput, addTimeInput, addMemberNameInput, addMemberNumInput, addServiceCodeInput, addFeeInputDouble));
						}
						//[3.3] Exit -> return to provider terminal
						else if(serviceInput.equals("3")) {
							break;
						}
						//Invalid Input
						else {
							System.out.println("Invalid input, please try again");
						}
					}
				}
				//[4]Exit -> return to main terminal
				else if(menuInput.equals("4")) {
					break;
				}
				//Invalid Input
				else {
					System.out.println("Invalid input, please try again");
				}
			}
		}
	}

	//Verifies Provider
	public boolean verifyProvider(Dictionary userAccounts, Scanner reader) {
		//Ask Provider to enter ID and password for verification
		System.out.println("Provider Login");
		System.out.println("Enter ID: ");
		String ID = reader.nextLine();
		System.out.println("Enter password: ");
		String password = reader.nextLine();
		
		if(Objects.equals(userAccounts.get(ID), password)) {
			return true;
		}
		else{
			System.out.println("Invalid ID or Password.");
			return false;
		}
	}
	
	
	//Creates a copy of the provider directory as a text file
	public void getProviderDirectory() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		ProviderDirectory providerDirectory = new ProviderDirectory();
		providerDirectory.printProviderDirectory();
	}
}