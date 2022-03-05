package seedu.address.model.expense;

import org.junit.jupiter.api.Test;
import seedu.address.model.expense.ExpenseCategory;

import static seedu.address.testutil.Assert.assertThrows;

public class ExpenseCategoryTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ExpenseCategory(null));
    }
}
