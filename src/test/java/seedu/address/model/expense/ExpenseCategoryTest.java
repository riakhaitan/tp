package seedu.address.model.expense;

import static seedu.address.testutil.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class ExpenseCategoryTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ExpenseCategory(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidExpense = "";
        assertThrows(IllegalArgumentException.class, () -> new ExpenseCategory(invalidExpense));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> ExpenseCategory.isValidExpenseCategory(null));

        // invalid addresses
        assertFalse(ExpenseCategory.isValidExpenseCategory("")); // empty string
        assertFalse(ExpenseCategory.isValidExpenseCategory(" ")); // spaces only
        assertFalse(ExpenseCategory.isValidExpenseCategory("-")); // special character
        assertFalse(ExpenseCategory.isValidExpenseCategory("[")); // special character


        // valid addresses
        assertTrue(ExpenseCategory.isValidExpenseCategory("Entertainment"));
        assertTrue(ExpenseCategory.isValidExpenseCategory("Public Transport"));
    }
}
