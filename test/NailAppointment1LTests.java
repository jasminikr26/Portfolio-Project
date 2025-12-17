import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

public class NailAppointment1LTests {

    @Test
    public void testClear() {
        NailAppointment client = new NailAppointment1L();
        client.setCustomerName("Jaz");
        client.setLength(NailAppointment.NailLength.LONG);
        client.setPolishType(NailAppointment.PolishType.ACRYLIC);
        client.addService("rhinestones");

        client.clear();

        NailAppointment expected = new NailAppointment1L();
        assertEquals(expected.getCustomerName(), client.getCustomerName());
        assertEquals(expected.getLength(), client.getLength());
        assertEquals(expected.getPolishType(), client.getPolishType());
        assertFalse(client.hasService("rhinestones"));
    }

    @Test
    public void testNewInst() {
        NailAppointment client1 = new NailAppointment1L();
        NailAppointment client2 = client1.newInstance();

        assertNotSame(client1, client2);
        assertEquals("", client2.getCustomerName());
    }

    @Test
    public void testSetAndGetName() {
        NailAppointment client = new NailAppointment1L();
        client.setCustomerName("Jaz");
        assertEquals("Jaz", client.getCustomerName());
    }

    @Test
    public void testSetAndGetLength() {
        NailAppointment client = new NailAppointment1L();
        client.setLength(NailAppointment.NailLength.LONG);
        assertEquals(NailAppointment.NailLength.LONG, client.getLength());
    }

    @Test
    public void testSetAndGetPolishType() {
        NailAppointment client = new NailAppointment1L();
        client.setPolishType(NailAppointment.PolishType.GELX);
        assertEquals(NailAppointment.PolishType.GELX, client.getPolishType());
    }

    @Test
    public void testAddServiceAndHasService() {
        NailAppointment client = new NailAppointment1L();
        client.addService("chrome");
        assertTrue(client.hasService("chrome"));
        assertFalse(client.hasService("french"));
    }

    @Test
    public void testGetServicesReference() {
        NailAppointment test = new NailAppointment1L();
        test.addService("chrome");
        test.addService("french");
        test.addService("aura");

        Set<String> expectedServices = new Set1L<>();
        expectedServices.add("chrome");
        expectedServices.add("french");
        expectedServices.add("aura");

        Set<String> actualServices = test.getServices();
        assertEquals(expectedServices, actualServices);
    }

}
