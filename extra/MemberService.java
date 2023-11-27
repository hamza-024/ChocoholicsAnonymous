package extra;
/**
 * @author Luke Hallenbeck
 */
public class MemberService {
	
	//Date that the service was received.
	private String date;
	
	// Name of provider from which service was received.
	private String providerName;
	
	//Name of service received.
	private String serviceName;
	
	//Constructor
	public MemberService(String date, String providerName, String serviceName) {
		this.date = date;
		this.providerName = providerName;
		this.serviceName = serviceName;
	}
	
	// Method that turns individual service into a string containing all necessary information.
	public String toString() {
		String str = "Date of Service: " + date + "\n" ;
		
		str = str.concat("Provider Name: " + providerName + "\n" + 
		"Service Name: " + serviceName + "\n");
		
		return str;
		
	}
	
	
}
