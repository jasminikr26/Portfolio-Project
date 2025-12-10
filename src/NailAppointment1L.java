import components.set.Set;
import components.set.Set1L;

/**
 * Kernel implementation for {@code NailAppointment}.
 *
 * @author Jasmin Ikromova
 *
 * @convention <pre>
 * customerName is not null  and
 * length is not null  and
 * polishType is not null  and
 * services is not null  and
 * for all s in services: s is not null
 * </pre>
 *
 * @correspondence <pre>
 * [abstract customer name] = this.customerName  and
 * [abstract nail length]   = this.length        and
 * [abstract polish type]   = this.polishType    and
 * [abstract services set]  = this.services
 * </pre>
 */
public class NailAppointment1L extends NailAppointmentSecondary {

    private String customerName;
    private NailAppointment.NailLength length;
    private NailAppointment.PolishType polishType;
    private Set<String> services;

    /**
     * No-argument constructor.
     */
    public NailAppointment1L() {
        this.createNewRep();
    }

    /**
     * Creates a new valid representation.
     */
    private void createNewRep() {
        this.customerName = "";
        this.length = NailAppointment.NailLength.SHORT;
        this.polishType = NailAppointment.PolishType.REGULAR;
        this.services = new Set1L<>();
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public NailAppointment newInstance() {
        return new NailAppointment1L();
    }

    @Override
    public void transferFrom(NailAppointment source) {
        if (source == this) {
            return;
        }

        this.customerName = source.getCustomerName();
        this.length = source.getLength();
        this.polishType = source.getPolishType();

        this.services.clear();
        Set<String> temp = source.getServices();
        while (temp.size() > 0) {
            String s = temp.removeAny();
            this.services.add(s);
        }
        source.clear();
    }

    @Override
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    @Override
    public String getCustomerName() {
        return this.customerName;
    }

    @Override
    public final void setLength(NailLength length) {
        this.length = length;
    }

    @Override
    public NailLength getLength() {
        return this.length;
    }

    @Override
    public void setPolishType(PolishType type) {
        this.polishType = type;
    }

    @Override
    public PolishType getPolishType() {
        return this.polishType;
    }

    @Override
    public void addService(String service) {
        if (!this.services.contains(service)) {
            this.services.add(service);
        }
    }

    @Override
    public boolean hasService(String service) {
        return this.services.contains(service);
    }

    @Override
    public Set<String> getServices() {
        Set<String> copy = new Set1L<>();
        Set<String> temp = new Set1L<>();

        while (this.services.size() > 0) {
            String s = this.services.removeAny();
            copy.add(s);
            temp.add(s);
        }

        while (temp.size() > 0) {
            this.services.add(temp.removeAny());
        }
        return copy;
    }
}
