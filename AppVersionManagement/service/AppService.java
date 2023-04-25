package service;

public class AppService {
	static void installApp(String appName, String deviceName) {
		System.out.println("Installed an app: " + appName + " on device: "+ deviceName);
	}
	
	static void updateApp(String appName, String deviceName) {
		System.out.println("Updated an app: " + appName + " on device: " + deviceName);
	}
	
	
	static void createDiffPack(String appName, String fileName1, String fileName2) {
		System.out.println("Created Diff Pack from " + fileName1 + " to " + fileName2);
	}
}
