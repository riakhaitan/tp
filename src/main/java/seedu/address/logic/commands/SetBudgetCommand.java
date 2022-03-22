package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_BUDGET;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.budget.Budget;

/**
 * Sets the monthly budget for the expense expert.
 */
public class SetBudgetCommand extends Command {

    public static final String COMMAND_WORD = "budget";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sets the monthly budget for Expense Expert. "
            + "Parameters: "
            + PREFIX_BUDGET + "BUDGET "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_BUDGET + "500";

    public static final String MESSAGE_SUCCESS = "Monthly budget set to: %1$s";

    private final Budget budget;

    /**
     * Creates an SetBudgetCommand to set the specified {@code Budget}
     */
    public SetBudgetCommand(Budget budget) {
        requireNonNull(budget);
        this.budget = budget;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.setBudget(budget);
        return new CommandResult(String.format(MESSAGE_SUCCESS, budget));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SetBudgetCommand // instanceof handles nulls
                && budget.equals(((SetBudgetCommand) other).budget));
    }
}
