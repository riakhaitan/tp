package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.ExpenseCategoryList;
import seedu.address.model.expense.UniqueExpenseList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameExpense comparison)
 */
public class ExpenseExpert implements ReadOnlyExpenseExpert {

    private final UniqueExpenseList expenses;
    private final ExpenseCategoryList categories;
    private Budget budget;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        expenses = new UniqueExpenseList();
        budget = new Budget("0");
        categories = new ExpenseCategoryList();
    }

    public ExpenseExpert() {}

    /**
     * Creates an ExpenseExpert using the Expenses in the {@code toBeCopied}
     */
    public ExpenseExpert(ReadOnlyExpenseExpert toBeCopied) {
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
     * Resets the existing data of this {@code ExpenseExpert} with {@code newData}.
     */
    public void resetData(ReadOnlyExpenseExpert newData) {
        requireNonNull(newData);

        setExpenses(newData.getExpenseList());
        setBudget(newData.getBudget());

        // Budget newBudget = newData.getBudget();
        // if (!(newBudget == null)) {
        //     setBudget(newData.getBudget());
        // }
    }

    //// expense-level operations

    /**
     * Returns true if a expense with the same identity as {@code expense} exists in the expense expert.
     */
    public boolean hasExpense(Expense expense) {
        requireNonNull(expense);
        return expenses.contains(expense);
    }

    /**
     * Adds a expense to the expense expert.
     * The expense must not already exist in the expense expert.
     */
    public void addExpense(Expense e) {
        expenses.add(e);
    }

    /**
     * Replaces the given expense {@code target} in the list with {@code editedExpense}.
     * {@code target} must exist in the expense expert.
     * The expense identity of {@code editedExpense} must not be the same as another existing expense in
     * the expense expert.
     */
    public void setExpense(Expense target, Expense editedExpense) {
        requireNonNull(editedExpense);

        expenses.setExpense(target, editedExpense);
    }

    /**
     * Removes {@code key} from this {@code ExpenseExpert}.
     * {@code key} must exist in the expense expert.
     */
    public void removeExpense(Expense key) {
        expenses.remove(key);
    }

    //// Category-level operations

    /**
     * Returns true if a expense with the same identity as {@code expense} exists in the expense expert.
     */
    public boolean hasExpenseCategory(ExpenseCategory expenseCategory) {
        requireNonNull(expenseCategory);
        return categories.contains(expenseCategory);
    }

    /**
     * Adds a expense to the expense expert.
     * The expense must not already exist in the expense expert.
     */
    public void addExpenseCategory(ExpenseCategory expenseCategory) {
        categories.add(expenseCategory);
    }


    /**
     * Removes {@code key} from this {@code ExpenseExpert}.
     * {@code key} must exist in the expense expert.
     */
    public void removeExpenseCategory(ExpenseCategory key) {
        categories.remove(key);
    }

    //// budget-level operations

    /**
     * Replaces the current budget in {@code ExpenseExpert} to {@code budget}
     */
    public void setBudget(Budget budget) {
        requireNonNull(budget);
        this.budget = budget;
    }

    //// util methods

    @Override
    public String toString() {
        return expenses.asUnmodifiableObservableList().size() + " expenses";
        // TODO: refine later
    }

    @Override
    public ObservableList<ExpenseCategory> getExpenseCategoryList() {
        return categories.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Expense> getExpenseList() {
        return expenses.asUnmodifiableObservableList();
    }

    @Override
    public Budget getBudget() {
        return this.budget;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseExpert // instanceof handles nulls
                && expenses.equals(((ExpenseExpert) other).expenses)
                && budget.equals(((ExpenseExpert) other).budget));
    }

    @Override
    public int hashCode() {
        return expenses.hashCode();
    }

}
