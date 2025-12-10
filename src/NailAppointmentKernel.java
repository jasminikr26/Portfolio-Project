import components.standard.Standard;

/**
 * Kernal interface for a NailAppointment component
 *
 * @author Jasmin Ikromova
 *
 */

public interface NailAppointmentKernel extends Standard<NailAppointment> {

    /**
     * Sets the customer name for this appointment.
     *
     * @param name
     *            the customer's name
     * @updates this
     * @requires name is not null
     * @ensures <pre>
     * [the customer name stored in this is name]
     * </pre>
     */
    void setCustomerName(String name);

    /**
     * Returns the customer name for this appointment.
     *
     * @return the customer's name
     * @ensures <pre>
     * customerName = [the current customer name stored in this]  and
     * this = #this
     * </pre>
     */
    String getCustomerName();

    /**
     * Sets the nail length for this appointment.
     *
     * @param length
     *            the desired nail length
     * @updates this
     * @requires length is not null
     * @ensures <pre>
     * [the nail length stored in this is length]
     * </pre>
     */
    void setLength(NailAppointment.NailLength length);

    /**
     * Returns the nail length for this appointment.
     *
     * @return the nail length
     * @ensures <pre>
     * length = [the current nail length stored in this]  and
     * this = #this
     * </pre>
     */
    NailAppointment.NailLength getLength();

    /**
     * Sets the polish type for this appointment.
     *
     * @param type
     *            the desired polish type
     * @updates this
     * @requires type is not null
     * @ensures <pre>
     * [the polish type stored in this is type]
     * </pre>
     */
    void setPolishType(NailAppointment.PolishType type);

    /**
     * Returns the polish type for this appointment.
     *
     * @return the polish type
     * @ensures <pre>
     * polishType = [the current polish type stored in this]  and
     * this = #this
     * </pre>
     */
    NailAppointment.PolishType getPolishType();

    /**
     * Adds a service to this appointment (e.g., "design", "rhinestones").
     *
     * @param service
     *            the service name
     * @updates this
     * @requires service is not null
     * @ensures <pre>
     * [service is included in the set of services stored in this]
     * </pre>
     */
    void addService(String service);

    /**
     * Reports whether this appointment currently includes the given service.
     *
     * @param service
     *            the service name
     * @return true if this appointment includes the service, false otherwise
     * @requires service is not null
     * @ensures <pre>
     * hasService = [service is included in the set of services stored in this]  and
     * this = #this
     * </pre>
     */
    boolean hasService(String service);
}
