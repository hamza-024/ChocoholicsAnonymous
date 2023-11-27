package extra;
/**
 * 
 * @author Hamza Adnan
 * The ProviderService class. This class stores and formats the information for the service records.
 *
 */

public class ProviderService {
	
	/**
	 * Date the service was performed
	 */
	private String date;
	
	/**
	 * Time the system received the data.
	 */
	private String time;
	
	/**
	 * Name of member for which service was performed.
	 */
	private String memberName;
	
	/**
	 * Number of member for which service was performed.
	 */
	private String memberNumber;
	
	/**
	 * Number of member for which service was performed.
	 */
	private String serviceCode;
	
	/**
	 * Fee for provided service.
	 */
	private double fee;
	
	/**
	 * Provider service constructor.
	 * @param date
	 * @param time
	 * @param memberName
	 * @param memberNumber
	 * @param code
	 * @param fee
	 */
	public ProviderService(String date, String time, String memberName, String memberNumber, String code, double fee){
		this.date = date;
		this.time = time;
		this.memberName = memberName;
		this.memberNumber = memberNumber;
		this.serviceCode = code;
		this.fee = fee;
	}
	
	/**
	 * returns fee for specific service.
	 * @return fee
	 */
	public double getFee() {
		return fee;
	}
	
	/**
	 * returns date for specific service.
	 * @return date
	 */
	public String getServiceDate() {
		return date;
	}

	/**
	 * returns service code for specific service.
	 * @return serviceCode
	 */
	public String getServiceCode() {
		return serviceCode;
	}
	/**
	 * Formats and returns all service information as a string.
	 * @return str
	 */
	public String toString() {
		String str = "Date of service: " + date + "\n";
		
		str = str.concat("Date and time recieved: " + date + " " + time + "\n");
		str = str.concat("Member name: " + memberName + "\n");
		str = str.concat("Member number: " + memberNumber + "\n");
		str = str.concat("Service code: " + serviceCode + "\n");
		str = str.concat("Fee to be paid: " + fee + "\n");
		
		return str;
		
	}
	
}
