package lidar.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lidar.MainApp;
import lidar.model.Device;

public class DeviceController {
	@FXML
	private TextField sensorAreaField;
	@FXML
	private TextField footprintHalfAngleField;
	@FXML
	private TextField halfFovField;
	@FXML
	private TextField pulseEnergyField;
	@FXML
	private TextField acquisitionPeriodField;
	@FXML
	private TextField halfDurationNumberOfSigmaField;
	@FXML
	private TextField halfPulseDurationAtHalfPeakField;
	@FXML
	private TextField fractionAtRadiusField;
	
	private MainApp mainApp;
	
	private Device device;
	
	public DeviceController() {
		
	}
	
	@FXML
	private void initialize() {
		addListeners();
		
	}
	
	private void addListeners() {
		sensorAreaField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setSensorArea(Double.parseDouble(sensorAreaField.getText()));
			} catch (Exception e) {
//				sensorAreaField.setText(Double.toString(mainApp.getDevice().getSensorArea()));
				e.printStackTrace();
			}
		});
		
		sensorAreaField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setSensorArea(Double.parseDouble(sensorAreaField.getText()));
			} catch (Exception e) {
				sensorAreaField.setText(Double.toString(mainApp.getDevice().getSensorArea()));
				e.printStackTrace();
			}
		});
		
		footprintHalfAngleField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setFootprintHalfAngle(Double.parseDouble(footprintHalfAngleField.getText()));
			} catch (Exception e) {
//				footprintHalfAngleField.setText(Double.toString(mainApp.getDevice().getFootprintHalfAngle()));
				e.printStackTrace();
			}
		});
		
		footprintHalfAngleField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setFootprintHalfAngle(Double.parseDouble(footprintHalfAngleField.getText()));
			} catch (Exception e) {
				footprintHalfAngleField.setText(Double.toString(mainApp.getDevice().getFootprintHalfAngle()));
				e.printStackTrace();
			}
		});
		
		halfFovField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfFov(Double.parseDouble(halfFovField.getText()));
			} catch (Exception e) {
//				halfFovField.setText(Double.toString(mainApp.getDevice().getHalfFov()));
				e.printStackTrace();
			}
		});
		
		halfFovField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfFov(Double.parseDouble(halfFovField.getText()));
			} catch (Exception e) {
				halfFovField.setText(Double.toString(mainApp.getDevice().getHalfFov()));
				e.printStackTrace();
			}
		});
		
		pulseEnergyField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setPulseEnergy(Double.parseDouble(pulseEnergyField.getText()));
			} catch (Exception e) {
//				pulseEnergyField.setText(Double.toString(mainApp.getDevice().getPulseEnergy()));
				e.printStackTrace();
			}
		});
		
		pulseEnergyField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setPulseEnergy(Double.parseDouble(pulseEnergyField.getText()));
			} catch (Exception e) {
				pulseEnergyField.setText(Double.toString(mainApp.getDevice().getPulseEnergy()));
				e.printStackTrace();
			}
		});
		
		acquisitionPeriodField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setAcquisitionPeriod(Double.parseDouble(acquisitionPeriodField.getText()));
			} catch (Exception e) {
//				acquisitionPeriodField.setText(Double.toString(mainApp.getDevice().getAcquisitionPeriod()));
				e.printStackTrace();
			}
		});
		
		acquisitionPeriodField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setAcquisitionPeriod(Double.parseDouble(acquisitionPeriodField.getText()));
			} catch (Exception e) {
				acquisitionPeriodField.setText(Double.toString(mainApp.getDevice().getAcquisitionPeriod()));
				e.printStackTrace();
			}
		});
		
		halfDurationNumberOfSigmaField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfDurationNumberOfSigma(Double.parseDouble(halfDurationNumberOfSigmaField.getText()));
			} catch (Exception e) {
//				halfDurationNumberOfSigmaField.setText(Double.toString(mainApp.getDevice().getHalfDurationNumberOfSigma()));
				e.printStackTrace();
			}
		});
		
		halfDurationNumberOfSigmaField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfDurationNumberOfSigma(Double.parseDouble(halfDurationNumberOfSigmaField.getText()));
			} catch (Exception e) {
				halfDurationNumberOfSigmaField.setText(Double.toString(mainApp.getDevice().getHalfDurationNumberOfSigma()));
				e.printStackTrace();
			}
		});

		halfPulseDurationAtHalfPeakField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfPulseDurationAtHalfPeak(Double.parseDouble(halfPulseDurationAtHalfPeakField.getText()));
			} catch (Exception e) {
//				halfPulseDurationAtHalfPeakField.setText(Double.toString(mainApp.getDevice().getHalfPulseDurationAtHalfPeak()));
				e.printStackTrace();
			}
		});

		halfPulseDurationAtHalfPeakField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfPulseDurationAtHalfPeak(Double.parseDouble(halfPulseDurationAtHalfPeakField.getText()));
			} catch (Exception e) {
//				halfPulseDurationAtHalfPeakField.setText(Double.toString(mainApp.getDevice().getHalfPulseDurationAtHalfPeak()));
				e.printStackTrace();
			}
		});
		
		halfPulseDurationAtHalfPeakField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setHalfPulseDurationAtHalfPeak(Double.parseDouble(halfPulseDurationAtHalfPeakField.getText()));
			} catch (Exception e) {
				halfPulseDurationAtHalfPeakField.setText(Double.toString(mainApp.getDevice().getHalfPulseDurationAtHalfPeak()));
				e.printStackTrace();
			}
		});

		fractionAtRadiusField.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setFractionAtRadius(Double.parseDouble(fractionAtRadiusField.getText()));
			} catch (Exception e) {
//				fractionAtRadiusField.setText(Double.toString(mainApp.getDevice().getFractionAtRadius()));
				e.printStackTrace();
			}
		});
		
		fractionAtRadiusField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			try {
				mainApp.getDevice().setFractionAtRadius(Double.parseDouble(fractionAtRadiusField.getText()));
			} catch (Exception e) {
				fractionAtRadiusField.setText(Double.toString(mainApp.getDevice().getFractionAtRadius()));
				e.printStackTrace();
			}
		});
	}
	
	private void showDeviceDetails() {
		if (device != null) {
			sensorAreaField.setText(Double.toString(device.getSensorArea()));
			footprintHalfAngleField.setText(Double.toString(device.getFootprintHalfAngle()));
			halfFovField.setText(Double.toString(device.getHalfFov()));
			pulseEnergyField.setText(Double.toString(device.getPulseEnergy()));
			acquisitionPeriodField.setText(Double.toString(device.getAcquisitionPeriod()));
			halfDurationNumberOfSigmaField.setText(Double.toString(device.getHalfDurationNumberOfSigma()));
			halfPulseDurationAtHalfPeakField.setText(Double.toString(device.getHalfPulseDurationAtHalfPeak()));
			fractionAtRadiusField.setText(Double.toString(device.getFractionAtRadius()));
		}
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		this.device = mainApp.getDevice();
		showDeviceDetails();
	}
}
