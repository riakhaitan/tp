package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class DateTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Date(null));
    }

    @Test
    public void constructor_invalidExpenseDate_throwsIllegalArgumentException() {
        String invalidExpenseDate = "";
        assertThrows(IllegalArgumentException.class, () -> new Date(invalidExpenseDate));
    }

    @Test
    public void isValidExpenseDate() {
        // null address
        assertThrows(NullPointerException.class, () -> Date.isValidDate(null));

        // invalid addresses
        assertFalse(Date.isValidDate("")); // empty string
        assertFalse(Date.isValidDate(" ")); // spaces only
        assertFalse(Date.isValidDate("-")); // special character
        assertFalse(Date.isValidDate("[")); // special character
        assertFalse(Date.isValidDate("asfafasfafsfsa")); // random string of characters
        assertFalse(Date.isValidDate("asad-as-sf")); // replacing numbers with characters
        assertFalse(Date.isValidDate("9999-99-99")); //invalid date
        assertFalse(Date.isValidDate("2022-02-03    ")); //valid date with extra spaces
        //assertFalse(Date.isValidDate("2022-02-30")); //30 Feb should be false

        // valid addresses
        assertTrue(Date.isValidDate("2022-03-03"));
        assertTrue(Date.isValidDate("2022-02-29"));
    }
}
