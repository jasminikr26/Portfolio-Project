
/**
 * Enhanced interface for a NailAppointment component.
 *
 * <p>
 * This interface adds secondary operations on top of the
 * {@code NailAppointmentKernel} methods, such as computing prices and
 * generating receipts.
 * </p>
 *
 * @author Jasmin Ikromova
 */

public interface NailAppointment extends NailAppointmentKernel {

    /**
     * Possible nail lengths for an appointment.
     */
    enum NailLength {
        SHORT, MEDIUM, LONG
    }

    /**
     * Possible polish types for an appointment.
     */
    enum PolishType {
        REGULAR, GELX, ACRYLIC
    }

    /**
     * Returns the base price for this appointment, based on length and polish
     * type only (no add-on services).
     *
     * @return the base price in whole currency units
     * @ensures <pre>
     * basePrice = [price determined only by the current nail length
     *              and polish type stored in this]  and
     * this = #this
     * </pre>
     */
    int getBasePrice();

    /**
     * Returns the total price for this appointment, including any add-on
     * services.
     *
     * @return the total price in whole currency units
     * @ensures <pre>
     * totalPrice = [basePrice(this) plus the cost of all services
     *               currently stored in this]  and
     * this = #this
     * </pre>
     */
    int calculateTotalPrice();

    /**
     * Reports whether this appointment request is considered valid. For
     * example, an appointment might be valid if a customer name, length, and
     * polish type have been chosen.
     *
     * @return true if the appointment is valid, false otherwise
     * @ensures <pre>
     * isValidRequest =
     *   [this has at least the minimum required information to be
     *    scheduled as an appointment]  and
     * this = #this
     * </pre>
     */
    boolean isValidRequest();

    /**
     * Returns a human-readable summary (receipt) of this appointment, including
     * customer name, options, and total price.
     *
     * @return a formatted summary of this appointment
     * @ensures <pre>
     * receipt = [a string describing the customer name, nail length,
     *            polish type, services, and total price of this]  and
     * this = #this
     * </pre>
     */
    String receipt();

}
