package seedu.address.logic.commands;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CATEGORIES;

public class ListCatCommand extends Command{
    public static final String COMMAND_WORD = "listCat";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all Categories\n" + "Example: "
            + COMMAND_WORD + "\n\n";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(formatCategoryList());
    }

    public String formatCategoryList() {
        return "test list";
    }
}
