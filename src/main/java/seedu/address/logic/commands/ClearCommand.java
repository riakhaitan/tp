package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.ExpenseExpert;
import seedu.address.model.Model;

/**
 * Clears the expense expert.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Expense Expert has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setExpenseExpert(new ExpenseExpert());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
