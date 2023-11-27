package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import operator.Management;
import operator.Member;
import operator.Provider;

class LukeHallenbeckJUnitTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testGetTotalConsult() {
		
		Management management = new Management();
		
		management.addProvider(123,"Test Provider", "123 St.", "City", "AL", 12345);
		management.findProvider(123).addProviderService("09-17-2023", "8:45", "Bob Smith", "42", "6767", 67);
		management.findProvider(123).addProviderService("09-20-2023", "9:00", "Smith Bob", "24", "7676", 23);
		
		management.addProvider(456,"Big Guy", "420 Main St", "City", "AL", 54321);
		management.findProvider(456).addProviderService("10-11-2012", "8:45", "Bob Smith", "42", "6767", 67);
		management.findProvider(456).addProviderService("11-11-2022", "9:00", "Smith Bob", "24", "7676", 23);
		
		String totalConsultations = "Total number of consultations: 4\n";
		
		assertEquals(management.getTotalConsult(), totalConsultations);
	}
	
	@Test
	public void testManagerGetPassword() {
		
		Management management = new Management();
		
		int ID = 123;
		String name = "Batman";
		String password = "password";
		
		management.addManager(ID, name, password);
		
		assertEquals(management.findManager(ID).getPassword(), "password");
		
	}
	
	@Test
	public void testAddProvider() {
		
		Management management = new Management();
		management.addProvider(123, "Big Provider", "18 Nattys", "Tuscaloosa", "AL", 35401);
		HashMap<Integer, Provider> providers = management.getProviders();
		
		for (HashMap.Entry<Integer, Provider> entry : providers.entrySet()) {
			int number = entry.getKey();
			assertEquals(number, 123);
		 
		    Provider provider = entry.getValue();
		    assertEquals(provider.getProviderName(), "Big Provider");
		    assertEquals(provider.getProviderStreetAddress(), "18 Nattys");
		    assertEquals(provider.getProviderCity(), "Tuscaloosa");
		    assertEquals(provider.getProviderState(), "AL");
		    assertEquals(provider.getProviderZIP(), 35401);
		}
	}

}
