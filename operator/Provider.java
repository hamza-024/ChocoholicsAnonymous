package operator;

import java.util.ArrayList;
import java.util.List;

import extra.MemberService;
import extra.ProviderService;
/**
 * @author Sam Kwon
 */
public class Provider {
	private String providerName;
	private int providerNumber;
	private String providerStreetAddress;
	private String providerCity;
	private String providerState;
	private int providerZIP;
	private List<ProviderService> providerServices;
	
	public Provider(String providerName, String providerStreetAddress, String providerCity, String providerState, int providerZIP) {
		this.providerName = providerName;
		this.providerStreetAddress = providerStreetAddress;
		this.providerCity = providerCity;
		this.providerState = providerState;
		this.providerZIP = providerZIP;
		this.providerServices = new ArrayList<ProviderService>();
	}
	
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	public int getProviderNumber() {
		return providerNumber;
	}
	
	public void setProviderNumber(int providerNumber) {
		this.providerNumber = providerNumber;
	}
	
	public String getProviderStreetAddress() {
		return providerStreetAddress;
	}
	public void setProviderStreetAddress(String providerStreetAddress) {
		this.providerStreetAddress = providerStreetAddress;
	}
	public String getProviderCity() {
		return providerCity;
	}
	public void setProviderCity(String providerCity) {
		this.providerCity = providerCity;
	}
	public String getProviderState() {
		return providerState;
	}
	public void setProviderState(String providerState) {
		this.providerState = providerState;
	}
	public int getProviderZIP() {
		return providerZIP;
	}
	public void setProviderZIP(int providerZIP) {
		this.providerZIP = providerZIP;
	}
	
	
	// Method that lists all the services provided by a certain provider
	// Output includes total number of consultations and total fee
	public String getProviderServices(){
		String services = "Services:" + "\n";
		
		// Iterates through entire list of services for specific provider.
		for (int i = 0; i < providerServices.size(); i++) {
			services = services.concat(providerServices.get(i).toString() + "\n");
		}
		
		int totalConsultations = providerServices.size();

		services = services.concat("Total number of Consultations: " + totalConsultations + "\n");
		
		services = services.concat("Total fee for week: $" + getTotalFee() + "\n");
		
		return services;
	}
	
	
	
	// Adds a new service to the list containing all the completed services.
	public void addProviderService(String date, String time, String memberName, String memberNumber, String code, double fee) {
		
		ProviderService service = new ProviderService(date, time, memberName, memberNumber, code, fee);
		
		providerServices.add(service);
	}
	
	// Method that returns the total number of consultations that a provider has provided.
	public int getNumConsultations() {
		
		return providerServices.size();
	}
	
	// Method that sums all the fees for all the services provided
	public double getTotalFee() {
		double totalFee = 0;
		
		// Iterates through entire list of services for specific provider.
		for(int i = 0; i < providerServices.size(); i++) {
			totalFee += providerServices.get(i).getFee();
		}
		
		return totalFee;
	}
	
}
