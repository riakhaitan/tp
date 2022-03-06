package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPENSE_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ExpenditureExpert;
import seedu.address.model.Model;
import seedu.address.model.expense.DescriptionContainsKeywordsPredicate;
import seedu.address.testutil.EditExpenseDescriptorBuilder;
import seedu.address.model.expense.Expense;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    /*
    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";
    */
    public static final String VALID_DESCRIPTION_ANNUAL_SPOTIFY = "Annual Spotify Fees";
    public static final String VALID_DESCRIPTION_BUILD_A_BEAR = "Build a Bear Workshop";
    public static final String VALID_EXPENSE_CATEGORY_ENTERTAINMENT= "Entertainment";
    public static final String VALID_AMOUNT_ANNUAL_SPOTIFY = "200";
    public static final String VALID_AMOUNT_BUILD_A_BEAR = "80";

    public static final String VALID_DESCRIPTION_DESC_ANNUAL_SPOTIFY = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_ANNUAL_SPOTIFY;
    public static final String VALID_DESCRIPTION_DESC_BUILD_A_BEAR = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_BUILD_A_BEAR;
    public static final String VALID_EXPENSE_CATEGORY_DESC_ENTERTAINMENT = " " + PREFIX_EXPENSE_CATEGORY + VALID_EXPENSE_CATEGORY_ENTERTAINMENT;
    public static final String VALID_AMOUNT_DESC_ANNUAL_SPOTIFY = " " + PREFIX_AMOUNT + VALID_AMOUNT_ANNUAL_SPOTIFY;
    public static final String VALID_AMOUNT_DESC_BUILD_A_BEAR = " " + PREFIX_AMOUNT + VALID_AMOUNT_BUILD_A_BEAR;

    public static final EditCommand.EditExpenseDescriptor DESC_ANNUAL_SPOTIFY_FEES;
    public static final EditCommand.EditExpenseDescriptor DESC_BUILD_A_BEAR;

    static {
        DESC_ANNUAL_SPOTIFY_FEES = new EditExpenseDescriptorBuilder()
                .withDescription(VALID_DESCRIPTION_ANNUAL_SPOTIFY)
                .withExpenseCategory(VALID_EXPENSE_CATEGORY_ENTERTAINMENT)
                .withAmount(VALID_AMOUNT_ANNUAL_SPOTIFY).build();
        DESC_BUILD_A_BEAR = new EditExpenseDescriptorBuilder()
                .withDescription(VALID_DESCRIPTION_BUILD_A_BEAR)
                .withExpenseCategory(VALID_EXPENSE_CATEGORY_ENTERTAINMENT)
                .withAmount(VALID_AMOUNT_BUILD_A_BEAR).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - Expenditure Expert, filtered expense list and selected expense in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        ExpenditureExpert expectedExpenditureExpert = new ExpenditureExpert(actualModel.getExpenditureExpert());
        List<Expense> expectedFilteredList = new ArrayList<>(actualModel.getFilteredExpenseList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedExpenditureExpert, actualModel.getExpenditureExpert());
        assertEquals(expectedFilteredList, actualModel.getFilteredExpenseList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the expense at the given {@code targetIndex} in the
     * {@code model}'s ExpenditureExpert.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredExpenseList().size());

        Expense expense = model.getFilteredExpenseList().get(targetIndex.getZeroBased());
        final String[] splitName = expense.getDescription().description.split("\\s+");
        model.updateFilteredExpenseList(new DescriptionContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredExpenseList().size());
    }

}
