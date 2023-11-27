package operator;

import java.util.HashMap;

/**
 * @author Sam Kwon
 */
public class Management {
	private HashMap<Integer, Member> members = new HashMap<Integer, Member>();
	private HashMap<Integer, Provider> providers = new HashMap<Integer, Provider>();
	private HashMap<Integer, Manager> managers;
	
	// Constructor
	public Management() {
		this.members = new HashMap<Integer, Member>();
		this.providers = new HashMap<Integer, Provider>();
		this.managers = new HashMap<Integer, Manager>();
	}
	
	public HashMap<Integer, Member> getMembers() {
		return members;
	}

	public void setMembers(HashMap<Integer, Member> members) {
		this.members = members;
	}

	public HashMap<Integer, Provider> getProviders() {
		return providers;
	}

	public void setProviders(HashMap<Integer, Provider> providers) {
		this.providers = providers;
	}
	
	// Adds new manager
	public void addManager(int id, String ID, String Password) {
		Manager manager = new Manager(ID, Password);
		this.managers.put(id, manager);
	}

	// Adds new member
	public void addMember(int id, String memberName, String memberStreetAddress, String memberCity, String memberState, int memberZIP) {
		Member member = new Member(memberName, memberStreetAddress, memberCity, memberState, memberZIP);
		member.setmemberNumber(id);
		this.members.put(id, member);
	}
	
	// Deletes member
	public boolean deleteMember(int id) {
		if (this.members.remove(id) != null) {
			return true;
		}
		return false;
	}
	
	// Updates existing member
	public void updateMember(int id, String memberName, String memberStreetAddress, String memberCity, String memberState, int memberZIP) {
		Member member = this.members.get(id);
		member.setMemberName(memberName);
		member.setMemberStreetAddress(memberStreetAddress);
		member.setMemberCity(memberCity);
		member.setMemberState(memberState);
		member.setMemberZIP(memberZIP);
	}
	
	// Prints members
	public void printMember() {
		for (HashMap.Entry<Integer, Member> entry : members.entrySet()) {
		    int number = entry.getKey();
		    Member member = entry.getValue();
		    System.out.println("memberNumber: " + number + ", Name: " + member.getMemberName());
		}
	}
	
	// Adds new provider
	public void addProvider(int id, String providerName, String providerStreetAddress, String providerCity, String providerState, int providerZIP) {
		Provider provider = new Provider(providerName, providerStreetAddress, providerCity, providerState, providerZIP);
		provider.setProviderNumber(id);
		this.providers.put(id, provider);
	}
	
	// Deletes provider
	public boolean deleteProvider(int id) {
		if (this.providers.remove(id) != null) {
			return true;
		}
		return false;
	}
	
	// Updates existing provider
	public void updateProvider(int id, String providerName, String providerStreetAddress, String providerCity, String providerState, int providerZIP) {
		Provider provider = this.providers.get(id);
		provider.setProviderName(providerName);
		provider.setProviderStreetAddress(providerStreetAddress);
		provider.setProviderCity(providerCity);
		provider.setProviderState(providerState);
		provider.setProviderZIP(providerZIP);
	}
	
	// Prints providers
	public void printProvider() {
		for (HashMap.Entry<Integer, Provider> entry : providers.entrySet()) {
		    int number = entry.getKey();
		    Provider provider = entry.getValue();
		    System.out.println("providerNumber: " + number + ", Name: " + provider.getProviderName());
		}
	}
	
	// Prints provider consultation info
	public String printProviders() {
		String str = "";
		
		for (int key : providers.keySet()) {
			str = str.concat(providers.get(key).getProviderName() + "\n");
			str = str.concat("Number of consultations: " + providers.get(key).getNumConsultations() + "\n");
			str = str.concat("Fee: " + providers.get(key).getTotalFee() + "\n");
		}
		
		return str;
	}
	
	// Method that returns the total number of providers in the database
	public String getNumProviders() {
	
		return "Total number of providers: " + providers.size() + "\n";
		
	}
	
	// Method that returns the total number of consultations 
	// That were provided by all the providers.
	public String getTotalConsult() {
		String str = "Total number of consultations: ";
		
		int total = 0; 
		
		// Iterates through entire hash map
		for(int key : providers.keySet()) {
			total += providers.get(key).getNumConsultations();
		}
		
		// Builds string including number of consultations
		str = str.concat(total + "\n");
		
		return str;
	}
	
	// Method that sums up all the fees for all the 
	// services provided by all the providers.
	public String getTotalFee() {
		String str = "Total fee: ";
		
		int total = 0; 
		
		// Iterates through entire hash map
		for(int key : providers.keySet()) {
			total += providers.get(key).getTotalFee();
		}
		
		// Builds string including total fee
		str = str.concat(total + "\n");
		
		return str;
	}
	
	// Searches hash map for specific provider
	public Provider findProvider(int ID) {
		return providers.get(ID);
	}
	
	// Searches hash map for specific member.
	public Member findMember(int ID) {
		return members.get(ID);
	}
	
	// Searches hash map for specific manager.
	public Manager findManager(int ID) {
		return managers.get(ID);
	}
}