package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.expense.Expense;
import seedu.address.model.person.Person;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class PaidPersonWhoOwedCommand extends Command{

    public static final String COMMAND_WORD = "paid";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Removed the person who has paid/has been paid the money they/you owed.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1\n\n";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Removed person: %1$s";
    // public static final String BUDGET_EDITED = "Budget allowance for this month is now: %1$s";

    private final Index targetIndex;

    public PaidPersonWhoOwedCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToRemove = lastShownList.get(targetIndex.getZeroBased());
        model.deletePerson(personToRemove);

        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, personToRemove));


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
                || (other instanceof PaidPersonWhoOwedCommand // instanceof handles nulls
                && targetIndex.equals(((PaidPersonWhoOwedCommand) other).targetIndex)); // state check
    }
}

