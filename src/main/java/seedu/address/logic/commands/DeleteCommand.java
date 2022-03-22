package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
// import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;

/**
 * Deletes a expense identified using it's displayed index from the expense expert.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the expense identified by the index number used in the displayed expense list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1\n\n";

    public static final String MESSAGE_DELETE_EXPENSE_SUCCESS = "Deleted expense: %1$s";
    // public static final String BUDGET_EDITED = "Budget allowance for this month is now: %1$s";

    private final Index targetIndex;

    public DeleteCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Expense> lastShownList = model.getFilteredExpenseList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX);
        }

        Expense expenseToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteExpense(expenseToDelete);
        // Budget newBudget = resultingBudget(model.getBudget(), expenseToDelete);
        // model.setBudget(newBudget);

        return new CommandResult(String.format(MESSAGE_DELETE_EXPENSE_SUCCESS, expenseToDelete));

        // return new CommandResult(String.format(MESSAGE_DELETE_EXPENSE_SUCCESS, expenseToDelete)
        //         + "\n\n"
        //         + String.format(BUDGET_EDITED, newBudget));
    }

    // /**
    //  * Calculates the remaining budget after an old expense has been deleted
    //  * @param initial budget left for the month
    //  * @param value of expense to be added back to budget allowance for the month
    //  * @return value of budget as a Budget object
    //  */
    // private Budget resultingBudget(Budget initial, Expense value) {
    //     return new Budget(initial.asInt() + value.getAmount().asInt());
    // }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    }
}
