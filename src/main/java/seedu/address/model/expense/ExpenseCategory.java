package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;

public class ExpenseCategory {
    public final String expenseCategory;

    public ExpenseCategory(String expenseCategory) {
        requireNonNull(expenseCategory);
        this.expenseCategory = expenseCategory;
    }

    @Override
    public String toString() {
        return expenseCategory;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseCategory // instanceof handles nulls
                && expenseCategory.equals(((ExpenseCategory) other).expenseCategory)); // state check
    }

    @Override
    public int hashCode() {
        return expenseCategory.hashCode();
    }
}
