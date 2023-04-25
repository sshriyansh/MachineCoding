package model;

import java.util.*;

public class Device {
	private String deviceName;
	private String operatingSystem;
	private String hardware;
	private Map<String, AppVersion> apps;
	
	public Device(String deviceName, String operatingSystem) {
		this.deviceName = deviceName;
		this.operatingSystem = operatingSystem;
		this.apps = new  HashMap<>();
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public String getOS() {
		return operatingSystem;
	}
	
	public String getHardware() {
		return hardware;
	}
	
	public AppVersion getVersion(App app) {
		return apps.get(app.getName());
	}
	
	// assuming that adding a app will release a new version
	public void updateAppVersion(App app, AppVersion appVersion) {
		if (apps.containsKey(app.getName())) {
			apps.remove(app.getName());
		}
		
		apps.put(app.getName(), appVersion);
	}
}
