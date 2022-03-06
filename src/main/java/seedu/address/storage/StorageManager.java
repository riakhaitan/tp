package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyExpenditureExpert;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of ExpenditureExpert data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private ExpenditureExpertStorage expenditureExpertStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code ExpenditureExpertStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(ExpenditureExpertStorage expenditureExpertStorage, UserPrefsStorage userPrefsStorage) {
        this.expenditureExpertStorage = expenditureExpertStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ ExpenditureExpert methods ==============================

    @Override
    public Path getExpenditureExpertFilePath() {
        return expenditureExpertStorage.getExpenditureExpertFilePath();
    }

    @Override
    public Optional<ReadOnlyExpenditureExpert> readExpenditureExpert() throws DataConversionException, IOException {
        return readExpenditureExpert(expenditureExpertStorage.getExpenditureExpertFilePath());
    }

    @Override
    public Optional<ReadOnlyExpenditureExpert> readExpenditureExpert(Path filePath)
            throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return expenditureExpertStorage.readExpenditureExpert(filePath);
    }

    @Override
    public void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert) throws IOException {
        saveExpenditureExpert(expenditureExpert, expenditureExpertStorage.getExpenditureExpertFilePath());
    }

    @Override
    public void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        expenditureExpertStorage.saveExpenditureExpert(expenditureExpert, filePath);
    }

}
