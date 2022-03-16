package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expense.Amount;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.ExpenseDate;

/**
 * Jackson-friendly version of {@link Expense}.
 */
class JsonAdaptedExpense {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Expense's %s field is missing!";

    private final String description;
    private final String expenseCategory;
    private final String amount;
    private final String expenseDate;

    /**
     * Constructs a {@code JsonAdaptedExpense} with the given expense details.
     */
    @JsonCreator
    public JsonAdaptedExpense(@JsonProperty("description") String description,
                              @JsonProperty("expenseCategory") String expenseCategory,
                             @JsonProperty("email") String amount, @JsonProperty("expenseDate") String expenseDate) {
        this.description = description;
        this.expenseCategory = expenseCategory;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    /**
     * Converts a given {@code Expense} into this class for Jackson use.
     */
    public JsonAdaptedExpense(Expense source) {
        description = source.getDescription().description;
        expenseCategory = source.getExpenseCategory().expenseCategory;
        amount = source.getAmount().amount;
        expenseDate = source.getExpenseDate().expenseDate;
    }

    /**
     * Converts this Jackson-friendly adapted expense object into the model's {@code Expense} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted expense.
     */
    public Expense toModelType() throws IllegalValueException {
        if (description == null) {
            throw new IllegalValueException(String.format(
                    MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }
        final Description modelDescription = new Description(description);

        if (expenseCategory == null) {
            throw new IllegalValueException(String.format(
                    MISSING_FIELD_MESSAGE_FORMAT, ExpenseCategory.class.getSimpleName()));
        }
        final ExpenseCategory modelExpenseCategory = new ExpenseCategory(expenseCategory);

        if (amount == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName()));
        }
        if (!Amount.isValidAmount(amount)) {
            throw new IllegalValueException(Amount.MESSAGE_CONSTRAINTS);
        }
        final Amount modelAmount = new Amount(amount);

        if (expenseDate == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, ExpenseDate.class.getSimpleName()));
        }
        if (!ExpenseDate.isValidExpenseDate(expenseDate)) {
            throw new IllegalValueException(Amount.MESSAGE_CONSTRAINTS);
        }
        final ExpenseDate modelDate = new ExpenseDate(expenseDate);

        return new Expense(modelDescription, modelExpenseCategory, modelAmount, modelDate);
    }

}
