package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_CATEGORY_TRANSPORT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_DATE_BUILD_A_BEAR;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_SPOTIFY;
import static seedu.address.testutil.TypicalExpenses.BUILD_A_BEAR;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ExpenseBuilder;

public class ExpenseTest {

    @Test
    public void equals() {
        // same values -> returns true
        Expense aliceCopy = new ExpenseBuilder(ANNUAL_SPOTIFY).build();
        assertTrue(ANNUAL_SPOTIFY.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ANNUAL_SPOTIFY.equals(ANNUAL_SPOTIFY));

        // null -> returns false
        assertFalse(ANNUAL_SPOTIFY.equals(null));

        // different type -> returns false
        assertFalse(ANNUAL_SPOTIFY.equals(5));

        // different expense -> returns false
        assertFalse(ANNUAL_SPOTIFY.equals(BUILD_A_BEAR));

        // different amount -> returns false
        Expense editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withAmount(VALID_AMOUNT_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));

        // different description -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));

        // different expenseCategory -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withExpenseCategory(VALID_EXPENSE_CATEGORY_TRANSPORT)
                .build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));

        // different expenseDate -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withExpenseDate(VALID_EXPENSE_DATE_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));
    }
}
