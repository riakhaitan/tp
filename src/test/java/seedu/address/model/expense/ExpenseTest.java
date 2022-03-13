package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.TypicalExpenses.*;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_SPOTIFY;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ExpenseBuilder;

public class ExpenseTest {


    @Test
    public void isSameExpense() {
        // same object -> returns true
        assertTrue(ANNUAL_SPOTIFY.isSameExpense(ANNUAL_SPOTIFY));

        // null -> returns false
        assertFalse(ANNUAL_SPOTIFY.isSameExpense(null));

        // same name, all other attributes different -> returns true
        Expense editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withAmount(VALID_AMOUNT_ANNUAL_SPOTIFY)
                .withDescription(VALID_DESCRIPTION_ANNUAL_SPOTIFY).build();
        assertTrue(ANNUAL_SPOTIFY.isSameExpense(editedSpotify));

        // different name, all other attributes same -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.isSameExpense(editedSpotify));

        // name differs in case, all other attributes same -> returns false
        Expense editedBuildABear = new ExpenseBuilder(BUILD_A_BEAR).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR.toLowerCase()).build();
        assertFalse(BUILD_A_BEAR.isSameExpense(editedBuildABear));

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

        // different person -> returns false
        assertFalse(ANNUAL_SPOTIFY.equals(ANNUAL_NETFLIX_FEES));

        // different name -> returns false
        Expense editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withAmount(VALID_AMOUNT_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));

        // different phone -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR).build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));

        // different email -> returns false
        editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withExpenseCategory(VALID_EXPENSE_CATEGORY_TRANSPORT).build();
        assertFalse(ANNUAL_SPOTIFY.equals(editedSpotify));

    }
}
