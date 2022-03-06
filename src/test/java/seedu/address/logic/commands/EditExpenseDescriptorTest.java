package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_ANNUAL_SPOTIFY_FEES;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_BUILD_A_BEAR;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditCommand.EditExpenseDescriptor;
import seedu.address.testutil.EditExpenseDescriptorBuilder;

public class EditExpenseDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditExpenseDescriptor descriptorWithSameValues = new EditExpenseDescriptor(DESC_ANNUAL_SPOTIFY_FEES);
        assertTrue(DESC_ANNUAL_SPOTIFY_FEES.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_ANNUAL_SPOTIFY_FEES.equals(DESC_ANNUAL_SPOTIFY_FEES));

        // null -> returns false
        assertFalse(DESC_ANNUAL_SPOTIFY_FEES.equals(null));

        // different types -> returns false
        assertFalse(DESC_ANNUAL_SPOTIFY_FEES.equals(5));

        // different values -> returns false
        assertFalse(DESC_ANNUAL_SPOTIFY_FEES.equals(DESC_BUILD_A_BEAR));

        // different name -> returns false
        EditExpenseDescriptor editedAnnualNetflix = new EditExpenseDescriptorBuilder(DESC_ANNUAL_SPOTIFY_FEES).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR).build();
        assertFalse(DESC_ANNUAL_SPOTIFY_FEES.equals(editedAnnualNetflix));

        // different phone -> returns false
        editedAnnualNetflix = new EditExpenseDescriptorBuilder(DESC_ANNUAL_SPOTIFY_FEES).withAmount(VALID_AMOUNT_BUILD_A_BEAR).build();
        assertFalse(DESC_ANNUAL_SPOTIFY_FEES.equals(editedAnnualNetflix));
    }
}
