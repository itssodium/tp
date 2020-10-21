package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    private Image logoImage = new Image(this.getClass().getResourceAsStream("/images/logo.png"));
    private Image patientImage = new Image(this.getClass().getResourceAsStream("/images/patient.png"));
    private Image roomImage = new Image(this.getClass().getResourceAsStream("/images/room.png"));
    private Image taskImage = new Image(this.getClass().getResourceAsStream("/images/task.png"));
    // Independent Ui parts residing in this Ui container
    private IntroWindowPanel introWindowPanel;
    private PatientListPanel patientListPanel;
    private ResultDisplay resultDisplay;
    private RoomListPanel roomListPanel;

    @FXML
    private ImageView logoIcon;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane patientListPanelPlaceholder;

    @FXML
    private TabPane covigentTabs;

    @FXML
    private Tab patientTab;

    @FXML
    private Tab roomTab;

    @FXML
    private Tab taskTab;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statusBarPlaceholder;

    @FXML
    private StackPane roomListPanelPlaceHolder;

    @FXML
    private StackPane introPanelPlaceHolder;
    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {

        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        //set images
        this.setTabImage(patientTab, patientImage);
        this.setTabImage(roomTab, roomImage);
        this.setTabImage(taskTab, taskImage);

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());
    }

    private void setTabImage(Tab tab, Image image) {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(90);
        imageView.setFitWidth(90);
        imageView.setImage(image);
        tab.setGraphic(imageView);

    }

    public void displayAppIcon() {
        logoIcon.setImage(logoImage);
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        introWindowPanel = new IntroWindowPanel(logic.getFilteredPatientList(), logic.getFilteredRoomList());
        introPanelPlaceHolder.getChildren().add(introWindowPanel.getRoot());

        patientListPanel = new PatientListPanel(logic.getFilteredPatientList());
        patientListPanelPlaceholder.getChildren().add(patientListPanel.getRoot());

        roomListPanel = new RoomListPanel(logic.getFilteredRoomList());
        roomListPanelPlaceHolder.getChildren().add(roomListPanel.getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        StatusBarFooter statusBarFooter = new StatusBarFooter(logic.getCovigentAppFilePath());
        statusBarPlaceholder.getChildren().add(statusBarFooter.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    void show() {
        primaryStage.show();
    }


    public PatientListPanel getPatientListPanel() {
        return patientListPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.address.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}
