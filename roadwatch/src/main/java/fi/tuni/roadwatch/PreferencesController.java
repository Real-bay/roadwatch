package fi.tuni.roadwatch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class PreferencesController {

    // TODO: Aapo linkkaa karttaan tai sit poistan.
    @FXML
    private Label locationLabel;
    @FXML
    private ComboBox<String> weatherComboBox;
    @FXML
    private ComboBox<String> conditionTypeComboBox;
    @FXML
    public ComboBox<String> maintenanceTaskCombobox;
    private SessionData sessionData;
    @FXML
    private Label preferencesSavedLabel;

    public void initializeController(SessionData sessionData) {
        this.sessionData = sessionData;

        ObservableList<String> taskTypesObservable= FXCollections.observableArrayList(sessionData.taskTypes);
        taskTypesObservable.add(0,"ALL");
        maintenanceTaskCombobox.setItems(taskTypesObservable);

        weatherComboBox.getSelectionModel().selectFirst();
        weatherComboBox.setValue("TEMPERATURE");

        conditionTypeComboBox.getSelectionModel().selectFirst();
        conditionTypeComboBox.setValue("OVERALL");

        maintenanceTaskCombobox.getSelectionModel().selectFirst();
        maintenanceTaskCombobox.setValue("ALL");
    }

    public void setPreferences() {
        sessionData.weatherPreference = weatherComboBox.getValue();
        sessionData.conditionPreference = conditionTypeComboBox.getValue();
        sessionData.maintenancePreference = maintenanceTaskCombobox.getValue();
        preferencesSavedLabel.setText("Preferences saved for next login!");
    }
}
