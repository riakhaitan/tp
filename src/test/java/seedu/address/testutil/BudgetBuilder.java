package seedu.address.testutil;

import seedu.address.model.budget.Budget;

/**
 * A utility class to help with building Budget objects.
 */
public class BudgetBuilder {

    public static final String DEFAULT_BUDGET = "525";

    private String budget;

    /**
     * Creates a {@code BudgetBuilder} with the default details.
     */
    public BudgetBuilder() {
        budget = DEFAULT_BUDGET;
    }

    /**
     * Initializes the BudgetBuilder with the data of {@code budgetToCopy}.
     */
    public BudgetBuilder(Budget budgetToCopy) {
        budget = budgetToCopy.getBudget();
    }

    /**
     * Sets the value of the {@code Budget} that we are building.
     */
    public BudgetBuilder withBudget(String budget) {
        this.budget = budget;
        return this;
    }

    public Budget build() {
        return new Budget(budget);
    }
}
