package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPENSE_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXPENSE_DATE;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
// import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;

/**
 * Adds an expense to the expense expert.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an expense to Expense Expert. "
            + "Parameters: "
            + PREFIX_DESCRIPTION + "DESCRIPTION "
            + PREFIX_EXPENSE_CATEGORY + "CATEGORY "
            + PREFIX_AMOUNT + "AMOUNT "
            + PREFIX_EXPENSE_DATE + "DATE] \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DESCRIPTION + "Groceries from Fairprice "
            + PREFIX_EXPENSE_CATEGORY + "GROCERIES "
            + PREFIX_AMOUNT + "100 "
            + PREFIX_EXPENSE_DATE + "2022-02-02 \n\n";

    public static final String MESSAGE_SUCCESS = "New expense added: %1$s";
    // public static final String BUDGET_EDITED = "Budget allowance for this month is now: %1$s";
    public static final String MESSAGE_DUPLICATE_EXPENSE = "This expense already exists in Expense Expert";
    public static final String MESSAGE_INVALID_EXPENSE_CATEGORY =
            "This expense category does not exists in Expense Expert." +
            "\nUse the addCat Command to create a new category";

    private final Expense toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Expense}
     */
    public AddCommand(Expense expense) {
        requireNonNull(expense);
        toAdd = expense;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasExpense(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_EXPENSE);
        }

        if (!model.validExpenseCategory(toAdd)) {
            throw new CommandException(MESSAGE_INVALID_EXPENSE_CATEGORY);
        }

        model.addExpense(toAdd);
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
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
