import java.lang.reflect.Array;
import java.util.ArrayList;

public class NailAppointment {

    enum NailLength {
        SHORT, MEDIUM, LONG
    }

    enum PolishType {
        REGULAR, GELX, ACRYLIC
    }

    private String customerName;
    private NailLength length;
    private PolishType polish;
    private Array<String> services;

    public NailAppointment() {
        this.customerName = "";
        this.length = NailLength.SHORT;
        this.polish = PolishType.REGULAR;
        this.services = new ArrayList<>();
    }

    /* kernal methods */

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setLength(NailLength length) {
        this.length = length;
    }

    public NailLength getLength(){
        return this.length
    }

    public void setPolishType(PolishType type) {
        this.polish = type;
    }

    public PolishType getPolishType() {
        return this.polish;
    }

    public void addService(String service) {
        this.services.add(service);
    }

    /* Secondary methods */

    public int getBasePrice(){
        int price = 0;

        if(this.length == NailLength.SHORT){
            price = price + 10;
        }
        else if(this.length == NailLength.MEDIUM){
            price = price + 15
        }
        else{
            price = price + 20
        }

        if(this.polish == PolishType.GEL){
            price = price + 10
        }
        else if(this.polish == PolishType.ACRYLIC){
            price = price + 15
        }

        return price;
    }

    public int calculateTotalPrice() {
        int price = this.getBasePrice();

        for (int i = 0; i < this.services.size(); i++) {
            price = price + 5;
        }

        return price;
    }

    public boolean isValidRequest() {
        boolean result = false;

        if (this.customerName != null && this.customerName.equals("")) {
            result = true;
        }
        return result;
    }

    public String receipt() {
        String customer = "Customer: " + this.customerName + "\n";
        String length = "Length: " + this.getLength() + "\n";
        String type = "Polish: " + this.getPolishType() + "\n";

        String services = "Services: ";
        String em = "";

        if (this.services.size() == 0) {
            em = "none";
        } else {
            for (int i = 0; i < this.services.size(); i++) {
                em = em + ", " + this.services.get(i) + "\n";
            }
        }

        String basePrice = "Base Price: $" + this.getBasePrice() + "\n";
        String totalPrice = "Total Price: $" + this.calculateTotalPrice()
                + "\n";

        String everything = customer + length + type + services + em + basePrice
                + totalPrice;

        return everything;
    }

    public static void main(String[] args) {
        NailAppointment appt = new NailAppointment();

        appt.setCustomerName("Jasmin");
        appt.setLength(NailLength.LONG);
        appt.setPolishType(PolishType.GELX);
        appt.addService("french");
        appt.addService("chrome");

        out.println(appt.receipt());
    }
}
