package lidar.model;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimulationParameter {
	private final StringProperty simulationType;
	private final StringProperty beamType;
	private final IntegerProperty axialDivision;
	
	public SimulationParameter() {
		simulationType = new SimpleStringProperty("monoPulse");
		beamType = new SimpleStringProperty("multiLines");
		axialDivision = new SimpleIntegerProperty(100);
	}
	
	public String getSimulationType() {
		return simulationType.get();
	}
	
	public void setSimulationType(String simulationType) {
		this.simulationType.set(simulationType);
	}
	
	public String getBeamType() {
		return beamType.get();
	}
	
	public void setBeamType(String beamType) {
		this.beamType.set(beamType);
	}
	
	public int getAxialDivision() {
		return axialDivision.get();
	}
	
	public void setAxialDivision(int axialDivision) {
		this.axialDivision.set(axialDivision);
	}
	
	public void load(String filename) {
		try {
			String content = FileUtils.readFileToString(new File(filename));
			JSONObject deviceJson = new JSONObject(content);
			
			setSimulationType(deviceJson.getString("simulationType"));
			setBeamType(deviceJson.getString("beamType"));
			setAxialDivision(deviceJson.getInt("axialDivision"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save(String filename) {
		try {
			JSONObject deviceJson = new JSONObject();
			deviceJson.put("simulationType", getSimulationType());
			deviceJson.put("beamType", getBeamType());
			deviceJson.put("axialDivision", getAxialDivision());
			
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
//			deviceJson.write(writer);
			writer.write(deviceJson.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
