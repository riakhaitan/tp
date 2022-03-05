package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyExpenditureExpert;

/**
 * Represents a storage for {@link seedu.address.model.ExpenditureExpert}.
 */
public interface ExpenditureExpertStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getExpenditureExpertFilePath();

    /**
     * Returns ExpenditureExpert data as a {@link ReadOnlyExpenditureExpert}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyExpenditureExpert> readExpenditureExpert() throws DataConversionException, IOException;

    /**
     * @see #getExpenditureExpertFilePath()
     */
    Optional<ReadOnlyExpenditureExpert> readExpenditureExpert(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyExpenditureExpert} to the storage.
     * @param expenditureExpert cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert) throws IOException;

    /**
     * @see #saveExpenditureExpert(ReadOnlyExpenditureExpert) (ReadOnlyExpenditureExpert)
     */
    void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert, Path filePath) throws IOException;

}
