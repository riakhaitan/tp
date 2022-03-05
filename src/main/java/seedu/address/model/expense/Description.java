package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;

/**
 * Represents an Expense's description in the Expenditure Expert.
 */
public class Description {

    public final String description;

    public Description(String description) {
        requireNonNull(description);
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Description // instanceof handles nulls
                && description.equals(((Description) other).description)); // state check
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
