package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.FILTER_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FILTER_DATE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_FILTER_DATE_DESC;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.model.expense.ExpenseDateIsParsedDatePredicate;


public class FilterCommandParserTest {

    private FilterCommandParser parser = new FilterCommandParser();

    @Test
    public void parse_validDate_success() {
        FilterCommand expectedFilterCommand =
                new FilterCommand(new ExpenseDateIsParsedDatePredicate(VALID_FILTER_DATE));
        assertParseSuccess(parser, FILTER_DATE_DESC, expectedFilterCommand);
    }

    @Test
    public void parse_invalidDate_failure() {
        assertParseFailure(parser, INVALID_FILTER_DATE_DESC,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_missingField_failure() {
        //No prefix
        assertParseFailure(parser, VALID_FILTER_DATE,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
    }

}
