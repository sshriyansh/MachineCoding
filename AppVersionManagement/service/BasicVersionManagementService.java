package service;

import java.util.*;
import model.AppVersion;
import model.Device;
import model.App;
import model.rollout.RolloutStrategy;

public class BasicVersionManagementService implements VersionManagementService {
	private List<App> apps;
	private List<Device> devices;
	
	public BasicVersionManagementService() {
		this.apps = new ArrayList<>();
		this.devices = new ArrayList<>();
	}
	
	public void addApp(App app) {
		this.apps.add(app);
	}
	
	public void addDevice(Device device) {
		this.devices.add(device);
	}
	
	public void uploadVersion(App app, AppVersion newVersion) {
		app.addVersion(newVersion);
	}
	
	public void releaseVersion(App app, AppVersion newVersion, RolloutStrategy strategy) {
		strategy.release(app, newVersion, devices);
	}
	
	public AppVersion checkForInstall(String appName, Device device) {
		String deviceOS = device.getOS();
		for (App app: apps) {
			if (app.getName().equals(appName)) {
				AppVersion supportedVersion  = null;
				for (AppVersion version: app.getVersions()) {
					if (version.getMinSupportedOS().compareTo(deviceOS) <= 0) {
						supportedVersion = version;
					}
				}
				return supportedVersion;
			}
		}
		
		return null;
	}
	
	public AppVersion checkForUpdate(String appName, String currentOS) {
		for (App app: apps) {
			if (app.getName().equals(appName)) {
				AppVersion latestVersion  = null;
				for (AppVersion version: app.getVersions()) {
					if (version.getMinSupportedOS().compareTo(currentOS) <= 0) {
						if (latestVersion == null || version.getVersionCode() > latestVersion.getVersionCode()) {
							latestVersion = version;
						}
					}
				}
				return latestVersion;
			}
		}
		return null;
	}
	
	public boolean isAppVersionSupported(String appName, String currentOS, AppVersion appVersion) {
		for (App app: apps) {
			if (app.getName().equals(appName)) {
				if (appVersion.getMinSupportedOS().compareTo(currentOS) <= 0) {
					return true;
				}
			}
		}
		return false;
	}
 	
}
