package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.UniqueExpenseList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameExpense comparison)
 */
public class ExpenseExpert implements ReadOnlyExpenseExpert {

    private final UniqueExpenseList expenses;
    private Budget budget;
    private final UniquePersonList persons;

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
        persons = new UniquePersonList();
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
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }

    /**
     * Resets the existing data of this {@code ExpenseExpert} with {@code newData}.
     */
    public void resetData(ReadOnlyExpenseExpert newData) {
        requireNonNull(newData);

        setExpenses(newData.getExpenseList());
        setBudget(newData.getBudget());
        setPersons(newData.getPersonList());

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

    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a expense to the expense expert.
     * The expense must not already exist in the expense expert.
     */
    public void addExpense(Expense e) {
        expenses.add(e);
    }
    public void addPerson(Person p) {
        persons.add(p);
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

    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code ExpenseExpert}.
     * {@code key} must exist in the expense expert.
     */
    public void removeExpense(Expense key) {
        expenses.remove(key);
    }

    public void removePerson(Person key) {
        persons.remove(key);
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
    public ObservableList<Expense> getExpenseList() {
        return expenses.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
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
                && budget.equals(((ExpenseExpert) other).budget))
                && persons.equals((((ExpenseExpert) other).persons));
    }

    @Override
    public int hashCode() {
        return expenses.hashCode();
    }

}
