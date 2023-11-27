package terminals;

import java.util.Scanner;

import operator.Management;
import reports.AccountingProcedure;
import reports.EFTReport;
import reports.MemberReport;
import reports.ProviderReport;
import reports.SummaryReport;

import java.io.IOException;
import java.util.Objects;
/**
 * @author Luke Hallenbeck
 * The ManagerTerminal class. This class provides a way for the manager to login and complete their
 * designated tasks including accessing reports
 */
public class ManagerTerminal {
	
	/**
	 *Scanner that allows inputs to be read from terminal.
	 */
	Scanner reader = new Scanner(System.in);
	
	/**
	 * boolean that represents whether or not the manager has been verified.
	 */
	private boolean loggedIn;
	
	/**
	 * default constructor for manager terminal; 
	 * sets verification level to false.
	 */
	public ManagerTerminal() {
		loggedIn = false;
	}
	
	/**
	 * Runs manager terminal from main menu. All actions proceed from this
	 * @param accounts
	 * @throws IOException
	 */
	public void ManagerMenu(Management accounts) throws IOException {
		
		/**
		 * Main greeting page in terminal.
		 */
		System.out.println("Welcome to the manager terminal!");
		
		/**
		 * Checks to see whether or not the manager is logged in.
		 * Runs if manager is not logged into the terminal.
		 */
		if (loggedIn == false) {
			
			/**
			 *  Output to prompt log in
			 */
			System.out.println("Please verify your credentials.");
			
			/**
			 *  Verification function
			 */
			verifyManager(accounts);
			
			/**
			 * Checks to see if login was valid.
			 * If so, manager terminal is restarted from beginning. 
			 */
			if (loggedIn == true) {
				ManagerMenu(accounts);
			}
			
			/**
			 *  Case where login was invalid.
			 */
			else {
				
				String choice = null;
					
					/**
					 * Output asks user if they would like to try login again.
					 */
					System.out.println("Try again?");
					System.out.println("[1] Yes");
					System.out.println("[2] No");
					choice = reader.nextLine();
					
					/**
					 * Case where user decides to attempt login again
					 */
					if (choice.equals("1")) {
						
						/**
						 * Checks to see whether login attempt was successful.
						 * If so, manager menu function is restarted.
						 */
						
						if (verifyManager(accounts) == true) {
							ManagerMenu(accounts);
						}
					}
					
					/**
					 * Case where user decides not to attempt login again.
					 */
					else if (choice.equals("2")) {
						/**
						 * continue;
						 */
						
					}
					
					/**
					 *  Case where user doesn't select yes or no.
					 */
					else {
						System.out.println("Invalid choice.");
					}
				}
			}
		
		/**
		 *  If logged in, the manager can then select which actions to perform.
		 */
		else {
			
			/**
			 * Loop that allows manager to continue performing actions until they logout of the terminal.
			 */
			while (loggedIn == true) {
						
				/**
				 *  Output list of terminal actions
				 */
				System.out.println("What would you like to do?");
				System.out.println("[1] Access reports.");
				System.out.println("[2] Logout.");
						
				String action = reader.nextLine();
						
				/**
				 * Case where the manager selects to access reports
				 */
				if (action.equals("1")) {
					accessReport(accounts);
				}
						
				/**
				 * Case where manager decides to logout of the terminal.
				 */
				else if (action.equals("2")) {
					logout();
				}
						
				/**
				 * Case where manager enters an invalid action choice.
				 */
				else {
					System.out.println("Please enter a valid action.");
				}
			}
		}
	}
	
	/**
	 * Method to verify managers credentials
	 * @param accounts contains all manager data
	 * @return boolean that represents logged in or not
	 */
	public boolean verifyManager(Management accounts) {
		/**
		 *  Asks manager to enter their ID and password for verification
		 */
		System.out.println("Enter ID(integer): ");
		String username = reader.nextLine();
		int ID;
		
		try {
			   ID = Integer.parseInt(username);
		}
		catch (NumberFormatException e) {
			   System.out.println("ID must be an integer.");
			   return false;
		}
		
		System.out.println("Enter password: ");
		String password = reader.nextLine();
		
		if(accounts.findManager(ID) == null) {
			System.out.println("Manager ID not found.");
			return false;
		}
		
		/**
		 *  If ID and password match, returns true
		 */
		else if (Objects.equals(accounts.findManager(ID).getPassword(), password)){
			loggedIn = true;
			return true;
		}
		
		/**
		 *  If ID and password don't match, returns false
		 */
		else {
			System.out.println("Invalid Password.");
			return false;
		}
	}
	
	/**
	 * Method for manager to access report(s) of their choice.
	 * @param reports contains all ChocAn data information
	 * @throws IOException
	 */
	public void accessReport(Management reports) throws IOException {
		
		/**
		 *  Prompts user as to which report they would like to access
		 */
		System.out.println("Which report to you want to generate?");
		System.out.println("[1] Get All Reports");
        System.out.println("[2] Get Provider Report");
        System.out.println("[3] Get Member Report");
        System.out.println("[4] Get Summary Report");
        System.out.println("[0] Return to Manager Menu");
        
        String num = reader.nextLine();
        
        /**
         *  Case where user wants to access all reports
         */
        if (num.equals("1")) {
        	EFTReport etf = new EFTReport();
        	
        	System.out.println("Please enter the ID of the provider that you would like to generate a provider report for.");
        	int providerID = Integer.parseInt(reader.nextLine());
        	ProviderReport provider = new ProviderReport(reports.findProvider(providerID));
        	provider.printProviderReport();
        	
        	System.out.println("Please enter the ID of the member that you would like to generate a member report for.");
        	int memberID = Integer.parseInt(reader.nextLine());
        	MemberReport member = new MemberReport(reports.findMember(memberID));
        	member.printMemberReport();
        	
        	SummaryReport summary = new SummaryReport(reports);
        	summary.printSummaryReport();
        }
        
        /**
         *  Case where user wants to access provider report.
         */
        else if (num.equals("2")) {
        	System.out.println("Please enter the ID of the provider that you would like to generate a provider report for.");
        	int providerID = Integer.parseInt(reader.nextLine());
        	ProviderReport provider = new ProviderReport(reports.findProvider(providerID));
        	provider.printProviderReport();
        }
        
        /**
         *  Case where user wants to access member report.
         */
        else if (num.equals("3")) {
        	System.out.println("Please enter the ID of the member that you would like to generate a member report for.");
        	int memberID = Integer.parseInt(reader.nextLine());
        	MemberReport member = new MemberReport(reports.findMember(memberID));
        	member.printMemberReport();
        }
        
        /**
         *  Case where user wants to access summary report.
         */
        else if (num.equals("4")) {
        	SummaryReport summary = new SummaryReport(reports);
        	summary.printSummaryReport();
        }
        
        /**
         *  Case where user decides to return to manager menu.
         */
        else if (num.equals("0")) {
        	System.out.println("Returning to main menu");
        }
        
        /**
         *  Case where user enters an invalid selection.
         */
        else {
        	System.out.println("Invalid report number. Please try again.");
        }
        
	}
	
	/**
	 * Method to logout
	 */
	public void logout() {
		
		/**
		 * Prompts user or logout certainty
		 */
		System.out.println("Are you sure you want to logout?");
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		
		String choice = reader.nextLine();
		
		/**
		 * If user is certain, they are logged out of terminal.
		 */
		if (choice.equals("1")) {
			loggedIn = false;
			System.out.println("You have successfully logged out.");
		}
	}

}
