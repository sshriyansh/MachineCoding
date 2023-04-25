package service;
import model.AppVersion;
import model.App;
import model.Device;
import model.rollout.RolloutStrategy;

public interface VersionManagementService {
	void uploadVersion(App app, AppVersion newVersion);
	void releaseVersion(App app, AppVersion newVersion, RolloutStrategy strategy);
	AppVersion checkForUpdate(String appName, String currentOS);
	AppVersion checkForInstall(String appName, Device device);
	boolean isAppVersionSupported(String appName, String currentOS, AppVersion appVersion);
}
