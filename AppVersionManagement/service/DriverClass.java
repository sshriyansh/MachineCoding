package service;
import model.App;
import model.AppVersion;
import model.rollout.*;
import model.Device;

public class DriverClass {
	public static void main(String[] args) {
		BasicVersionManagementService versionManagementService = new BasicVersionManagementService(); 
		
		// Create a new App and upload few versions
		App phonePe = new App("PhonePe");
		AppVersion v1 = new AppVersion(1, "1.0.0", "phonepeV1.apk", "7.0");
		AppVersion v2 = new AppVersion(2, "1.1.0", "phonepeV2.apk", "7.1");
		
		versionManagementService.addApp(phonePe);
		versionManagementService.uploadVersion(phonePe, v1);
		versionManagementService.uploadVersion(phonePe, v2);
		
		System.out.println("Created an app: " + phonePe.getName() + " and uploaded versions: " + v1.getVersionName() + "  " + v2.getVersionName());
		
		// Register a device
		Device device = new Device("Redmi Note 7", "8.0");
		versionManagementService.addDevice(device);
		
		// Check for installation on a device.
		AppVersion version = versionManagementService.checkForInstall(phonePe.getName(), device);
		if (version != null) {
			System.out.println("Installable Version available for device " + device.getDeviceName() +  " : " +  version.getVersionName());
			device.updateAppVersion(phonePe, version);
			System.out.println("Version installed successfully on device " + device.getDeviceName() +  " : " +  version.getVersionName());
		}
		
		AppVersion v3 = new AppVersion(3, "1.2.0", "phonepeV3.apk", "7.5");
		versionManagementService.uploadVersion(phonePe, v3);
		
		AppVersion latestVersion = versionManagementService.checkForUpdate(phonePe.getName(), "7.5");
		if (latestVersion != null) {
			System.out.println("Latest Version available: " + latestVersion.getVersionName());
		}
		
		// Release the new version if it is supported for the device
		if (versionManagementService.isAppVersionSupported(phonePe.getName(), device.getOS(), latestVersion)) {
			versionManagementService.releaseVersion(phonePe, latestVersion, new FullRolloutStrategy());
			System.out.println("Latest version is supported and released for device: " + device.getDeviceName());
		}
		
		// Verify whether the device got the latest version or not.
		System.out.println("Verifying the version on device: " + device.getDeviceName() + ": " + device.getVersion(phonePe).getVersionName());
		
	}
}
