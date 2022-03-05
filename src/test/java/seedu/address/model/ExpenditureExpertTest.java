package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_NETFLIX_FEES;
import static seedu.address.testutil.TypicalExpenses.getTypicalExpenditureExpert;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.expense.Expense;
import seedu.address.model.person.exceptions.DuplicateExpenseException;
import seedu.address.testutil.ExpenseBuilder;

public class ExpenditureExpertTest {

    private final ExpenditureExpert expenditureExpert = new ExpenditureExpert();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), expenditureExpert.getExpenseList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> expenditureExpert.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyExpenditureExpert_replacesData() {
        ExpenditureExpert newData = getTypicalExpenditureExpert();
        expenditureExpert.resetData(newData);
        assertEquals(newData, expenditureExpert);
    }

    @Test
    public void resetData_withDuplicateExpenses_throwsDuplicateExpenseException() {
        // Two persons with the same identity fields
        Expense editedAnnualNetflixFees = new ExpenseBuilder(ANNUAL_NETFLIX_FEES).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Expense> newExpenses = Arrays.asList(ANNUAL_NETFLIX_FEES, editedAnnualNetflixFees);
        ExpenditureExpertStub newData = new ExpenditureExpertStub(newExpenses);

        assertThrows(DuplicateExpenseException.class, () -> expenditureExpert.resetData(newData));
    }

    @Test
    public void hasExpense_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> expenditureExpert.hasExpense(null));
    }

    @Test
    public void hasExpense_expenseNotInExpenditureExpert_returnsFalse() {
        assertFalse(expenditureExpert.hasExpense(ANNUAL_NETFLIX_FEES));
    }

    @Test
    public void hasExpense_expenseInExpenditureExpert_returnsTrue() {
        expenditureExpert.addExpense(ANNUAL_NETFLIX_FEES);
        assertTrue(expenditureExpert.hasExpense(ANNUAL_NETFLIX_FEES));
    }

    @Test
    public void hasExpense_expenseWithSameIdentityFieldsInAddressBook_returnsTrue() {
        expenditureExpert.addExpense(ANNUAL_NETFLIX_FEES);
        Expense editedAlice = new ExpenseBuilder(ANNUAL_NETFLIX_FEES).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(expenditureExpert.hasExpense(editedAlice));
    }

    @Test
    public void getExpenseList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> expenditureExpert.getExpenseList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class ExpenditureExpertStub implements ReadOnlyExpenditureExpert {
        private final ObservableList<Expense> expenses = FXCollections.observableArrayList();

        ExpenditureExpertStub(Collection<Expense> expenses) {
            this.expenses.setAll(expenses);
        }

        @Override
        public ObservableList<Expense> getExpenseList() {
            return expenses;
        }
    }

}
