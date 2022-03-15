package seedu.address.logic.commands;

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
            + "Example: " + COMMAND_WORD;

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
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
