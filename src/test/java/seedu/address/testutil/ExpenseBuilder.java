package seedu.address.testutil;

import seedu.address.model.expense.Expense;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.Amount;

/**
 * A utility class to help with building Expense objects.
 */
public class ExpenseBuilder {

    public static final String DEFAULT_DESCRIPTION = "Grab";
    public static final String DEFAULT_EXPENSE_CATEGORY = "Transport";
    public static final String DEFAULT_AMOUNT = "15";

    private Description description;
    private ExpenseCategory expenseCategory;
    private Amount amount;

    /**
     * Creates a {@code ExpenseBuilder} with the default details.
     */
    public ExpenseBuilder() {
        description = new Description(DEFAULT_DESCRIPTION);
        expenseCategory = new ExpenseCategory(DEFAULT_EXPENSE_CATEGORY);
        amount = new Amount(DEFAULT_AMOUNT);
    }

    /**
     * Initializes the ExpenseBuilder with the data of {@code expenseToCopy}.
     */
    public ExpenseBuilder(Expense expenseToCopy) {
        description = expenseToCopy.getDescription();
        expenseCategory = expenseToCopy.getExpenseCategory();
        amount = expenseToCopy.getAmount();
    }

    /**
     * Sets the {@code Description} of the {@code Expense} that we are building.
     */
    public ExpenseBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code ExpenseCategory} of the {@code Expense} that we are building.
     */
    public ExpenseBuilder withExpenseCategory(String expenseCategory) {
        this.expenseCategory = new ExpenseCategory(expenseCategory);
        return this;
    }

    /**
     * Sets the {@code Amount} of the {@code Expense} that we are building.
     */
    public ExpenseBuilder withAmount(String amount) {
        this.amount = new Amount(amount);
        return this;
    }

    public Expense build() {
        return new Expense(description, expenseCategory, amount);
    }

}
