package seedu.address.model.expense;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BUILD_A_BEAR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_CATEGORY_TRANSPORT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_NETFLIX_FEES;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_SPOTIFY;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.expense.exceptions.DuplicateExpenseException;
import seedu.address.model.expense.exceptions.ExpenseNotFoundException;
import seedu.address.testutil.ExpenseBuilder;

public class UniqueExpenseListTest {

    private final UniqueExpenseList UniqueExpenseList = new UniqueExpenseList();

    @Test
    public void contains_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList.contains(null));
    }

    @Test
    public void contains_expenseNotInList_returnsFalse() {
        assertFalse(UniqueExpenseList.contains(ANNUAL_SPOTIFY));
    }

    @Test
    public void contains_expenseInList_returnsTrue() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        assertTrue(UniqueExpenseList.contains(ANNUAL_SPOTIFY));
    }

    // Unique identity fields: all fields but ExpenseCategory
    @Test
    public void contains_expenseWithSameIdentityFieldsInList_returnsTrue() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        Expense editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withExpenseCategory(VALID_EXPENSE_CATEGORY_TRANSPORT)
                .build();
        assertFalse(UniqueExpenseList.contains(editedSpotify));
    }

    @Test
    public void add_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList.add(null));
    }

    @Test
    public void add_duplicateExpense_throwsDuplicateExpenseException() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        assertThrows(DuplicateExpenseException.class, () -> UniqueExpenseList.add(ANNUAL_SPOTIFY));
    }

    @Test
    public void setExpense_nullTargetExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList.setExpense(null, ANNUAL_SPOTIFY));
    }

    @Test
    public void setExpense_nullEditedExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList
                .setExpense(ANNUAL_SPOTIFY, null));
    }

    @Test
    public void setExpense_targetExpenseNotInList_throwsExpenseNotFoundException() {
        assertThrows(ExpenseNotFoundException.class, () -> UniqueExpenseList
                .setExpense(ANNUAL_SPOTIFY, ANNUAL_SPOTIFY));
    }

    @Test
    public void setExpense_editedExpenseIsSameExpense_success() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        UniqueExpenseList.setExpense(ANNUAL_SPOTIFY, ANNUAL_SPOTIFY);
        UniqueExpenseList expectedUniqueExpenseList = new UniqueExpenseList();
        expectedUniqueExpenseList.add(ANNUAL_SPOTIFY);
        assertEquals(expectedUniqueExpenseList, UniqueExpenseList);
    }

    @Test
    public void setExpense_editedExpenseHasSameIdentity_success() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        Expense editedSpotify = new ExpenseBuilder(ANNUAL_SPOTIFY).withDescription(VALID_DESCRIPTION_BUILD_A_BEAR)
                .build();
        UniqueExpenseList.setExpense(ANNUAL_SPOTIFY, editedSpotify);
        UniqueExpenseList expectedUniqueExpenseList = new UniqueExpenseList();
        expectedUniqueExpenseList.add(editedSpotify);
        assertEquals(expectedUniqueExpenseList, UniqueExpenseList);
    }

    @Test
    public void setExpense_editedExpenseHasDifferentIdentity_success() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        UniqueExpenseList.setExpense(ANNUAL_SPOTIFY, ANNUAL_NETFLIX_FEES);
        UniqueExpenseList expectedUniqueExpenseList = new UniqueExpenseList();
        expectedUniqueExpenseList.add(ANNUAL_NETFLIX_FEES);
        assertEquals(expectedUniqueExpenseList, UniqueExpenseList);
    }

    @Test
    public void setExpense_editedExpenseHasNonUniqueIdentity_throwsDuplicateExpenseException() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        UniqueExpenseList.add(ANNUAL_NETFLIX_FEES);
        assertThrows(DuplicateExpenseException.class, (
        ) -> UniqueExpenseList.setExpense(ANNUAL_SPOTIFY, ANNUAL_NETFLIX_FEES));
    }

    @Test
    public void remove_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList.remove(null));
    }

    @Test
    public void remove_expenseDoesNotExist_throwsExpenseNotFoundException() {
        assertThrows(ExpenseNotFoundException.class, () -> UniqueExpenseList.remove(ANNUAL_SPOTIFY));
    }

    @Test
    public void remove_existingExpense_removesExpense() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        UniqueExpenseList.remove(ANNUAL_SPOTIFY);
        UniqueExpenseList expectedUniqueExpenseList = new UniqueExpenseList();
        assertEquals(expectedUniqueExpenseList, UniqueExpenseList);
    }

    // setExpense_nullUniqueExpenseList() -> throwsNullPointerException()
    @Test
    public void setExpense_nullUniqueExpenseList() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList.setExpenses((UniqueExpenseList) null));
    }
    // setExpense_UniqueExpenseList -> replacesOwnListWithProvidedUniqueExpenseList
    @Test
    public void setExpense_uniqueExpenseList() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        UniqueExpenseList expectedUniqueExpenseList = new UniqueExpenseList();
        expectedUniqueExpenseList.add(ANNUAL_NETFLIX_FEES);
        UniqueExpenseList.setExpenses(expectedUniqueExpenseList);
        assertEquals(expectedUniqueExpenseList, UniqueExpenseList);
    }

    @Test
    public void setExpense_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> UniqueExpenseList.setExpenses((List<Expense>) null));
    }

    @Test
    public void setExpense_list_replacesOwnListWithProvidedList() {
        UniqueExpenseList.add(ANNUAL_SPOTIFY);
        List<Expense> expenseList = Collections.singletonList(ANNUAL_NETFLIX_FEES);
        UniqueExpenseList.setExpenses(expenseList);
        UniqueExpenseList expectedUniqueExpenseList = new UniqueExpenseList();
        expectedUniqueExpenseList.add(ANNUAL_NETFLIX_FEES);
        assertEquals(expectedUniqueExpenseList, UniqueExpenseList);
    }

    @Test
    public void setExpense_listWithDuplicateExpenses_throwsDuplicateExpenseException() {
        List<Expense> listWithDuplicateExpenses = Arrays.asList(ANNUAL_SPOTIFY, ANNUAL_SPOTIFY);
        assertThrows(DuplicateExpenseException.class, () -> UniqueExpenseList.setExpenses(listWithDuplicateExpenses));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> UniqueExpenseList
                .asUnmodifiableObservableList().remove(0));
    }
}
