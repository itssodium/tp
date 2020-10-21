package seedu.address.ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import seedu.address.logic.Logic;
import seedu.address.model.patient.Patient;
import seedu.address.model.patient.TEMP;
import seedu.address.model.room.Room;
import seedu.address.ui.UiPart;


/**
 * The Graph Panel, containing both the ui part for displaying a line chart of
 * total calories against date for the past seven days,
 * and the logic to create that chart.
 */
public class IntroWindowPanel extends UiPart<Region> {
    private static final String FXML = "IntroWindowPanel.fxml";
    ObservableList<Patient> patientObservableList;

    @FXML
    private AnchorPane roomDetailsPanelPlaceholder;
    //@FXML
    private LineChart<String, Number> lineChart;

    private BarChart<String, Number> barChart;
    public IntroWindowPanel(ObservableList<Patient> patientObservableList, ObservableList<Room> roomObservableList) {
        super(FXML);
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        this.patientObservableList = patientObservableList;
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        lineChart.getData().add(series);
        lineChart.setTitle("Room tasks");

        roomObservableList.forEach(room -> series.getData().add(new XYChart.Data<>(
                room.getRoomNumber() + "", room.getTaskList().getInternalList().size())));



        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        barChart = new BarChart<>(x, y);
        XYChart.Series<String, Number> stringNumberSeries = new XYChart.Series<>();
        barChart.getData().add(stringNumberSeries);
        barChart.setTitle("Temperature");
        HashMap<TEMP, Integer> map = new HashMap<>();

        patientObservableList.forEach(patient -> {
            TEMP temp = patient.getTempCategorisation();
            if(map.containsValue(temp)) {
                int val = map.get(temp);
                map.replace(temp, val + 1);
            } else {
                map.put(temp, 1);
            }
        });

        map.forEach((key, value) -> stringNumberSeries.getData().add(new XYChart.Data<>(
                key.toString(), value
        )));
        barChart.setTranslateX(450);
        barChart.setPrefSize(100, 100);
        lineChart.setPrefSize(100, 100);
        roomDetailsPanelPlaceholder.getChildren().addAll(lineChart, barChart);
    }


}