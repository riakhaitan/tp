package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FILTER_DATE;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.expense.ExpenseDateIsParsedDatePredicate;

/**
 * Filters expenses on expense expert.
 */
public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Filters expenses by date in [yyyy-mm] or [yyyy-mm-dd] format. \n"
            + "Parameters: "
            + PREFIX_FILTER_DATE + "FILTER_DATE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_FILTER_DATE + "2022-03 \n\n";

    public static final String MESSAGE_SUCCESS = "Expense(s) filtered: %1$s";

    private final ExpenseDateIsParsedDatePredicate predicate;

    /**
     * Creates an FilterCommand to add the filter {@code Expense} by date/month.
     */
    public FilterCommand(ExpenseDateIsParsedDatePredicate predicate) {
        requireNonNull(predicate);
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredExpenseList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_EXPENSES_LISTED_OVERVIEW, model.getFilteredExpenseList().size()));
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FilterCommand // instanceof handles nulls
                && predicate.equals(((FilterCommand) other).predicate)); // state check
    }
}
