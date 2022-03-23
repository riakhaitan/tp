package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class ExpenseDateTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ExpenseDate(null));
    }

    @Test
    public void constructor_invalidExpenseDate_throwsIllegalArgumentException() {
        String invalidExpenseDate = "";
        assertThrows(IllegalArgumentException.class, () -> new ExpenseDate(invalidExpenseDate));
    }

    @Test
    public void isValidExpenseDate() {
        // null address
        assertThrows(NullPointerException.class, () -> ExpenseDate.isValidExpenseDate(null));

        // invalid addresses
        assertFalse(ExpenseDate.isValidExpenseDate("")); // empty string
        assertFalse(ExpenseDate.isValidExpenseDate(" ")); // spaces only
        assertFalse(ExpenseDate.isValidExpenseDate("-")); // special character
        assertFalse(ExpenseDate.isValidExpenseDate("[")); // special character
        assertFalse(ExpenseDate.isValidExpenseDate("asfafasfafsfsa")); // random string of characters
        assertFalse(ExpenseDate.isValidExpenseDate("asad-as-sf")); // replacing numbers with characters
        assertFalse(ExpenseDate.isValidExpenseDate("9999-99-99")); //invalid date
        assertFalse(ExpenseDate.isValidExpenseDate("2022-02-03    ")); //valid date with extra spaces
        assertFalse(ExpenseDate.isValidExpenseDate("2022-02-30")); //30 Feb should be false
        assertFalse(ExpenseDate.isValidExpenseDate("2022-02-29")); //29 Feb should be false as 2022 not leap

        // valid addresses
        assertTrue(ExpenseDate.isValidExpenseDate("2022-03-03"));
        assertTrue(ExpenseDate.isValidExpenseDate("2022-02-28"));
    }
}
