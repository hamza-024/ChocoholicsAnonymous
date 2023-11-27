package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operator.Management;
import operator.Member;
import operator.Provider;

class SamKwonJUnitTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testAddMember() {
		Management management = new Management();
		management.addMember(123, "Test Name", "123 St.", "City", "AL", 12345);
		HashMap<Integer, Member> members = management.getMembers();
		
		for (HashMap.Entry<Integer, Member> entry : members.entrySet()) {
			int number = entry.getKey();
			assertEquals(number, 123);
		 
		    Member member = entry.getValue();
		    assertEquals(member.getMemberName(), "Test Name");
		    assertEquals(member.getMemberStreetAddress(), "123 St.");
		    assertEquals(member.getMemberCity(), "City");
		    assertEquals(member.getMemberState(), "AL");
		    assertEquals(member.getMemberZIP(), 12345);
		}
	}
	
	@Test
	public void testUpdateMember() {
		Management management = new Management();
		management.addMember(123, "Test Name", "123 St.", "City", "AL", 12345);	
		management.updateMember(123, "New Name", "123 St.", "New City", "AL", 54321);
		HashMap<Integer, Member> members = management.getMembers();
		
		for (HashMap.Entry<Integer, Member> entry : members.entrySet()) {
			int number = entry.getKey();
			assertEquals(number, 123);
		 
		    Member member = entry.getValue();
		    assertEquals(member.getMemberName(), "New Name");
		    assertEquals(member.getMemberStreetAddress(), "123 St.");
		    assertEquals(member.getMemberCity(), "New City");
		    assertEquals(member.getMemberState(), "AL");
		    assertEquals(member.getMemberZIP(), 54321);
		}
	}
	
	@Test
	public void testProviderFee() {
		Provider provider = new Provider("Test Provider", "123 St.", "City", "AL", 12345);
		provider.addProviderService("09-17-2023", "8:45", "Bob Smith", "42", "6767", 67);
		provider.addProviderService("09-20-2023", "9:00", "Smith Bob", "24", "7676", 23);
		
		double fee = provider.getTotalFee();
		assertEquals(90, fee);
	}
}
