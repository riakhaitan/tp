package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyExpenditureExpert;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonExpenditureExpertStorage implements ExpenditureExpertStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonExpenditureExpertStorage.class);

    private Path filePath;

    public JsonExpenditureExpertStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getExpenditureExpertFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyExpenditureExpert> readExpenditureExpert() throws DataConversionException {
        return readExpenditureExpert(filePath);
    }

    /**
     * Similar to {@link #readExpenditureExpert()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyExpenditureExpert> readExpenditureExpert(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableExpenditureExpert> jsonExpenditureExpert = JsonUtil.readJsonFile(
                filePath, JsonSerializableExpenditureExpert.class);
        if (!jsonExpenditureExpert.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonExpenditureExpert.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert) throws IOException {
        saveExpenditureExpert(expenditureExpert, filePath);
    }

    /**
     * Similar to {@link #saveExpenditureExpert(ReadOnlyExpenditureExpert)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveExpenditureExpert(ReadOnlyExpenditureExpert expenditureExpert, Path filePath) throws IOException {
        requireNonNull(expenditureExpert);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableExpenditureExpert(expenditureExpert), filePath);
    }

}
