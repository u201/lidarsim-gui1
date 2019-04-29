package lidar.view;

import java.util.ArrayList;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import lidar.MainApp;
import lidar.model.SimulationParameter;

public class SurveyController {
	@FXML
	private RadioButton monoPulseRadio;
	@FXML
	private RadioButton alsRadio;
	@FXML
	private RadioButton tlsRadio;
	@FXML
	private RadioButton singleLineRadio;
	@FXML
	private RadioButton multiLinesRadio;
	@FXML
	private TextField axialDivisionField;
	
	private ToggleGroup simulationType;
	private ToggleGroup beamType;
	
	
	private MainApp mainApp;
	private SimulationParameter simulationParameter;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		simulationParameter = mainApp.getSimulationParameter();
		showDetails();
	}
	
	private void showDetails() {
		ArrayList<RadioButton> radioButtons = new ArrayList<RadioButton>();
		radioButtons.add(monoPulseRadio);
		radioButtons.add(alsRadio);
		radioButtons.add(tlsRadio);
		radioButtons.add(singleLineRadio);
		radioButtons.add(multiLinesRadio);
		
		for (RadioButton radioButton : radioButtons) {
			if (simulationParameter.getSimulationType().equals(radioButton.getUserData())) {
				radioButton.setSelected(true);
			}
			if (simulationParameter.getBeamType().equals(radioButton.getUserData())) {
				radioButton.setSelected(true);
			}
		}
		
		axialDivisionField.setText(Integer.toString(simulationParameter.getAxialDivision()));
	}
	
	@FXML
	private void initialize() {
		init();
		addListeners();
	}
	
	private void init() {
		simulationType = new ToggleGroup();
		beamType = new ToggleGroup();
		
		monoPulseRadio.setUserData("monoPulse");	
		monoPulseRadio.setToggleGroup(simulationType);
		
		alsRadio.setUserData("als");
		alsRadio.setToggleGroup(simulationType);
		
		tlsRadio.setUserData("tls");
		tlsRadio.setToggleGroup(simulationType);
		
		singleLineRadio.setUserData("singleLine");
		singleLineRadio.setToggleGroup(beamType);
		
		multiLinesRadio.setUserData("multiLines");
		multiLinesRadio.setToggleGroup(beamType);
	}
	
	private void addListeners() {
		simulationType.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
			mainApp.getSimulationParameter().setSimulationType((String) newToggle.getUserData());
		});
		
		beamType.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
			mainApp.getSimulationParameter().setBeamType((String) newToggle.getUserData());
		});
		
		axialDivisionField.focusedProperty().addListener((ov, oldValue, newValue) -> {
			try {
				mainApp.getSimulationParameter().setAxialDivision(Integer.parseInt(axialDivisionField.getText()));
			} catch (Exception e) {
				axialDivisionField.setText(Integer.toString(mainApp.getSimulationParameter().getAxialDivision()));
				e.printStackTrace();
			}
		});
	}
}
