package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalRooms.ROOM7_PATIENT_ALICE_NO_TASK;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.model.room.Room;

class RoomListTest {

    @Test
    public void getRoomWithRoomNumber_roomNotInList_returnsEmptyOptional() {
        RoomList roomList = new RoomList();

        // Positive room number
        Optional<Room> optionalRoom = roomList.getRoomWithRoomNumber(20);
        assertTrue(optionalRoom.isEmpty());

        // Negative room number
        optionalRoom = roomList.getRoomWithRoomNumber(-20);
        assertTrue(optionalRoom.isEmpty());
    }

    @Test
    public void getRoomWithRoomNumber_roomInList_returnsRoom() {
        RoomList roomList = new RoomList();
        roomList.addRooms(ROOM7_PATIENT_ALICE_NO_TASK);
        Optional<Room> optionalRoom = roomList.getRoomWithRoomNumber(7);
        assertTrue(optionalRoom.map(room -> room.getRoomNumber() == 7).orElse(false));
    }

}

