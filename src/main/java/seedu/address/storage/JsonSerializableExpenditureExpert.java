package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ExpenditureExpert;
import seedu.address.model.ReadOnlyExpenditureExpert;
import seedu.address.model.expense.Expense;

/**
 * An Immutable ExpenditureExpert that is serializable to JSON format.
 */
@JsonRootName(value = "expenditureexpert")
class JsonSerializableExpenditureExpert {

    public static final String MESSAGE_DUPLICATE_EXPENSE = "Expenses list contains duplicate expense(s).";

    private final List<JsonAdaptedExpense> expenses = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableExpenditureExpert} with the given persons.
     */
    @JsonCreator
    public JsonSerializableExpenditureExpert(@JsonProperty("expenses") List<JsonAdaptedExpense> expenses) {
        this.expenses.addAll(expenses);
    }

    /**
     * Converts a given {@code ReadOnlyExpenditureExpert} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableExpenditureExpert}.
     */
    public JsonSerializableExpenditureExpert(ReadOnlyExpenditureExpert source) {
        expenses.addAll(source.getExpenseList().stream().map(JsonAdaptedExpense::new).collect(Collectors.toList()));
    }

    /**
     * Converts this Expenditure Expert into the model's {@code ExpenditureExpert} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ExpenditureExpert toModelType() throws IllegalValueException {
        ExpenditureExpert expenditureExpert = new ExpenditureExpert();
        for (JsonAdaptedExpense jsonAdaptedExpense : expenses) {
            Expense expense = jsonAdaptedExpense.toModelType();
            if (expenditureExpert.hasExpense(expense)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_EXPENSE);
            }
            expenditureExpert.addExpense(expense);
        }
        return expenditureExpert;
    }

}
