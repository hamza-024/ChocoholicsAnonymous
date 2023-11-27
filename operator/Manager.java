package operator;
/**
 * @author Luke Hallenbeck
 */
public class Manager {
	
	// Managers name
	private String ID;
	
	// Managers password
	private String password;
	
	//Constructor
	// Takes managers name and password and creates new manager object
	public Manager(String ID, String password) {
		this.ID = ID;
		this.password = password;
	}
	
	// Method that returns manager ID
	public String getID() {
		return ID;
	}
	
	// Method that returns manager password.
	public String getPassword() {
		return password;
	}
	
}
