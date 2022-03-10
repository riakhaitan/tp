package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_EXPENSE;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.ExpenseCategory;

public class ParserUtilTest {

    private static final String INVALID_AMOUNT = "1..2";

    private static final String VALID_DESCRIPTION = "Groceries from ShengShiong";
    private static final String VALID_EXPENSE_CATEGORY = "Groceries";
    private static final String VALID_AMOUNT = "1.2";

    private static final String WHITESPACE = " \t\r\n";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_EXPENSE, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_EXPENSE, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseDescription_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseDescription((String) null));
    }

    @Test
    public void parseDescription_validValueWithWhitespace_returnsTrimmedDescription() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_DESCRIPTION + WHITESPACE;
        Description expectedDescription = new Description(VALID_DESCRIPTION);
        assertEquals(expectedDescription, ParserUtil.parseDescription(nameWithWhitespace));
    }

    @Test
    public void parseExpenseCategory_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseExpenseCategory((String) null));
    }

    @Test
    public void parseExpenseCategory_validValueWithoutWhitespace_returnsExpenseCategory() throws Exception {
        ExpenseCategory expectedExpenseCategory = new ExpenseCategory(VALID_EXPENSE_CATEGORY);
        assertEquals(expectedExpenseCategory, ParserUtil.parseExpenseCategory(VALID_EXPENSE_CATEGORY));
    }

    @Test
    public void parseAmount_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseAmount((String) null));
    }

    @Test
    public void parseAmount_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAmount(INVALID_AMOUNT));
    }

    @Test
    public void parseAmount_validValueWithoutWhitespace_returnsAmount() throws Exception {
        Amount expectedAmount = new Amount(VALID_AMOUNT);
        assertEquals(expectedAmount, ParserUtil.parseAmount(VALID_AMOUNT));
    }

    @Test
    public void parseAmount_validValueWithWhitespace_returnsTrimmedAmount() throws Exception {
        String amountWithWhitespace = WHITESPACE + VALID_AMOUNT + WHITESPACE;
        Amount expectedAmount = new Amount(VALID_AMOUNT);
        assertEquals(expectedAmount, ParserUtil.parseAmount(amountWithWhitespace));
    }
}
