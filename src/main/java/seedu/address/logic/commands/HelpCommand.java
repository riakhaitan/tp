package seedu.address.logic.commands;

import java.util.Objects;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.ui.HelpWindow;



/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final StringBuilder HELP_STRING = new StringBuilder();

    public static final String COMMAND_WORD = "help";
    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD + " [COMMAND_WORD]";

    private static final String INVALID_COMMAND_USAGE = "Invalid command usage";

    private final String commandWordArg;

    public HelpCommand(String commandWordArg) {
        this.commandWordArg = commandWordArg;
    }

    /**
     * Format help command
     * @return String for the help command
     */
    public static String helpCommandString() {
        HELP_STRING.append(HelpWindow.HELP_MESSAGE).append(Command.COMMAND).append(AddCommand.MESSAGE_USAGE)
                .append(ClearCommand.HELP_COMMAND).append(DeleteCommand.MESSAGE_USAGE)
                .append(EditCommand.MESSAGE_USAGE).append(ExitCommand.HELP_COMMAND)
                .append(FindCommand.MESSAGE_USAGE).append(ListCommand.HELP_COMMAND);
        return HELP_STRING.toString();
    }



    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (commandWordArg.trim().isEmpty()) {
            return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
        } else {
            switch (commandWordArg.trim()) {
            case AddCommand.COMMAND_WORD:
                return new CommandResult(AddCommand.MESSAGE_USAGE);

            case EditCommand.COMMAND_WORD:
                return new CommandResult(EditCommand.MESSAGE_USAGE);

            case DeleteCommand.COMMAND_WORD:
                return new CommandResult(DeleteCommand.MESSAGE_USAGE);

            case ClearCommand.COMMAND_WORD:
                return new CommandResult(ClearCommand.HELP_COMMAND);

            case FindCommand.COMMAND_WORD:
                return new CommandResult(FindCommand.MESSAGE_USAGE);

            case ListCommand.COMMAND_WORD:
                return new CommandResult(ListCommand.HELP_COMMAND);

            case ExitCommand.COMMAND_WORD:
                return new CommandResult(ExitCommand.HELP_COMMAND);


            case HelpCommand.COMMAND_WORD:
                return new CommandResult(HelpCommand.MESSAGE_USAGE);

            default:
                throw new CommandException(INVALID_COMMAND_USAGE);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HelpCommand that = (HelpCommand) o;
        return Objects.equals(commandWordArg, that.commandWordArg);
    }

    public int hashCode() {
        return Objects.hash(commandWordArg);
    }
}
