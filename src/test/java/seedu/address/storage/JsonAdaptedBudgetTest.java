package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static seedu.address.storage.JsonAdaptedBudget.MISSING_FIELD_MESSAGE_FORMAT;
// import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.MAY_BUDGET;

import org.junit.jupiter.api.Test;

// import seedu.address.commons.exceptions.IllegalValueException;
// import seedu.address.model.budget.Budget;

public class JsonAdaptedBudgetTest {

    private static final String INVALID_BUDGET = "#1";

    private static final String VALID_BUDGET = MAY_BUDGET.getBudget();

    @Test
    public void toModelType_validBudgetDetails_returnsBudget() throws Exception {
        JsonAdaptedBudget budget = new JsonAdaptedBudget(VALID_BUDGET);
        assertEquals(MAY_BUDGET, budget.toModelType());
    }

    // @Test
    // public void toModelType_invalidBudget_throwsIllegalValueException() {
    //     JsonAdaptedBudget budget = new JsonAdaptedBudget(INVALID_BUDGET);
    //     String expectedMessage = Budget.MESSAGE_CONSTRAINTS;
    //     assertThrows(IllegalValueException.class, expectedMessage, budget::toModelType);
    // }
}
