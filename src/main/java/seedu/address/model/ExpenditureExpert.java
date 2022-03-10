package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.UniqueExpenseList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameExpense comparison)
 */
public class ExpenditureExpert implements ReadOnlyExpenditureExpert {

    private final UniqueExpenseList expenses;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        expenses = new UniqueExpenseList();
    }

    public ExpenditureExpert() {}

    /**
     * Creates an ExpenseExpert using the Expenses in the {@code toBeCopied}
     */
    public ExpenditureExpert(ReadOnlyExpenditureExpert toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the expense list with {@code expenses}.
     * {@code expenses} must not contain duplicate expenses.
     */
    public void setExpenses(List<Expense> expenses) {
        this.expenses.setExpenses(expenses);
    }

    /**
     * Resets the existing data of this {@code ExpenditureExpert} with {@code newData}.
     */
    public void resetData(ReadOnlyExpenditureExpert newData) {
        requireNonNull(newData);

        setExpenses(newData.getExpenseList());
    }

    //// expense-level operations

    /**
     * Returns true if a expense with the same identity as {@code expense} exists in the expenditure expert.
     */
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenses.contains(expense);
    }

    /**
     * Adds a expense to the expenditure expert.
     * The expense must not already exist in the expenditure expert.
     */
    public void addExpense(Expense e) {
        expenses.add(e);
    }

    /**
     * Replaces the given expense {@code target} in the list with {@code editedExpense}.
     * {@code target} must exist in the expenditure expert.
     * The expense identity of {@code editedExpense} must not be the same as another existing expense in
     * the expenditure expert.
     */
    public void setExpense(Expense target, Expense editedExpense) {
        requireNonNull(editedExpense);

        expenses.setExpense(target, editedExpense);
    }

    /**
     * Removes {@code key} from this {@code ExpenditureExpert}.
     * {@code key} must exist in the expenditure expert.
     */
    public void removeExpense(Expense key) {
        expenses.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return expenses.asUnmodifiableObservableList().size() + " expenses";
        // TODO: refine later
    }

    @Override
    public ObservableList<Expense> getExpenseList() {
        return expenses.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenditureExpert // instanceof handles nulls
                && expenses.equals(((ExpenditureExpert) other).expenses));
    }

    @Override
    public int hashCode() {
        return expenses.hashCode();
    }
}
