package terminals;

import java.util.Dictionary;
import java.util.Objects;
import java.util.Scanner;

import operator.Management;
/**
 * @author Sam Kwon
 * The OperatorTerminal class. This class provides a way for the operator to complete their
 * designated tasks including add/delete/update providers and members
 */
public class OperatorTerminal {
	/**
	 * Runs the operator terminal
	 * @param userAccounts for login
	 * @param accountManagement for managing status of providers and members
	 * @param reader for reading user input
	 */
	public void runTerminal(Dictionary userAccounts, Management accountManagement, Scanner reader) {
		boolean verified = false;
		while (true) {
			System.out.println("Operator Terminal");
			System.out.println("Enter [1] for login");
			System.out.println("Enter [2] to exit");
			String l = reader.nextLine();
			if (l.equals("1")) {
				/**
				 * Verify operator
				 */
				verified = verifyOperator(userAccounts, reader);
				if (verified) {
					System.out.println("Operator validated");
					break;
				}
			}
			else if (l.equals("2")) {
				/**
				 * Exit
				 */
				break;
			}
			else {
				/**
				 * Invalid option
				 */
				System.out.println("That is an invalid option, please try again: ");
			}
		}
			
		if (verified) {
			while (true) {
				System.out.println("Operator Terminal");
				System.out.println("Enter [1] for member management");
				System.out.println("Enter [2] for provider management");
				System.out.println("Enter [3] to exit");
				System.out.println("Enter an option: ");
				String s = reader.nextLine();
				
				if (s.equals("1")) {
					/**
					 * Enter member management
					 */
					while (true) {
						System.out.println("Member Management");
						System.out.println("Enter [1] to add member");
						System.out.println("Enter [2] to delete member");
						System.out.println("Enter [3] to update member");
						System.out.println("Enter [4] to exit");
						System.out.println("Enter an option: ");
						String string = reader.nextLine();
						
						if (string.equals("1")) {
							/**
							 * Add member
							 */
							System.out.println("Add member");
							System.out.println("Member Name: ");
					        String name = reader.nextLine();
					        System.out.println("Member Number: ");
					        int number = Integer.parseInt(reader.nextLine());
					        System.out.println("Member Street Address: ");
					        String address = reader.nextLine();
					        System.out.println("Member City: ");
					        String city = reader.nextLine();
					        System.out.println("Member State (Postal Code): ");
					        String state = reader.nextLine();
					        System.out.println("Member Zip Code: ");
					        int zip = Integer.parseInt(reader.nextLine());
							accountManagement.addMember(number, name, address, city, state, zip);
							System.out.println("Member added");
						}
						else if (string.equals("2")) {
							/**
							 * Delete member
							 */
							System.out.println("Delete member");
							System.out.println("Enter memberNumber to delete: ");
							accountManagement.printMember();
					        int number = Integer.parseInt(reader.nextLine());
					        if (accountManagement.deleteMember(number)) {
					        	System.out.println("Member deleted");
					        }
					        else {
					        	System.out.println("memberNumber not found. Member not deleted.");
					        }
						}
						else if (string.equals("3")) {
							/**
							 * Edit member
							 */
							System.out.println("Update member");
							System.out.println("Member Number to Update: ");
							accountManagement.printMember();
					        int number = Integer.parseInt(reader.nextLine());
					        if (accountManagement.getMembers().containsKey(number) == false) {
					        	System.out.println("memberNumber not found. Member not updated.");
					        	continue;
					        }
							System.out.println("Member Name: ");
					        String name = reader.nextLine();
					        System.out.println("Member Street Address: ");
					        String address = reader.nextLine();
					        System.out.println("Member City: ");
					        String city = reader.nextLine();
					        System.out.println("Member State (Postal Code): ");
					        String state = reader.nextLine();
					        System.out.println("Member Zip Code: ");
					        int zip = Integer.parseInt(reader.nextLine());
							accountManagement.updateMember(number, name, address, city, state, zip);
							System.out.println("Member updated");
						}
						else if (string.equals("4")) {
							/**
							 * Exit
							 */
							break;
						}
						else {
							/**
							 * Invalid option
							 */
							System.out.println("That is an invalid option, please try again: ");
						}
					}
				}
				else if (s.equals("2")) {
					/**
					 * Enter provider management
					 */
					while (true) {
						System.out.println("Provider Management");
						System.out.println("Enter [1] to add provider");
						System.out.println("Enter [2] to delete provider");
						System.out.println("Enter [3] to update provider");
						System.out.println("Enter [4] to exit");
						System.out.println("Enter an option: ");
						String string = reader.nextLine();
						
						if (string.equals("1")) {
							/**
							 * Add provider
							 */
							System.out.println("Add provider");
							System.out.println("Provider Name: ");
					        String name = reader.nextLine();
					        System.out.println("Provider Number: ");
					        int number = Integer.parseInt(reader.nextLine());
					        System.out.println("Provider Street Address: ");
					        String address = reader.nextLine();
					        System.out.println("Provider City: ");
					        String city = reader.nextLine();
					        System.out.println("Provider State (Postal Code): ");
					        String state = reader.nextLine();
					        System.out.println("Provider Zip Code: ");
					        int zip = Integer.parseInt(reader.nextLine());
							accountManagement.addProvider(number, name, address, city, state, zip);
							System.out.println("Provider added");
						}
						else if (string.equals("2")) {
							/**
							 * Delete provider
							 */
							System.out.println("Delete provider");
							System.out.println("Enter providerNumber to delete: ");
							accountManagement.printProvider();
					        int number = Integer.parseInt(reader.nextLine());
					        if (accountManagement.deleteProvider(number)) {
					        	System.out.println("Provider deleted");
					        }
					        else {
						        System.out.println("providerNumber not found. Provider not deleted.");
					        }
						}
						else if (string.equals("3")) {
							/**
							 * Edit provider
							 */
							System.out.println("Update provider");
							System.out.println("Provider Number to Update: ");
							accountManagement.printProvider();
					        int number = Integer.parseInt(reader.nextLine());
					        if (accountManagement.getProviders().containsKey(number) == false) {
					        	System.out.println("providerNumber not found. Provider not updated.");
					        	continue;
					        }
							System.out.println("Provider Name: ");
					        String name = reader.nextLine();
					        System.out.println("Provider Street Address: ");
					        String address = reader.nextLine();
					        System.out.println("Provider City: ");
					        String city = reader.nextLine();
					        System.out.println("Provider State (Postal Code): ");
					        String state = reader.nextLine();
					        System.out.println("Provider Zip Code: ");
					        int zip = Integer.parseInt(reader.nextLine());
							accountManagement.updateProvider(number, name, address, city, state, zip);
							System.out.println("Provider updated");
						}
						else if (string.equals("4")) {
							/**
							 * Exit
							 */
							break;
						}
						else {
							/**
							 * Invalid option
							 */
							System.out.println("That is an invalid option, please try again: ");
						}
					}
				}
				else if (s.equals("3")) {
					/**
					 * Exit
					 */
					break;
				}
				else {
					/**
					 * Invalid option
					 */
					System.out.println("That is an invalid option, please try again: ");
				}
			}
		}
		return;
	}
	
	/**
	 * 
	 * @param userAccounts for login
	 * @param reader for reading user input
	 * @return boolean representing whether operator is verified or not
	 */
	public boolean verifyOperator(Dictionary userAccounts, Scanner reader) {
		/**
		 * Asks operator to enter their ID and password for verification
		 */
		System.out.println("Login");
		System.out.println("Enter ID: ");
		String ID = reader.nextLine();
		System.out.println("Enter password: ");
		String password = reader.nextLine();
		
		/**
		 *  If ID and password match, returns true
		 */
		if (Objects.equals(userAccounts.get(ID), password)){
			return true;
		}
		
		/**
		 *  If ID and password don't match, returns false
		 */
		else {
			System.out.println("Invalid ID or Password.");
			return false;
		}
	}
}
