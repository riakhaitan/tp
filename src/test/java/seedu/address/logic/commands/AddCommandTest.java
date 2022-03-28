package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ExpenseExpert;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyExpenseExpert;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.budget.Budget;
import seedu.address.model.expense.Expense;
import seedu.address.model.person.Person;
import seedu.address.testutil.ExpenseBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_expenseAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingExpenseAdded modelStub = new ModelStubAcceptingExpenseAdded();
        Expense validExpense = new ExpenseBuilder().build();
        //Person validPerson = new PersonBuilder().build();
        // Budget validBudget = new BudgetBuilder().build();
        // Budget newBudget = new Budget(validBudget.asInt() - validExpense.getAmount().asInt());

        CommandResult commandResult = new AddCommand(validExpense).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validExpense),
                commandResult.getFeedbackToUser());
        // assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validExpense)
        //         + "\n\n"
        //         + String.format(AddCommand.BUDGET_EDITED, newBudget),
        //         commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validExpense), modelStub.expensesAdded);
    }

    @Test
    public void execute_duplicateExpense_throwsCommandException() {
        Expense validExpense = new ExpenseBuilder().build();
        AddCommand addCommand = new AddCommand(validExpense);
        ModelStub modelStub = new ModelStubWithExpense(validExpense);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_EXPENSE, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Expense annualNetflix = new ExpenseBuilder().withDescription("Annual Netflix Fees").build();
        Expense baseballLesson = new ExpenseBuilder().withDescription("Baseball Lesson Fees").build();
        AddCommand addAnnualNetflixCommand = new AddCommand(annualNetflix);
        AddCommand addBaseballLessonCommand = new AddCommand(baseballLesson);

        // same object -> returns true
        assertTrue(addAnnualNetflixCommand.equals(addAnnualNetflixCommand));

        // same values -> returns true
        AddCommand addAnnualNetflixCommandCopy = new AddCommand(annualNetflix);
        assertTrue(addAnnualNetflixCommand.equals(addAnnualNetflixCommandCopy));

        // different types -> returns false
        assertFalse(addAnnualNetflixCommand.equals(1));

        // null -> returns false
        assertFalse(addAnnualNetflixCommand.equals(null));

        // different expense -> returns false
        assertFalse(addAnnualNetflixCommand.equals(addBaseballLessonCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getExpenseExpertFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setExpenseExpertFilePath(Path expenseExpertFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addExpense(Expense expense) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setExpenseExpert(ReadOnlyExpenseExpert newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyExpenseExpert getExpenseExpert() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasExpense(Expense expense) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteExpense(Expense target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setExpense(Expense target, Expense editedExpense) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Expense> getFilteredExpenseList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredExpenseList(Predicate<Expense> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setBudget(Budget budget) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Budget getBudget() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }


    /**
     * A Model stub that contains a single expense.
     */
    private class ModelStubWithExpense extends ModelStub {
        private final Expense expense;

        ModelStubWithExpense(Expense expense) {
            requireNonNull(expense);
            this.expense = expense;
        }

        @Override
        public boolean hasExpense(Expense expense) {
            requireNonNull(expense);
            return this.expense.isSameExpense(expense);
        }
    }

    /**
     * A Model stub that always accept the expense being added.
     */
    private class ModelStubAcceptingExpenseAdded extends ModelStub {
        final ArrayList<Expense> expensesAdded = new ArrayList<>();
        // private Budget budget;

        @Override
        public boolean hasExpense(Expense expense) {
            requireNonNull(expense);
            return expensesAdded.stream().anyMatch(expense::isSameExpense);
        }

        @Override
        public void addExpense(Expense expense) {
            requireNonNull(expense);
            expensesAdded.add(expense);
        }

        @Override
        public ReadOnlyExpenseExpert getExpenseExpert() {
            return new ExpenseExpert();
        }

        // @Override
        // public void setBudget(Budget budget) {
        //     this.budget = budget;
        // }

        // @Override
        // public Budget getBudget() {
        //     return this.budget;
        // }
    }

}
