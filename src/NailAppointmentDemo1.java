import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class NailAppointmentDemo1 {
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        NailAppointment a = new NailAppointment1L();

        out.print("Enter customer name: ");
        String name = in.nextLine();
        a.setCustomerName(name);

        out.print("Enter nail length (SHORT, MEDIUM, LONG): ");
        String lengthIn = in.nextLine();
        a.setLength(NailAppointment.NailLength.valueOf(lengthIn.toUpperCase()));

        out.print("Enter polish type (REGULAR, GELX, ACRYLIC): ");
        String polishInput = in.nextLine();
        a.setPolishType(
                NailAppointment.PolishType.valueOf(polishInput.toUpperCase()));

        out.print("Do you want to add any services (y/n)? ");
        String addServices = in.nextLine();

        while (addServices.equalsIgnoreCase("y")) {
            out.print(
                    "Enter service name to add (e.g., rhinestones, chrome): ");
            String service = in.nextLine();
            a.addService(service);

            out.print("Add another service? (y/n): ");
            addServices = in.nextLine();
        }

        out.println();
        out.println(a.receipt());

        in.close();
        out.close();
    }
}
