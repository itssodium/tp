package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.patient.Patient;
import seedu.address.model.room.Room;

public class JsonAdaptedRoom {
    public static final String PATIENT_PRESENT_IS_OCCUPIED_FALSE = "When patient is present isOccupied cannot be false";

    private int roomNumber;
    private boolean isOccupied;
    //TODO
    private JsonAdaptedPatient patient;
    //private String patient;
    private String task;

    /**
     * Creates JsonAdaptedRoom based on the inputs given by the user of roomNumber and isOccupied
     */
    @JsonCreator
    public JsonAdaptedRoom(@JsonProperty("roomNumber") int roomNumber,
                           @JsonProperty("isOccupied") boolean isOccupied,
                           @JsonProperty("patient") JsonAdaptedPatient patient) throws IllegalValueException {
        this.roomNumber = roomNumber;
        this.isOccupied = isOccupied;
        if (patient == null) {
            return;
        }
        this.patient = patient;
    }

    /**
     * Creates JsonAdaptedRoom from Room object given
     */
    public JsonAdaptedRoom(Room source) {
        this.roomNumber = source.getRoomNumber();
        this.isOccupied = source.isOccupied();
        Patient p = source.getPatient();
        if (source.getPatient() == null) {
            return;
        }
        this.patient = new JsonAdaptedPatient(source.getPatient());
    }

    public Room toModelType() throws IllegalValueException {
        if (this.patient != null && !isOccupied) {
            throw new IllegalValueException(PATIENT_PRESENT_IS_OCCUPIED_FALSE);
        } else if (this.patient != null) {
            return new Room(roomNumber, patient.toModelType());
        }
        return new Room(roomNumber, isOccupied);
    }

}
