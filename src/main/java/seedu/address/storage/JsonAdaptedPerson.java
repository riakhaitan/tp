package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.Description;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.Amount;

/**
 * Jackson-friendly version of {@link Expense}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String description;
    private final String expenseCategory;
    private final String amount;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("description") String description, @JsonProperty("expenseCategory") String expenseCategory,
            @JsonProperty("amount") String amount) {
        this.description = description;
        this.expenseCategory = expenseCategory;
        this.amount = amount;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Expense source) {
        description = source.getDescription().description;
        expenseCategory = source.getExpenseCategory().expenseCategory;
        amount = source.getAmount().amount;
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Expense toModelType() throws IllegalValueException {
        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }
        final Description modelDescription = new Description(description);

        if (expenseCategory == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, ExpenseCategory.class.getSimpleName()));
        }
        final ExpenseCategory modelExpenseCategory = new ExpenseCategory(expenseCategory);

        if (amount == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName()));
        }
        if (!Amount.isValidAmount(amount)) {
            throw new IllegalValueException(Amount.MESSAGE_CONSTRAINTS);
        }
        final Amount modelAmount = new Amount(amount);
    }

}
