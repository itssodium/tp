package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.patient.Name;
import seedu.address.model.room.ComparableRoom;
import seedu.address.model.room.Room;
import seedu.address.model.room.exceptions.DuplicateRoomException;
import seedu.address.model.room.exceptions.RoomNotFoundException;
import seedu.address.model.task.Task;
import seedu.address.model.task.exceptions.TaskNotFoundException;



public class UniqueRoomList implements Iterable<Room> {

    private int numOfRooms;
    private PriorityQueue<Room> rooms = new PriorityQueue<>(new ComparableRoom());
    private ObservableList<Room> internalList = FXCollections.observableArrayList();
    private final ObservableList<Room> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    @Override
    public Iterator<Room> iterator() {
        return internalList.iterator();
    }

    /**
     * Resets the existing data of this {@code RoomList} with {@code newData}.
     */
    public void resetData(ReadOnlyRoomList readOnlyRoomList) {
        requireAllNonNull(readOnlyRoomList);

        ObservableList<Room> roomLists = readOnlyRoomList.getRoomObservableList();
        numOfRooms = roomLists.size();
        rooms.addAll(roomLists);
        internalList.addAll(roomLists);
    }
    /**
     * Returns Priority Queue of rooms
     */
    public PriorityQueue<Room> getRooms() {
        return this.rooms;
    }

    /**
     * Returns number of rooms in hotel
     */
    public int getNumOfRooms() {
        return numOfRooms;
    }

    public ObservableList<Room> getRoomObservableList() {
        return internalList;
    }

    /**
     * Adds this room to the RoomList
     * @param room is added to RoomList
     */
    public void addRooms(Room room) {
        this.numOfRooms++;
        rooms.add(room);
        internalList.add(room);
    }

