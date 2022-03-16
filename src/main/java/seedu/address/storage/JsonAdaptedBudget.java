package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.budget.Budget;

/**
 * Jackson-friendly version of {@link Budget}.
 */
class JsonAdaptedBudget {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Budget's %s field is missing!";

    private final String budget;

    /**
     * Constructs a {@code JsonAdaptedBudget} with the given Budget details.
     */
    @JsonCreator
    public JsonAdaptedBudget(@JsonProperty("budget") String budget) {
        this.budget = budget;
    }

    /**
     * Converts a given {@code Budget} into this class for Jackson use.
     */
    public JsonAdaptedBudget(Budget source) {
        this.budget = source.getBudget();
    }

    /**
     * Converts this Jackson-friendly adapted Budget object into the model's {@code Budget} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted Budget.
     */
    public Budget toModelType() throws IllegalValueException {
        if (budget == null) {
            throw new IllegalValueException(String.format(
                    MISSING_FIELD_MESSAGE_FORMAT, Budget.class.getSimpleName()));
        }

        return new Budget(budget);
    }
}
