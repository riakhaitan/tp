package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;

/**
 * Represents the in-memory model of the expense expert data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final ExpenseExpert expenseExpert;
    private final UserPrefs userPrefs;
    private final FilteredList<Expense> filteredExpenses;

    /**
     * Initializes a ModelManager with the given expenseExpert and userPrefs.
     */
    public ModelManager(ReadOnlyExpenseExpert expenseExpert, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(expenseExpert, userPrefs);

        logger.fine("Initializing with expense expert: " + expenseExpert + " and user prefs " + userPrefs);

        this.expenseExpert = new ExpenseExpert(expenseExpert);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredExpenses = new FilteredList<>(this.expenseExpert.getExpenseList());
    }

    public ModelManager() {
        this(new ExpenseExpert(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getExpenseExpertFilePath() {
        return userPrefs.getExpenseExpertFilePath();
    }

    @Override
    public void setExpenseExpertFilePath(Path expenseExpertFilePath) {
        requireNonNull(expenseExpertFilePath);
        userPrefs.setExpenseExpertFilePath(expenseExpertFilePath);
    }

    //=========== ExpenseExpert ================================================================================

    @Override
    public void setExpenseExpert(ReadOnlyExpenseExpert expenseExpert) {
        this.expenseExpert.resetData(expenseExpert);
    }

    @Override
    public ReadOnlyExpenseExpert getExpenseExpert() {
        return expenseExpert;
    }

    @Override
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenseExpert.hasExpense(expense);
    }

    @Override
    public void deleteExpense(Expense target) {
        expenseExpert.removeExpense(target);
    }

    @Override
    public void addExpense(Expense expense) {
        expenseExpert.addExpense(expense);
        updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
    }

    @Override
    public void setExpense(Expense target, Expense editedExpense) {
        requireAllNonNull(target, editedExpense);

        expenseExpert.setExpense(target, editedExpense);
    }

    @Override
    public void setBudget(Budget budget) {
        requireNonNull(budget);
        expenseExpert.setBudget(budget);
    }

    @Override
    public Budget getBudget() {
        return expenseExpert.getBudget();
    }

    //=========== Filtered Expense List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Expense} backed by the internal list of
     * {@code versionedExpenseExpert}
     */
    @Override
    public ObservableList<Expense> getFilteredExpenseList() {
        return filteredExpenses;
    }

    @Override
    public void updateFilteredExpenseList(Predicate<Expense> predicate) {
        requireNonNull(predicate);
        filteredExpenses.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return expenseExpert.equals(other.expenseExpert)
                && userPrefs.equals(other.userPrefs)
                && filteredExpenses.equals(other.filteredExpenses);
    }
}
