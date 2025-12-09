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
public class NailAppointment1L {

    private String customerName;
    private NailLength length;
    private PolishType polishType;
    private Set<String> services;

    private void createNewRep() {
        this.customerName = "";
        this.length = NailLength.SHORT;
        this.polishType = PolishType.REGULAR;
        this.services = new Set1L<>();
    }

    public NailAppointment1() {
        super();
        this.createNewRep();
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final NailAppointment newInstance() {
        return new NailAppointment1();
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
    public NailLength getLength(){
        return this.length
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
    public final boolean hasService(String service) {
        return this.services.contains(service);
    }
}
