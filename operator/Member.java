package operator;

import java.util.ArrayList;
import java.util.List;

import extra.MemberService;

/**
 * @author Sam Kwon
 */
public class Member {
	private String memberName;
	private int memberNumber;
	private String memberStreetAddress;
	private String memberCity;
	private String memberState;
	private int memberZIP;
	private List<MemberService> memberServices;
	
	public Member(String memberName, String memberStreetAddress, String memberCity, String memberState, int memberZIP) {
		this.memberName = memberName;
		this.memberStreetAddress = memberStreetAddress;
		this.memberCity = memberCity;
		this.memberState = memberState;
		this.memberZIP = memberZIP;
		this.memberServices = new ArrayList<MemberService>();
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public void setmemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	public String getMemberStreetAddress() {
		return memberStreetAddress;
	}
	public void setMemberStreetAddress(String memberStreetAddress) {
		this.memberStreetAddress = memberStreetAddress;
	}
	public String getMemberCity() {
		return memberCity;
	}
	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}
	public String getMemberState() {
		return memberState;
	}
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}
	public int getMemberZIP() {
		return memberZIP;
	}
	public void setMemberZIP(int memberZIP) {
		this.memberZIP = memberZIP;
	}
	
	// Method that lists all the services received by a certain member
	public String getMemberServices(){
		String services = "Services:" + "\n";
		
		// Iterates through entire list of services for specific member.
		for (int i = 0; i < memberServices.size(); i++) {
			services = services.concat(memberServices.get(i).toString() + "\n");
		}
		
		return services;
	}
	
	// Adds a new service to the list containing all the received services.
	public void addMemberService(String date, String providerName, String serviceName) {
		
		MemberService service = new MemberService(date, providerName, serviceName);
		
		memberServices.add(service);
	}
	
}
