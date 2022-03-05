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
import seedu.address.model.expense.Expense;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final ExpenditureExpert expenditureExpert;
    private final UserPrefs userPrefs;
    private final FilteredList<Expense> filteredExpenses;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyExpenditureExpert expenditureExpert, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(expenditureExpert, userPrefs);

        logger.fine("Initializing with address book: " + expenditureExpert + " and user prefs " + userPrefs);

        this.expenditureExpert = new ExpenditureExpert(expenditureExpert);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredExpenses = new FilteredList<>(this.expenditureExpert.getExpenseList());
    }

    public ModelManager() {
        this(new ExpenditureExpert(), new UserPrefs());
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
    public Path getExpenditureExpertFilePath() {
        return userPrefs.getExpenseExpertFilePath();
    }

    @Override
    public void setExpenditureExpertFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setExpenditureExpertFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert) {
        this.expenditureExpert.resetData(expenditureExpert);
    }

    @Override
    public ReadOnlyExpenditureExpert getExpenditureExpert() {
        return expenditureExpert;
    }

    @Override
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenditureExpert.hasExpense(expense);
    }

    @Override
    public void deleteExpense(Expense target) {
        expenditureExpert.removeExpense(target);
    }

    @Override
    public void addExpense(Expense expense) {
        expenditureExpert.addExpense(expense);
        updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
    }

    @Override
    public void setExpense(Expense target, Expense editedExpense) {
        requireAllNonNull(target, editedExpense);

        expenditureExpert.setExpense(target, editedExpense);
    }

    //=========== Filtered Expense List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Expense} backed by the internal list of
     * {@code versionedExpenditureExpert}
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
        return expenditureExpert.equals(other.expenditureExpert)
                && userPrefs.equals(other.userPrefs)
                && filteredExpenses.equals(other.filteredExpenses);
    }

}
