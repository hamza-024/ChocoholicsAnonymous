package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import extra.ProviderDirectory;
import operator.Management;
import operator.Member;
import operator.Provider;
import terminals.ProviderTerminal;

class ChristianMerazSantiagoJUnitTests {
	
	@BeforeEach
	void setUp() throws Exception{
	}
	
	@Test
    public void testProviderDirectory() throws IOException{
        ProviderDirectory providerDirectory = new ProviderDirectory();
        providerDirectory.printProviderDirectory();

        BufferedReader br = new BufferedReader(new FileReader("ProviderDirectory.txt"));
        String line1 = br.readLine();
        String line2 = br.readLine();
        String line3 = br.readLine();
        String line4 = br.readLine();
        br.close();

        assertEquals("598470 : Session with dietitian", line1);
        assertEquals("883948 : Aerobics exercise session", line2);
        assertEquals("123456 : Therapy", line3);
        assertEquals("567890 : Visit with physician", line4);
    }
	@Test
	public void testVerifyProvider() {
        // Prepare test data
        Dictionary<String, String> userAccounts = new Hashtable<>();
        userAccounts.put("validID", "validPassword");
        // Test with valid credentials
        Scanner validCredentialsScanner = new Scanner("validID\nvalidPassword\n");
        assertTrue(new ProviderTerminal().verifyProvider(userAccounts, validCredentialsScanner));
        // Test with invalid credentials
        Scanner invalidCredentialsScanner = new Scanner("invalidID\ninvalidPassword\n");
        assertFalse(new ProviderTerminal().verifyProvider(userAccounts, invalidCredentialsScanner));
    }
	@Test
	public void testAddMember() {
		Management management = new Management();
		management.addMember(581, "Christian", "123 rd", "Nashville", "TN", 67891);
		HashMap<Integer, Member> members = management.getMembers();
		
		for(HashMap.Entry<Integer, Member> entry : members.entrySet()) {
			int number = entry.getKey();
			Member member = entry.getValue();
			
			assertEquals(number, 581);
		    assertEquals(member.getMemberName(), "Christian");
		    assertEquals(member.getMemberStreetAddress(), "123 rd");
		    assertEquals(member.getMemberCity(), "Nashville");
		    assertEquals(member.getMemberState(), "TN");
		    assertEquals(member.getMemberZIP(), 67891);
		}
	}
}