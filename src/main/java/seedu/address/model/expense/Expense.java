package seedu.address.model.expense;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

public class Expense {
    // Identity fields
    private final Description description;
    private final ExpenseCategory expenseCategory;
    private final Amount amount;


    /**
     * Every field must be present and not null.
     */
    public Expense(Description description, ExpenseCategory expenseCategory, Amount amount) {
        requireAllNonNull(description, expenseCategory, amount);
        this.description = description;
        this.expenseCategory = expenseCategory;
        this.amount = amount;
    }

    public Description getDescription() {
        return description;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public Amount getAmount() {
        return amount;
    }

    /**
     * Check if two Expense objects are the same or have the same content.
     *
     * @param otherExpense Expense object that is being compared to.
     * @return true if they same or have the same content and false otherwise.
     */
    public boolean isSameExpense(Expense otherExpense) {
        if (otherExpense == this) {
            return true;
        }

        return otherExpense != null
                && otherExpense.getDescription().equals(getDescription())
                && otherExpense.getAmount().equals(getAmount())
                && otherExpense.getExpenseCategory().equals(getExpenseCategory());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Expense)) {
            return false;
        }

        Expense otherExpense = (Expense) other;
        return otherExpense.getDescription().equals(getDescription())
                && otherExpense.getExpenseCategory().equals(getExpenseCategory())
                && otherExpense.getAmount().equals(getAmount());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, expenseCategory, amount);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append("; Category: ")
                .append(getExpenseCategory())
                .append("; Amount: ")
                .append(getAmount());

        return builder.toString();
    }
}
