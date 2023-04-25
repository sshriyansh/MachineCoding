package model.rollout;

import java.util.List;
import model.Device;
import model.App;
import model.AppVersion;

public class FullRolloutStrategy implements RolloutStrategy {
	public void release(App app, AppVersion newVersion, List<Device> devices) {
		for (Device device: devices) {
			device.updateAppVersion(app, newVersion);
		}
	}
}
