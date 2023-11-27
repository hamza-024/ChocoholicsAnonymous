package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

import extra.BillChocAn;
import operator.Management;
import operator.Provider;

class MaeOlsenJUnitTests {

    @BeforeEach
    void setup() throws Exception {
    }

    @Test
    public void testVerifyMember() {
        BillChocAn billChocAn = new BillChocAn();
        Management management = new Management();
        management.addMember(123, "Name", "Address", "City", "State", 70037);
        boolean result = BillChocAn.verifyMember(123, management);

        assertEquals(true, result);
    }

    @Test
    public void testFindServiceCode() {
        BillChocAn billChocAn = new BillChocAn();
        String serviceCode;
        String serviceOption = "1";
        serviceCode = billChocAn.findServiceCode(serviceOption);

        assertEquals("598470", serviceCode);
    }

    @Test
    public void testUpdateProvider() {
        Management management = new Management();
        management.addProvider(123, "Provider One", "Address", "City", "LA", 70037);
        management.updateProvider(123, "Provider One", "New Address", "City", "LA", 70037);
        HashMap<Integer, Provider> providers = management.getProviders();

        for (HashMap.Entry<Integer, Provider> entry : providers.entrySet()) {
            int number = entry.getKey();
            assertEquals(123, number);

            Provider provider = entry.getValue();
            assertEquals("Provider One", provider.getProviderName());
            assertEquals("New Address", provider.getProviderStreetAddress());
            assertEquals("City", provider.getProviderCity());
            assertEquals("LA", provider.getProviderState());
            assertEquals(70037, provider.getProviderZIP());
        }
    }
}
