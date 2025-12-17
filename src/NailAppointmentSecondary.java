import components.set.Set;

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
    public NailAppointmentSecondary() {
    }

    @Override
    public int getBasePrice() {
        int price = 0;

        if (this.getLength() == NailLength.SHORT) {
            price = 10;
        } else if (this.getLength() == NailLength.MEDIUM) {
            price = 15;
        } else {
            price = 20;
        }

        if (this.getPolishType() == PolishType.GELX) {
            price = price + 10;
        } else if (this.getPolishType() == PolishType.ACRYLIC) {
            price = price + 15;
        }

        return price;
    }

    @Override
    public int calculateTotalPrice() {
        int price = this.getBasePrice();

        Set<String> temp = this.getServices();

        while (temp.size() > 0) {
            temp.removeAny();
            price = price + 5;
        }
        return price;
    }

    @Override
    public boolean isValidRequest() {
        return this.getCustomerName() != null
                && !this.getCustomerName().equals("")
                && this.getLength() != null && this.getPolishType() != null;
    }

    @Override
    public String receipt() {
        String customer = "Customer: " + this.getCustomerName() + "\n";
        String length = "Length: " + this.getLength() + "\n";
        String type = "Polish: " + this.getPolishType() + "\n";

        String service = "Services: ";
        String em = "";

        Set<String> services = this.getServices();

        if (services.size() == 0) {
            em = "none";
        } else {
            while (services.size() > 0) {
                em = em + services.removeAny() + ", \n";
            }
        }

        String basePrice = "Base Price: $" + this.getBasePrice() + "\n";
        String totalPrice = "Total Price: $" + this.calculateTotalPrice()
                + "\n";

        String everything = customer + length + type + service + em + basePrice
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

        if (!this.getCustomerName().equals(other.getCustomerName())) {
            return false;
        }
        if (this.getLength() != other.getLength()) {
            return false;
        }
        if (this.getPolishType() != other.getPolishType()) {
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
