package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Expense's amount in the Expenditure Expert.
 * Guarantees: immutable; is valid as declared in {@link #isValidAmount(String)}
 */
public class Amount {
    /**
     * Only accepts valid amount format, amount must be in numerical value and cannot be in range or else it cannot be
     * converted into float for summation.
     */
    public static final String VALIDATION_REGEX =
            "^\\$?([1-9]{1}[0-9]{0,2}(\\,[0-9]{3})*(\\.[0-9]{0,2})?|[1-9]{1}[0-9]{0,}"
                    + "(\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|(\\.[0-9]{1,2})?)$";

    public static final String MESSAGE_CONSTRAINTS =
            "Amount should only contain numerical characters and decimal, in valid number format.";

    public final String amount;

    /**
     * Constructs a (@code Amount).
     *
     * @param amount A valid amount.
     */
    public Amount(String amount) {
        requireNonNull(amount);
        checkArgument(isValidAmount(amount), MESSAGE_CONSTRAINTS);
        this.amount = amount;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidAmount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Amount // instanceof handles nulls
                && amount.equals(((Amount) other).amount)); // state check
    }
}
