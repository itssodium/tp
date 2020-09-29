package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Adds the number of hotel rooms in a hotel
 */
public class AddRoomsCommand extends Command {
    public static final String COMMAND_WORD = "addrooms";
    public static final String MESSAGE_ZERO_CANNOT_BE_AN_INPUT = "please input a positive value";
    public static final String MESSAGE_NEGATIVE_VALUES_CANNOT_BE_INPUT = "please check your value! "
            + "You have input a negative value!";
    public static final String MESSAGE_SUCCESS = "%d rooms are added in your hotel";
    private int numOfRooms;

    /**
     * Creates an AddCommand to add the number of rooms available in a hotel
     */
    public AddRoomsCommand(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (numOfRooms == 0) {
            throw new CommandException(MESSAGE_ZERO_CANNOT_BE_AN_INPUT);
        } else if (numOfRooms < 0) {
            throw new CommandException(MESSAGE_NEGATIVE_VALUES_CANNOT_BE_INPUT);
        }
        model.addRooms(numOfRooms);
        return new CommandResult(String.format(MESSAGE_SUCCESS, numOfRooms));
    }

}
