package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    public static final String MESSAGE_CONSTRAINTS =
            "Date should be in DD-MM-YYYY format!!";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final LocalDate date;

    /**
     * Constructs a {@code Date}
     *
     * @param date A valid date entry.
     */
    public Date(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
    }

    /**
     * Returns true if a given string is a valid date entry.
     */
    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Date && date.equals(((Date) other).date));
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    /**
     * Format state as tet for viewing.
     */
    public String toString() {
        return "[" + date + "]";
    }
}
