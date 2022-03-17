package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class ExpenseDate {


    public static final String VALIDATION_REGEX = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
    public static final String MESSAGE_CONSTRAINTS =
            "Date should be in a valid format yyyy-mm-dd, and it should not be blank";

    public final String expenseDate;

    /**
     * Constructs a {@code ExpenseCategory}
     *
     * @param expenseDate to indicate the category of the expense.
     */
    public ExpenseDate(String expenseDate) {
        requireNonNull(expenseDate);
        checkArgument(isValidExpenseDate(expenseDate), MESSAGE_CONSTRAINTS);
        this.expenseDate = expenseDate;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidExpenseDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return expenseDate;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseDate // instanceof handles nulls
                && expenseDate.equals(((ExpenseDate) other).expenseDate)); // state check
    }

    @Override
    public int hashCode() {
        return expenseDate.hashCode();
    }
}
