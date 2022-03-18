package seedu.address.model.budget;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the budgeted amount in the Expense Expert.
 * Guarantees: immutable; is valid as declared in {@link #isValidBudget(String)}
 */
public class Budget {
    /**
     * Only accepts valid amount format, amount must be in numerical value and cannot be in range or else it cannot be
     * converted into float for summation.
     */
    public static final String VALIDATION_REGEX =
            "^\\$?([1-9]{1}[0-9]{0,2}(\\,[0-9]{3})*(\\.[0-9]{0,2})?|[1-9]{1}[0-9]{0,}"
                    + "(\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|(\\.[0-9]{1,2})?)$";

    public static final String MESSAGE_CONSTRAINTS =
            "Budget should only contain numerical characters and decimal, in valid number format.";

    public final String budget;

    /**
     * Constructs a (@code Budget) from a string.
     *
     * @param budget A valid budget.
     */
    public Budget(String budget) {
        requireNonNull(budget);
        checkArgument(isValidBudget(budget), MESSAGE_CONSTRAINTS);
        this.budget = budget;
    }

    /**
     * Constructs a (@code Budget) from an integer.
     *
     * @param budget A valid budget.
     */
    public Budget(int budget) {
        requireNonNull(budget);
        // checkArgument(isValidBudget(budget), MESSAGE_CONSTRAINTS);
        this.budget = String.valueOf(budget);
    }

    /**
     * Returns true if a given string is a valid budget.
     */
    public static boolean isValidBudget(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the value of the budget as an integer.
     */
    public int asInt() {
        return Integer.valueOf(budget);
    }

    @Override
    public String toString() {
        return this.budget;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Budget // instanceof handles nulls
                && budget.equals(((Budget) other).budget)); // state check
    }
}
