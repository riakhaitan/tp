package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_CATEGORY_TRANSPORT;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_SPOTIFY;
import static seedu.address.testutil.TypicalExpenses.BUILD_A_BEAR;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ExpenseBuilder;

public class ExpenseTest {


    @Test
    public void isSameExpense() {
        // same object -> returns true
        assertTrue(ANNUAL_SPOTIFY.isSameExpense(ANNUAL_SPOTIFY));

        // null -> returns false
        assertFalse(ANNUAL_SPOTIFY.isSameExpense(null));

        // different description, all other attributes same -> returns false
        Expense editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR)
                .build();
        assertFalse(ANNUAL_SPOTIFY.isSameExpense(editedSpotify));

        // different amount, all other attributes same -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withAmount(VALID_AMOUNT_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.isSameExpense(editedSpotify));

        // different expense category, all other attributes same -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withExpenseCategory(VALID_EXPENSE_CATEGORY_TRANSPORT)
                .build();
        assertTrue(ANNUAL_SPOTIFY.isSameExpense(editedSpotify));

        // name differs in case, all other attributes same -> returns false
        Expense editedBuildABear = new ExpenseBuilder(BUILD_A_BEAR)
                .withDescription(VALID_DESCRIPTION_BUILD_A_BEAR.toLowerCase()).build();
        assertFalse(BUILD_A_BEAR.isSameExpense(editedBuildABear));

        // TODO: date differs in case, all other attributes same -> returns false

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_DESCRIPTION_BUILD_A_BEAR + " ";
        editedBuildABear = new ExpenseBuilder(BUILD_A_BEAR).withDescription(nameWithTrailingSpaces).build();
        assertFalse(BUILD_A_BEAR.isSameExpense(editedBuildABear));
    }

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

        // different date -> returns false

    }
}
