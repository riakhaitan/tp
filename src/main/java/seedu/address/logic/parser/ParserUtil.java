package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.ExpenseDate;
import seedu.address.model.person.PersonAmount;
import seedu.address.model.person.PersonName;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Description parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }

    /**
     * Parses a {@code String expenseCategory} into a {@code ExpenseCategory}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static ExpenseCategory parseExpenseCategory(String expenseCategory) throws ParseException {
        requireNonNull(expenseCategory);
        String trimmedExpenseCategory = expenseCategory.trim();
        if (!ExpenseCategory.isValidExpenseCategory(trimmedExpenseCategory)) {
            throw new ParseException(ExpenseCategory.MESSAGE_CONSTRAINTS);
        }
        return new ExpenseCategory(trimmedExpenseCategory);
    }

    /**
     * Parses a {@code String amount} into an {@code Amount}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code amount} is invalid.
     */
    public static Amount parseAmount(String amount) throws ParseException {
        requireNonNull(amount);
        String trimmedAmount = amount.trim();
        if (!Amount.isValidAmount(trimmedAmount)) {
            throw new ParseException(Amount.MESSAGE_CONSTRAINTS);
        }
        return new Amount(trimmedAmount);
    }

    /**
     * Parses a {@code String budget} into an {@code Budget}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code budget} is invalid.
     */
    public static Budget parseBudget(String budget) throws ParseException {
        requireNonNull(budget);
        String trimmedBudget = budget.trim();
        if (!Budget.isValidBudget(trimmedBudget)) {
            throw new ParseException(Budget.MESSAGE_CONSTRAINTS);
        }
        return new Budget(trimmedBudget);
    }

    /**
     * Parses the expense date for the expense.
     * @param expenseDate expense date given to parse.
     * @return Expense date with the input date.
     * @throws ParseException if the input given is wrong.
     */
    public static ExpenseDate parseDate(String expenseDate) throws ParseException {
        requireNonNull(expenseDate);
        String trimmedDate = expenseDate.trim();
        if (!ExpenseDate.isValidExpenseDate(trimmedDate)) {
            throw new ParseException(ExpenseDate.MESSAGE_CONSTRAINTS);
        }
        return new ExpenseDate(trimmedDate);
    }

    public static PersonAmount parsePersonAmount(String personAmount) throws ParseException {
        requireNonNull(personAmount);
        String trimmedPersonAmount = personAmount.trim();
        if (!PersonAmount.isValidPersonAmount(trimmedPersonAmount)) {
            throw new ParseException(PersonAmount.MESSAGE_CONSTRAINTS);
        }
        return new PersonAmount(trimmedPersonAmount);
    }

    public static PersonName parsePersonName(String personName) throws ParseException {
        requireNonNull(personName);
        String trimmedPersonName = personName.trim();
        if (!PersonName.isValidPersonName(trimmedPersonName)) {
            throw new ParseException(PersonName.MESSAGE_CONSTRAINTS);
        }
        return new PersonName(trimmedPersonName);
    }
}
