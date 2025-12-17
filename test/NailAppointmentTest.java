import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NailAppointmentTest {

    @Test
    public void testGetBasePrice() {
        NailAppointment client1 = new NailAppointment1L();
        client1.setLength(NailAppointment.NailLength.SHORT);
        client1.setPolishType(NailAppointment.PolishType.REGULAR);
        assertEquals(10, client1.getBasePrice());

        NailAppointment client2 = new NailAppointment1L();
        client2.setLength(NailAppointment.NailLength.MEDIUM);
        client2.setPolishType(NailAppointment.PolishType.GELX);
        assertEquals(25, client2.getBasePrice());
    }

    @Test
    public void testCalcTotalPriceWithServices() {
        NailAppointment client = new NailAppointment1L();
        client.setLength(NailAppointment.NailLength.MEDIUM);
        client.setPolishType(NailAppointment.PolishType.GELX);
        client.addService("chrome");
        client.addService("french");

        assertEquals(35, client.calculateTotalPrice());
    }

    @Test
    public void testCalculateTotalPriceNoServices() {
        NailAppointment a = new NailAppointment1L();
        a.setLength(NailAppointment.NailLength.SHORT);
        a.setPolishType(NailAppointment.PolishType.GELX);

        assertEquals(20, a.calculateTotalPrice());
    }

    @Test
    public void testIsValidRequestTrue() {
        NailAppointment a = new NailAppointment1L();
        a.setCustomerName("Lana");
        a.setLength(NailAppointment.NailLength.MEDIUM);
        a.setPolishType(NailAppointment.PolishType.GELX);
        assertTrue(a.isValidRequest());
    }

    @Test
    public void testIsValidRequestFalse() {
        NailAppointment a = new NailAppointment1L();
        a.setCustomerName("");
        assertFalse(a.isValidRequest());
    }

    @Test
    public void testReceiptContent() {
        NailAppointment a = new NailAppointment1L();
        a.setCustomerName("Maya");
        a.setLength(NailAppointment.NailLength.SHORT);
        a.setPolishType(NailAppointment.PolishType.GELX);
        a.addService("rhinestones");

        String receipt = a.receipt();
        assertTrue(receipt.contains("Maya"));
        assertTrue(receipt.contains("SHORT"));
        assertTrue(receipt.contains("GELX"));
        assertTrue(receipt.contains("rhinestones"));
        assertTrue(receipt.contains("Total Price"));
    }
}
