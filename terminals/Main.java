package terminals;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import operator.Management;
import reports.AccountingProcedure;

/**
 * @author Sam Kwon
 */
public class Main {
	public static OperatorTerminal operatorTerminal = new OperatorTerminal();
	public static ProviderTerminal providerTerminal = new ProviderTerminal();
	public static ManagerTerminal managerTerminal = new ManagerTerminal();
	
	public static Dictionary<String, String> userAccounts = new Hashtable<>();
	
	public static Management accountManagement = new Management();
	
	public static void main(String[] args) throws IOException {
		createData();
		Scanner reader = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to the ChocAn System!");
			System.out.println("Enter [1] for operator terminal");
			System.out.println("Enter [2] for provider terminal");
			System.out.println("Enter [3] for manager terminal");
			System.out.println("Enter [4] to run weekly accounting procedure");
			System.out.println("Enter [5] to exit");
			System.out.println("Enter an option: ");
			String s = reader.nextLine();
			
			if (s.equals("1")) {
				//Go to operator terminal
				operatorTerminal.runTerminal(userAccounts, accountManagement, reader);
			}
			else if (s.equals("2")) {
				//Go to provider terminal
				providerTerminal.runTerminal(userAccounts, accountManagement, reader);
			}
			else if (s.equals("3")) {
				//Go to manager terminal
				managerTerminal.ManagerMenu(accountManagement);
			}
			// Case where user wants to run weekly accounting procedure report.
			else if (s.equals("4")) {
				AccountingProcedure accounting = new AccountingProcedure();
				AccountingProcedure.runWeeklyProcedure(accountManagement);
			}
			else if (s.equals("5")) {
				//Exit
				break;
			}
			else {
				//Invalid option
				System.out.println("That is an invalid option, please try again: ");
			}
		}
		reader.close();
	}
	
	// Create data for various individuals
	public static void createData() {
		userAccounts.put("Bob", "123");
		userAccounts.put("Nick", "7natties");
		
		accountManagement.addManager(77, "klone", "hello");
		
		accountManagement.addMember(42, "Bob Smith", "123 Street", "A city", "MA", 12345);
		accountManagement.addMember(7, "Nick Saban", "Bryant-Denny", "Tuscaloosa", "AL", 35401);
		accountManagement.findMember(42).addMemberService("09-17-2003", "person", "massage");
		
		accountManagement.addProvider(21, "Nick Name", "abc dr.", "someplace", "GA", 90908);
		accountManagement.addProvider(4, "person", "place st.", "town", "OK", 12987);
		accountManagement.findProvider(4).addProviderService("09-17-2003", "8:45", "Bob Smith", "42", "6767", 67);
		accountManagement.findProvider(21).addProviderService("09-17-2003", "8:45", "Bob Smith", "42", "6767", 67);
	}
}
