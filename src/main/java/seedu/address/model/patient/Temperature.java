package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

//@@author chiamyunqing
/**
 * Represents a Patient's temperature recorded in the app.
 * A valid temperature must be to 1 decimal place,
 * as declared in {@link #isValidTemperature(String)}.
 * Guarantees: immutable.
 */
public class Temperature {
    public static final String MESSAGE_CONSTRAINTS =
            "Temperature should only contain numbers, and it should be to one decimal place. (E.g. 36.0)";
    public static final String VALIDATION_REGEX = "\\d\\d[.]\\d";
    private final double value;

    /**
     * Constructs a {@code Temperature}.
     * @param temperature A valid temperature.
     */
    public Temperature(String temperature) {
        requireNonNull(temperature);
        checkArgument(isValidTemperature(temperature), MESSAGE_CONSTRAINTS); //ensures temp is always to 1 d.p.
        value = Double.parseDouble(temperature);
    }

    /**
     * Returns true if a given string is a valid temperature.
     */
    public static boolean isValidTemperature(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the float value of the temperature reading.
     */
    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Temperature // instanceof handles nulls
                && value == ((Temperature) other).getValue()); // state check
    }

    @Override
    public int hashCode() {
        return Double.toString(value).hashCode();
    }
}
