package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyCovigentApp;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.room.ReadOnlyRoomList;
import seedu.address.model.room.RoomList;

/**
 * API of the Storage component
 */
public interface Storage extends CovigentAppStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getCovigentAppFilePath();

    @Override
    Optional<ReadOnlyCovigentApp> readCovigentApp() throws DataConversionException, IOException;

    @Override
    void saveCovigentApp(ReadOnlyCovigentApp covigentApp) throws IOException;

    /** Reads the data of number of rooms and occupied rooms into RoomList **/
    Optional<ReadOnlyRoomList> readRoomOccupancyStorage() throws DataConversionException, IOException;

    /**
     * Saves the information given by user into a hard disk. Such information includes number of rooms and room number
     * of occupied rooms
     * @param roomList contains user inputs
     * @throws IOException
     */
    void saveRoomList(RoomList roomList) throws IOException;


}
