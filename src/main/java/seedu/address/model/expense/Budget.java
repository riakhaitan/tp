package seedu.address.model.expense;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents the Budget in the Expense Expert.
 */
public class Budget {
    /**
     * Attribute fields
     */
    private final Amount budgetAmount;
    private final Date budgetDate;

    /**
     * Constructs a (@code Budget).
     * Every field must be present and not null.
     *
     * @param budgetAmount is valid non-null amount
     * @param budgetDate is valid non-null date
     */
    public Budget(Amount budgetAmount, Date budgetDate) {
        requireAllNonNull(budgetAmount, budgetDate);
        this.budgetAmount = budgetAmount;
        this.budgetDate = budgetDate;
    }

    public Amount getBudgetAmount() {
        return this.budgetAmount;
    }

    public Date getBudgetDate() {
        return this.budgetDate;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Budget amount: ")
                .append(getBudgetAmount())
                .append("; Budget set on: ")
                .append(getBudgetDate());

        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Budget)) {
            return false;
        }

        Budget otherBudget = (Budget) other;
        return otherBudget.getBudgetAmount().equals(getBudgetAmount())
                && otherBudget.getBudgetDate().equals(getBudgetDate());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(budgetAmount, budgetDate);
    }
}
