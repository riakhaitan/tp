package seedu.address.model.expense;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

public class Expense {
    /**
     * Attribute fields
     */
    private final Description description;
    private final ExpenseCategory expenseCategory;
    private final Amount expenseAmount;
    private final Date expenseDate;

    /**
     * Constructs a (@code Expense).
     * Every field must be present and not null.
     */
    public Expense(Description description, ExpenseCategory expenseCategory, Amount expenseAmount, Date expenseDate) {
        requireAllNonNull(description, expenseCategory, expenseAmount, expenseDate);
        this.description = description;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
    }

    public Description getDescription() {
        return description;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public Amount getAmount() {
        return expenseAmount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    // /**
    //  * Check if two Expense objects are the same or have the same content.
    //  *
    //  * @param otherExpense Expense object that is being compared to.
    //  * @return true if they same or have the same content and false otherwise.
    //  */
    // public boolean isSameExpense(Expense otherExpense) {
    //     if (otherExpense == this) {
    //         return true;
    //     }

    //     return otherExpense != null
    //             && otherExpense.getDescription().equals(getDescription())
    //             && otherExpense.getAmount().equals(getAmount())
    //             && otherExpense.getExpenseCategory().equals(getExpenseCategory());
    // }

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
                && otherExpense.getAmount().equals(getAmount())
                && otherExpense.getExpenseDate().equals(getExpenseDate());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, expenseCategory, expenseAmount, expenseDate);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append("; Category: ")
                .append(getExpenseCategory())
                .append("; Amount: ")
                .append(getAmount())
                .append(("; Expense Date: "))
                .append(getExpenseDate());

        return builder.toString();
    }
}
