package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.AMOUNT_DESC_ANNUAL_SPOTIFY;
import static seedu.address.logic.commands.CommandTestUtil.AMOUNT_DESC_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_ANNUAL_SPOTIFY;
import static seedu.address.logic.commands.CommandTestUtil.DESCRIPTION_DESC_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.EXPENSE_CATEGORY_DESC_ENTERTAINMENT;
import static seedu.address.logic.commands.CommandTestUtil.EXPENSE_DATE_DESC_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_AMOUNT_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_CATEGORY_ENTERTAINMENT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_DATE_BUILD_A_BEAR;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalExpenses.BUILD_A_BEAR;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Expense;
import seedu.address.testutil.ExpenseBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Expense expectedExpense = new ExpenseBuilder(BUILD_A_BEAR).build();

        // multiple descriptions - last description accepted
        assertParseSuccess(parser, DESCRIPTION_DESC_ANNUAL_SPOTIFY + DESCRIPTION_DESC_BUILD_A_BEAR
                + EXPENSE_CATEGORY_DESC_ENTERTAINMENT + AMOUNT_DESC_BUILD_A_BEAR + EXPENSE_DATE_DESC_BUILD_A_BEAR,
                new AddCommand(expectedExpense));

        // multiple amounts - last amount accepted
        assertParseSuccess(parser, DESCRIPTION_DESC_BUILD_A_BEAR + EXPENSE_CATEGORY_DESC_ENTERTAINMENT
                + AMOUNT_DESC_ANNUAL_SPOTIFY + AMOUNT_DESC_BUILD_A_BEAR + EXPENSE_DATE_DESC_BUILD_A_BEAR,
                new AddCommand(expectedExpense));
    }


    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing amount prefix
        assertParseFailure(parser, DESCRIPTION_DESC_BUILD_A_BEAR + EXPENSE_CATEGORY_DESC_ENTERTAINMENT
                        + VALID_AMOUNT_BUILD_A_BEAR + EXPENSE_DATE_DESC_BUILD_A_BEAR,
                expectedMessage);

        // missing description prefix
        assertParseFailure(parser, VALID_DESCRIPTION_BUILD_A_BEAR + EXPENSE_CATEGORY_DESC_ENTERTAINMENT
                        + AMOUNT_DESC_BUILD_A_BEAR + EXPENSE_DATE_DESC_BUILD_A_BEAR,
                expectedMessage);

        // missing expenseCategory prefix
        assertParseFailure(parser, DESCRIPTION_DESC_BUILD_A_BEAR + VALID_EXPENSE_CATEGORY_ENTERTAINMENT
                        + AMOUNT_DESC_BUILD_A_BEAR + EXPENSE_DATE_DESC_BUILD_A_BEAR,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_DESCRIPTION_BUILD_A_BEAR + VALID_EXPENSE_CATEGORY_ENTERTAINMENT
                        + VALID_AMOUNT_BUILD_A_BEAR + VALID_EXPENSE_DATE_BUILD_A_BEAR,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid amount
        assertParseFailure(parser, INVALID_AMOUNT_DESC + DESCRIPTION_DESC_BUILD_A_BEAR
                + EXPENSE_CATEGORY_DESC_ENTERTAINMENT + EXPENSE_DATE_DESC_BUILD_A_BEAR, Amount.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + DESCRIPTION_DESC_BUILD_A_BEAR
                        + EXPENSE_CATEGORY_DESC_ENTERTAINMENT + AMOUNT_DESC_BUILD_A_BEAR
                        + EXPENSE_DATE_DESC_BUILD_A_BEAR,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
