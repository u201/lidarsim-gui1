package lidar;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lidar.model.AlsParameter;
import lidar.model.Device;
import lidar.model.SimulationParameter;
import lidar.model.TlsParameter;
import lidar.view.DeviceController;
import lidar.view.RootLayoutController;
import lidar.view.SurveyController;
import utils.Const;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private Device device;
	private SimulationParameter simulationParameter;
	private AlsParameter alsParameter;
	private TlsParameter tlsParameter;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LiDAR Simulation");
		
		initData();
		
		initRootLayout();
		
		showDevice();
		showPlatform();
		showSurvey();
	}
	
	private void initData() {
		device = new Device();
		device.load(Const.LIDAR_DEVICE);
		simulationParameter = new SimulationParameter();
		simulationParameter.load(Const.LIDAR_SIMULATION_PARAMETER);
		alsParameter = new AlsParameter();
		tlsParameter = new TlsParameter();
	}
	
	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showPlatform() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/platform.fxml"));
			AnchorPane platform = (AnchorPane) loader.load();
			
			rootLayout.setCenter(platform);
			
//			PlatformController controller = loader.getController();
//			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showDevice() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/device.fxml"));
			AnchorPane device = (AnchorPane) loader.load();
			
			rootLayout.setLeft(device);
			
			DeviceController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showSurvey() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/survey.fxml"));
			AnchorPane survey = (AnchorPane) loader.load();
			
			rootLayout.setBottom(survey);
			
			SurveyController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public Device getDevice() {
		return device;
	}
	
	public SimulationParameter getSimulationParameter() {
		return simulationParameter;
	}
	
	public AlsParameter getAlsParameter() {
		return alsParameter;
	}
	
	public TlsParameter getTlsParameter() {
		return tlsParameter;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
