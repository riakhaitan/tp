package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_EXPENSES;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_NETFLIX_FEES;
import static seedu.address.testutil.TypicalExpenses.BASEBALL_LESSON_FEES;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.expense.DescriptionContainsKeywordsPredicate;
import seedu.address.testutil.ExpenditureExpertBuilder;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new ExpenditureExpert(), new ExpenditureExpert(modelManager.getExpenditureExpert()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setExpenditureExpertFilePath(Paths.get("address/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setExpenditureExpertFilePath(Paths.get("new/address/book/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setExpenditureExpertFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setExpenditureExpertFilePath(null));
    }

    @Test
    public void setExpenditureExpertFilePath_validPath_setsExpenditureExpertFilePath() {
        Path path = Paths.get("address/book/file/path");
        modelManager.setExpenditureExpertFilePath(path);
        assertEquals(path, modelManager.getExpenditureExpertFilePath());
    }

    @Test
    public void hasExpense_nullExpense_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasExpense(null));
    }

    @Test
    public void hasExpense_expenseNotInExpenditureExpert_returnsFalse() {
        assertFalse(modelManager.hasExpense(ANNUAL_NETFLIX_FEES));
    }

    @Test
    public void hasExpense_expenseInExpenditureExpert_returnsTrue() {
        modelManager.addExpense(ANNUAL_NETFLIX_FEES);
        assertTrue(modelManager.hasExpense(ANNUAL_NETFLIX_FEES));
    }

    @Test
    public void getFilteredExpenseList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredExpenseList().remove(0));
    }

    @Test
    public void equals() {
        ExpenditureExpert expenditureExpert = new ExpenditureExpertBuilder()
                .withExpense(ANNUAL_NETFLIX_FEES).withExpense(BASEBALL_LESSON_FEES).build();
        ExpenditureExpert differentExpenditureExpert = new ExpenditureExpert();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = new ModelManager(expenditureExpert, userPrefs);
        ModelManager modelManagerCopy = new ModelManager(expenditureExpert, userPrefs);
        assertTrue(modelManager.equals(modelManagerCopy));


        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different expenditureExpert -> returns false
        assertFalse(modelManager.equals(new ModelManager(differentExpenditureExpert, userPrefs)));

        // different filteredList -> returns false
        String[] keywords = ANNUAL_NETFLIX_FEES.getDescription().description.split("\\s+");
        modelManager.updateFilteredExpenseList(new DescriptionContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelManager(expenditureExpert, userPrefs)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);

        // different userPrefs -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setExpenditureExpertFilePath(Paths.get("differentFilePath"));
        assertFalse(modelManager.equals(new ModelManager(expenditureExpert, differentUserPrefs)));
    }
}
