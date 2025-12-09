/**
 * Secondary (abstract) class for {@code NailAppointment}.
 *
 * <p>
 * This class implements all secondary methods declared in the
 * {@code NailAppointment} interface using only the kernel and Standard methods.
 * It does not depend on any particular representation.
 * </p>
 *
 * @author Jasmin Ikromova
 */

public abstract class NailAppointmentSecondary implements NailAppointment {

    /**
     * No-argument constructor.
     */
    private NailAppointmentSecondary() {
    }

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

    @Override
    public final String toString() {
        return this.receipt();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NailAppointment)) {
            return false;
        }

        NailAppointment other = (NailAppointment) obj;

        if (!this.customerName().equals(other.customerName())) {
            return false;
        }
        if (this.length() != other.length()) {
            return false;
        }
        if (this.polishType() != other.polishType()) {
            return false;
        }

        String[] knownServices = { "french", "chrome", "aura", "other" };

        for (int i = 0; i < knownServices.length; i++) {
            String s = knownServices[i];
            boolean thisHas = this.hasService(s);
            boolean otherHas = other.hasService(s);
            if (thisHas != otherHas) {
                return false;
            }
        }

        return true;
    }

}
