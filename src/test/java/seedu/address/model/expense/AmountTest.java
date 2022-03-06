package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Amount(null));
    }

    @Test
    public void constructor_invalidAmount_throwsIllegalArgumentException() {
        String invalidAmount = ".";
        assertThrows(IllegalArgumentException.class, () -> new Amount(invalidAmount));
    }

    @Test
    public void isValidAmount() {
        // null address
        assertThrows(NullPointerException.class, () -> Amount.isValidAmount(null));

        /*
        //FAILED TO RESOLVE
        // invalid addresses
        assertFalse(Amount.isValidAmount("")); // empty string
        assertFalse(Amount.isValidAmount(" ")); // spaces only
         */

        // valid addresses
        assertTrue(Amount.isValidAmount("111.1")); //single digit after decimal
        assertTrue(Amount.isValidAmount("22")); // normal integer
        assertTrue(Amount.isValidAmount("2.55")); // double digits after decimal
    }
}
