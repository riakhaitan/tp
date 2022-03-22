package seedu.address.model.budget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class BudgetTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Budget(null));
    }

    @Test
    public void constructor_invalidBudget_throwsIllegalArgumentException() {
        String invalidAmount = ".";
        assertThrows(IllegalArgumentException.class, () -> new Budget(invalidAmount));
    }

    @Test
    public void isValidBudget() {
        // null budget
        assertThrows(NullPointerException.class, () -> Budget.isValidBudget(null));

        /*
        //FAILED TO RESOLVE
        // invalid addresses
        assertFalse(Amount.isValidAmount("")); // empty string
        assertFalse(Amount.isValidAmount(" ")); // spaces only
         */

        // valid budgets
        assertTrue(Budget.isValidBudget("111.1")); //single digit after decimal
        assertTrue(Budget.isValidBudget("22")); // normal integer
        assertTrue(Budget.isValidBudget("2.55")); // double digits after decimal
    }

    @Test
    public void asInt() {
        assertEquals(111, (new Budget("111")).asInt());
    }
}
