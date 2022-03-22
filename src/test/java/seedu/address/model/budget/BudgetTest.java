package seedu.address.model.budget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

        // invalid Budget
        assertFalse(Budget.isValidBudget("")); // empty string
        assertFalse(Budget.isValidBudget(" ")); // spaces only
        assertFalse(Budget.isValidBudget("111.111")); // 3 d.p
        assertFalse(Budget.isValidBudget(".111")); // 3 d.p
        assertFalse(Budget.isValidBudget(".")); // decimal only
        assertFalse(Budget.isValidBudget("111 111.1")); // space division
        assertFalse(Budget.isValidBudget("111 111.111")); // more than 2 decimal place
        assertFalse(Budget.isValidBudget("11,11111")); // not multiple of 3 comma spacing
        assertFalse(Budget.isValidBudget("1111,111")); // comma spacing
        assertFalse(Budget.isValidBudget("1,111111")); // comma spacing

        // valid Budget
        assertTrue(Budget.isValidBudget("111.1")); // single digit after decimal
        assertTrue(Budget.isValidBudget("0")); // Zero
        assertTrue(Budget.isValidBudget("0.0")); // Zero with decimal
        assertTrue(Budget.isValidBudget("22")); // normal integer
        assertTrue(Budget.isValidBudget("2.55")); // double digits after decimal
        assertTrue(Budget.isValidBudget("0.55")); // double digits after decimal with leading 0
        assertTrue(Budget.isValidBudget(".55")); // double digits after decimal without any whole number
        assertTrue(Budget.isValidBudget(".5")); // single digits after decimal without any whole number
        assertTrue(Budget.isValidBudget("22")); // normal integer
        assertTrue(Budget.isValidBudget("1,111,111")); // comma spacing
        assertTrue(Budget.isValidBudget("1,111,111.11")); // comma spacing with decimals

    }

    @Test
    public void asInt() {
        assertEquals(111, (new Budget("111")).asInt());
    }
}
