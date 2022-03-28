package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Lists all expenses in the expense expert to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all expenses";

    public static final String HELP_COMMAND = COMMAND_WORD + ": Lists all expenses\n\n";

    private static final String INVALID_COMMAND_USAGE = "Invalid command usage";

    private final String commandWordArg;

    public ListCommand(String commandWordArg) {
        this.commandWordArg = commandWordArg;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
        if (commandWordArg.trim().isEmpty()) {
            return new CommandResult(MESSAGE_SUCCESS);
        } else {
            switch (commandWordArg.trim()) {
                case PersonOwesCommand.COMMAND_WORD:
                    model.updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
                    return new CommandResult(PersonOwesCommand.MESSAGE_SUCCESS_LIST);


                default:
                    throw new CommandException(INVALID_COMMAND_USAGE);
            }
        }
    }
}

