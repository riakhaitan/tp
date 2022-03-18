package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static seedu.address.testutil.TypicalExpenses.MAY_BUDGET;

import org.junit.jupiter.api.Test;

import seedu.address.model.budget.Budget;

public class JsonAdaptedBudgetTest {
    private static final String VALID_BUDGET = "900";

    @Test
    public void toModelType_validBudgetDetails_returnsBudget() throws Exception {
        JsonAdaptedBudget budget = new JsonAdaptedBudget(VALID_BUDGET);
        assertEquals(new Budget("900"), budget.toModelType());
    }
}