    /**
     * Adds the number of the rooms in a hotel
     *
     * @param numOfRooms is the number of rooms to be added
     */
    public void addRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
        addRooms();
    }

    private void addRooms() {
        if (numOfRooms <= 0) {
            return;
        }
        if (numOfRooms > internalList.size()) {
            for (int i = internalList.size(); i < numOfRooms; i++) {
                Room room = new Room(i + 1);
                rooms.add(room);
                internalList.add(room);
            }
        } else if (numOfRooms < internalList.size()) {
            List<Room> occupiedRooms = occupiedRooms();
            List<Room> unoccupiedRooms = unOccupiedRooms();
            if (occupiedRooms.size() == 0) {

            } else {
                combinedStream(occupiedRooms, unoccupiedRooms);
            }
            rooms = new PriorityQueue<>(new ComparableRoom());
            for (int i = 0; i < numOfRooms; i++) {
                Room room = internalList.get(i);
                rooms.add(room);
            }

            int size = internalList.size();
            for (int i = numOfRooms; i < size; i++) {
                internalList.remove(numOfRooms);
            }
        }
    }

    /**
     * Gives list of empty rooms in the region which exists after shrinkage.
     */
    public List<Room> unOccupiedRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < numOfRooms; i++) {
            if (!internalList.get(i).isOccupied()) {
                rooms.add(internalList.get(i));
            }
        }
        return rooms;
    }

    /**
     * Gives list of occupied rooms in the region which does not exist after shrinkage.
     */
    public List<Room> occupiedRooms() {
        List<Room> rooms = new ArrayList<>();
        for (int i = numOfRooms; i < internalList.size(); i++) {
            if (internalList.get(i).isOccupied()) {
                rooms.add(internalList.get(i));
            }
        }

        return rooms;
    }

    private void combinedStream(List<Room> occupiedRooms, List<Room> unoccupiedRooms) {
        for (Room room : occupiedRooms) {
            Room empty = unoccupiedRooms.get(0);
            unoccupiedRooms.remove(0);
            empty.setOccupied(true);
            empty.setPatient(room.getPatient());
            empty.addTask(room.getTaskList());
        }
    }

    public boolean canFit() {
        return numOfOccupiedRooms() <= numOfEmptyRooms();
    }

    /**
     * Gives the number of rooms that are occupied in the hotel facility beyond shrinkage
     */
    public int numOfOccupiedRooms() {
        return (int) IntStream.rangeClosed(numOfRooms, internalList.size() - 1)
                .mapToObj(x -> internalList.get(x)).filter(Room::isOccupied).count();
    }

    /**
     * Gives the number of rooms that are empty for room numbers after shrinkage.
     */
    public int numOfEmptyRooms() {
        return (int) IntStream.rangeClosed(0, numOfRooms - 1)
               .mapToObj(x -> internalList.get(x)).filter(room -> !room.isOccupied()).count();
    }

    /**
     * Adds a task to a room.
     * The room must exist in the {@code RoomList}.
     *
     * @param task The task to add.
     * @param room The room to which the task should be added.
     * @throws RoomNotFoundException if {@code room} is not in {@code RoomList}.
     */
    public void addTaskToRoom(Task task, Room room) {
        requireAllNonNull(task, room);

        int index = internalList.indexOf(room);
        if (index == -1) {
            throw new RoomNotFoundException();
        }

        room.addTask(task);
        internalList.set(index, room);
    }

    /**
     * Deletes a task from a room.
     * The room must exist in the {@code RoomList}.
     * The task must exist in the {@code TaskList} of the room.
     *
     * @param task The task to delete.
     * @param room The room to which the task should be deleted.
     * @throws RoomNotFoundException if {@code room} is not in {@code RoomList}.
     * @throws TaskNotFoundException if {@code task} is not in {@code room}.
     */
    public void deleteTaskFromRoom(Task task, Room room) {
        requireAllNonNull(task, room);

        int index = internalList.indexOf(room);
        if (index == -1) {
            throw new RoomNotFoundException();
        }

        room.deleteTask(task);
        internalList.set(index, room);
    }

    public void setTaskToRoom(Task target, Task editedTask, Room room) {
        requireAllNonNull(target, editedTask, room);

        int index = internalList.indexOf(room);
        if (index == -1) {
            throw new RoomNotFoundException();
        }

        room.setTask(target, editedTask);
        internalList.set(index, room);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Room> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueRoomList // instanceof handles nulls
                && internalList.equals(((UniqueRoomList) other).internalList));
    }

    /**
     * Tests whether 2 PriorityQueues are equal by checking whether at each relative position they contain the equal
     * rooms
     */
    public boolean equals(PriorityQueue<Room> rooms1, PriorityQueue<Room> rooms2) {
        if (rooms1.size() != rooms2.size()) {
            return false;
        } else {
            int size = rooms1.size();
            for (int i = 0; i < size; i++) {
                if (!rooms1.poll().equals(rooms2.poll())) {
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * Returns true if the list contains an equivalent room as the given argument.
     */
    public boolean containsRoom(Room toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameRoom);
    }

    /**
     * Clears the room which contains the patient with the given name.
     * @param patientName to clear the room from.
     */
    public void clearRoom(Name patientName) {
        requireNonNull(patientName);
        for (int i = 1; i <= internalList.size(); i++) {
            if (!internalList.get(i - 1).isOccupied()) {
                continue;
            }
            Name patientNameInRoom = internalList.get(i - 1).getPatient().getName();
            if (patientName.equals(patientNameInRoom)) {
                Room roomToClear = internalList.get(i - 1);
                setSingleRoom(roomToClear, new Room(roomToClear.getRoomNumber()));
                break;
            }
        }
    }

    /**
     * Replaces the room {@code target} in the list with {@code editedRoom}.
     * {@code target} must exist in the list.
     * The room identity of {@code editedRoom} must not be the same as another existing room in the list.
     *
     * @param target Room to be changed.
     * @param editedRoom Room that has been changed.
     */
    public void setSingleRoom(Room target, Room editedRoom) {
        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new RoomNotFoundException();
        }

        if (!target.isSameRoom(editedRoom) && containsRoom(editedRoom)) {
            throw new DuplicateRoomException();
        }
        rooms.remove(target); // this and the next LOC is to replace the room in the priority queue
        rooms.add(editedRoom);
        internalList.set(index, editedRoom);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(numOfRooms, rooms, internalList);
        result = 31 * result;
        return result;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public void setRooms(PriorityQueue<Room> rooms) {
        this.rooms = rooms;
    }

    public Optional<Room> getRoomWithRoomNumber(int roomNumber) {
        for (Room room : internalList) {
            if (roomNumber == room.getRoomNumber()) {
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }

}
