package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.expense.Budget;
import seedu.address.model.expense.Expense;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Expense> PREDICATE_SHOW_ALL_EXPENSES = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' expense expert file path.
     */
    Path getExpenseExpertFilePath();

    /**
     * Sets the user prefs' expense expert file path.
     */
    void setExpenseExpertFilePath(Path expenseExpertFilePath);

    /**
     * Replaces expense expert data with the data in {@code expenseExpert}.
     */
    void setExpenseExpert(ReadOnlyExpenseExpert expenseExpert);

    /** Returns the ExpenseExpert */
    ReadOnlyExpenseExpert getExpenseExpert();

    /**
     * Returns true if a expense with the same identity as {@code expense} exists in the expense expert.
     */
    boolean hasExpense(Expense expense);

    /**
     * Deletes the given expense.
     * The expense must exist in the expense expert.
     */
    void deleteExpense(Expense target);

    /**
     * Adds the given expense.
     * {@code expense} must not already exist in the expense expert.
     */
    void addExpense(Expense expense);

    /**
     * Replaces the given expense {@code target} with {@code editedExpense}.
     * {@code target} must exist in the expense expert.
     * The expense identity of {@code editedExpense} must not be the same as another existing expense in
     * the expense expert.
     */
    void setExpense(Expense target, Expense editedExpense);

    /** Returns an unmodifiable view of the filtered expense list */
    ObservableList<Expense> getFilteredExpenseList();

    /**
     * Updates the filter of the filtered expense list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredExpenseList(Predicate<Expense> predicate);

    /**
     * Replaces the current budget in {@code ExpenseExpert} to {@code budget}
     */
    void setBudget(Budget budget);

    /** Returns the current budget in {@code ExpenseExpert} */
    Budget getBudget();
}
