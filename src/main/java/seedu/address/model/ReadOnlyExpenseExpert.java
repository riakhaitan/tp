package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseCategory;

/**
 * Unmodifiable view of an expense expert
 */
public interface ReadOnlyExpenseExpert {

    /**
     * Returns an unmodifiable view of the expenses list.
     * This list will not contain any duplicate expenses.
     */
    ObservableList<Expense> getExpenseList();

    /**
     * Returns an unmodifiable view of the expenses list.
     * This list will not contain any duplicate expenses.
     */
    ObservableList<ExpenseCategory> getExpenseCategoryList();

    /** Returns the budget in ExpenseExpert */
    Budget getBudget();
    
}
