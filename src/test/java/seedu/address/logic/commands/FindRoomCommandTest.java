package seedu.address.logic.commands;

import static seedu.address.logic.commands.NewCommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.NewCommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.RoomBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.hotel.Room;

class FindRoomCommandTest {

    @Test
    void execute_numberOfRooms_notDefined() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs(), new RoomBook());

        assertCommandFailure(new FindRoomCommand(), model, FindRoomCommand.NUMBER_OF_ROOMS_UNDEFINED);
    }

    void execute_roomOccupied() {

    }

    @Test
    void execute() {
        Model model = new ModelManager(new AddressBook(), new UserPrefs(), new RoomBook());
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), new RoomBook());
        model.addNumberOfRooms(100);
        expectedModel.addNumberOfRooms(100);
        String expectedMessage = new Room(1) + " is empty";
        assertCommandSuccess(new FindRoomCommand(), model, expectedMessage, expectedModel);
    }
}