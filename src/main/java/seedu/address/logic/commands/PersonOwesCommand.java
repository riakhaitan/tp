package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERSON_NAME;

public class PersonOwesCommand extends Command {
    public static final String COMMAND_WORD = "person";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": adds the person who owes you money to Expense Expert "
            + "Parameters: "
            + PREFIX_PERSON_NAME + "NAME"
            + PREFIX_AMOUNT + "AMOUNT "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_PERSON_NAME + "ALEX "
            + PREFIX_AMOUNT + "100 \n\n";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_EXPENSE = "This person already exists in Expense Expert";

    private final Person toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Expense}
     */
    public PersonOwesCommand(Person person) {
        requireNonNull(person);
        toAdd = person;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_EXPENSE);
        }

        model.addPerson(toAdd);
        // Budget newBudget = resultingBudget(model.getBudget(), toAdd);
        // model.setBudget(newBudget);

        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));

        // return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd)
        //         + "\n\n"
        //         + String.format(BUDGET_EDITED, newBudget.getBudget()));
    }

    // /**
    //  * Calculates the remaining budget after a new expense has been added
    //  * @param initial budget left for the month
    //  * @param value of expense to be deducted from budget allowance for the month
    //  * @return value of budget as a Budget object
    //  */
    // private Budget resultingBudget(Budget initial, Expense value) {
    //     return new Budget(initial.asInt() - value.getAmount().asInt());
    // }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonOwesCommand // instanceof handles nulls
                && toAdd.equals(((PersonOwesCommand) other).toAdd));
    }
}
