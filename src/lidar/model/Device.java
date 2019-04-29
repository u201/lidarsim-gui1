package lidar.model;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import utils.Const;

public class Device {
	private final DoubleProperty sensorArea;
	private final DoubleProperty footprintHalfAngle;
	private final DoubleProperty halfFov;
	private final DoubleProperty pulseEnergy;
	private final DoubleProperty acquisitionPeriod;
	private final DoubleProperty halfDurationNumberOfSigma;
	private final DoubleProperty halfPulseDurationAtHalfPeak;
	private final DoubleProperty fractionAtRadius;
	
	public Device() {
		this.sensorArea = new SimpleDoubleProperty(0.1);
		this.footprintHalfAngle = new SimpleDoubleProperty(0.0012);
		this.halfFov = new SimpleDoubleProperty(0.0015);
		this.pulseEnergy = new SimpleDoubleProperty(1.0);
		this.acquisitionPeriod = new SimpleDoubleProperty(1.0);
		this.halfDurationNumberOfSigma = new SimpleDoubleProperty(3.0);
		this.halfPulseDurationAtHalfPeak = new SimpleDoubleProperty(2);
		this.fractionAtRadius = new SimpleDoubleProperty(0.368);
	}
	
	public double getSensorArea() {
		return sensorArea.get();
	}
	
	public void setSensorArea(double sensorArea) {
		this.sensorArea.set(sensorArea);
	}
	
	public double getFootprintHalfAngle() {
		return footprintHalfAngle.get();
	}
	
	public void setFootprintHalfAngle(double footprintHalfAngle) {
		this.footprintHalfAngle.set(footprintHalfAngle);
	}
	
	public double getHalfFov() {
		return halfFov.get();
	}
	
	public void setHalfFov(double halfFov) {
		this.halfFov.set(halfFov);
	}
	
	public double getPulseEnergy() {
		return pulseEnergy.get();
	}
	
	public void setPulseEnergy(double pulseEnergy) {
		this.pulseEnergy.set(pulseEnergy);
	}
	
	public double getAcquisitionPeriod() {
		return acquisitionPeriod.get();
	}
	
	public void setAcquisitionPeriod(double acquisitionPeriod) {
		this.acquisitionPeriod.set(acquisitionPeriod);
	}
	
	public double getHalfDurationNumberOfSigma() {
		return halfDurationNumberOfSigma.get();
	}
	
	public void setHalfDurationNumberOfSigma(double numberOfSigmaTime) {
		this.halfDurationNumberOfSigma.set(numberOfSigmaTime);
	}
	
	public double getHalfPulseDurationAtHalfPeak() {
		return halfPulseDurationAtHalfPeak.get();
	}
	
	public void setHalfPulseDurationAtHalfPeak(double halfPulseDurationAtHalfPeak) {
		this.halfPulseDurationAtHalfPeak.set(halfPulseDurationAtHalfPeak);
	}
	
	public double getFractionAtRadius() {
		return fractionAtRadius.get();
	}
	
	public void setFractionAtRadius(double fractionAtRadius) {
		this.fractionAtRadius.set(fractionAtRadius);
	}
	
	public void load(String filename) {
		try {
			String content = FileUtils.readFileToString(new File(filename));
			JSONObject deviceJson = new JSONObject(content);
			
			setSensorArea(deviceJson.getDouble("sensorArea"));
			setFootprintHalfAngle(deviceJson.getDouble("footprintHalfAngle"));
			setHalfFov(deviceJson.getDouble("halfFov"));		
			setPulseEnergy(deviceJson.getDouble("pulseEnergy"));
			setAcquisitionPeriod(deviceJson.getDouble("acquisitionPeriod"));
			setHalfDurationNumberOfSigma(deviceJson.getDouble("numberOfSigmaTime"));
			setHalfPulseDurationAtHalfPeak(deviceJson.getDouble("halfPulseDurationAtHalfPeak"));
			setFractionAtRadius(deviceJson.getDouble("fractionAtRadius"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save(String filename) {
		try {
			JSONObject deviceJson = new JSONObject();
			deviceJson.put("sensorArea", getSensorArea());
			deviceJson.put("footprintHalfAngle", getFootprintHalfAngle());
			deviceJson.put("halfFov", getHalfFov());
			deviceJson.put("pulseEnergy", getPulseEnergy());
			deviceJson.put("acquisitionPeriod", getAcquisitionPeriod());
			deviceJson.put("numberOfSigmaTime", getHalfDurationNumberOfSigma());
			deviceJson.put("halfPulseDurationAtHalfPeak", getHalfPulseDurationAtHalfPeak());
			deviceJson.put("fractionAtRadius", getFractionAtRadius());
			
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
//			deviceJson.write(writer);
			writer.write(deviceJson.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
