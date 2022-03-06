package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalExpenses.ANNUAL_NETFLIX_FEES;
import static seedu.address.testutil.TypicalExpenses.HOUSING_RENT;
import static seedu.address.testutil.TypicalExpenses.INTERNET_BILLS;
import static seedu.address.testutil.TypicalExpenses.getTypicalExpenditureExpert;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ExpenditureExpert;
import seedu.address.model.ReadOnlyExpenditureExpert;

public class JsonExpenditureExpertStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonExpenditureExpertStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readExpenditureExpert_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readExpenditureExpert(null));
    }

    private java.util.Optional<ReadOnlyExpenditureExpert> readExpenditureExpert(String filePath) throws Exception {
        return new JsonExpenditureExpertStorage(Paths.get(filePath)).readExpenditureExpert(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readExpenditureExpert("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readExpenditureExpert("notJsonFormatExpenditureExpert.json"));
    }

    @Test
    public void readExpenditureExpert_invalidExpenseExpenditureExpert_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readExpenditureExpert("invalidExpenseExpenditureExpert.json"));
    }

    @Test
    public void readExpenditureExpert_invalidAndValidExpenseExpenditureExpert_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readExpenditureExpert("invalidAndValidExpenseExpenditureExpert.json"));
    }

    @Test
    public void readAndSaveExpenditureExpert_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempExpenditureExpert.json");
        ExpenditureExpert original = getTypicalExpenditureExpert();
        JsonExpenditureExpertStorage jsonExpenditureExpertStorage = new JsonExpenditureExpertStorage(filePath);

        // Save in new file and read back
        jsonExpenditureExpertStorage.saveExpenditureExpert(original, filePath);
        ReadOnlyExpenditureExpert readBack = jsonExpenditureExpertStorage.readExpenditureExpert(filePath).get();
        assertEquals(original, new ExpenditureExpert(readBack));

        // Modify data, overwrite exiting file, and read back
        original.addExpense(HOUSING_RENT);
        original.removeExpense(ANNUAL_NETFLIX_FEES);
        jsonExpenditureExpertStorage.saveExpenditureExpert(original, filePath);
        readBack = jsonExpenditureExpertStorage.readExpenditureExpert(filePath).get();
        assertEquals(original, new ExpenditureExpert(readBack));

        // Save and read without specifying file path
        original.addExpense(INTERNET_BILLS);
        jsonExpenditureExpertStorage.saveExpenditureExpert(original); // file path not specified
        readBack = jsonExpenditureExpertStorage.readExpenditureExpert().get(); // file path not specified
        assertEquals(original, new ExpenditureExpert(readBack));

    }

    @Test
    public void saveExpenditureExpert_nullExpenditureExpert_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveExpenditureExpert(null, "SomeFile.json"));
    }

    /**
     * Saves {@code expenditureExpert} at the specified {@code filePath}.
     */
    private void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert, String filePath) {
        try {
            new JsonExpenditureExpertStorage(Paths.get(filePath))
                    .saveExpenditureExpert(expenditureExpert, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveExpenditureExpert_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveExpenditureExpert(new ExpenditureExpert(), null));
    }
}
