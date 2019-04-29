package lidar.view;

import javafx.fxml.FXML;
import lidar.MainApp;
import utils.Const;

public class RootLayoutController {
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleSave() {
		mainApp.getDevice().save(Const.LIDAR_DEVICE);
		mainApp.getSimulationParameter().save(Const.LIDAR_SIMULATION_PARAMETER);
	}
}
