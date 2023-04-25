package model.rollout;

import java.util.List;

import model.App;
import model.AppVersion;
import model.Device;
public class BetaRolloutStrategy implements RolloutStrategy {
	public void release(App app, AppVersion newVersion, List<Device> devices) {
		int n  = devices.size()/2;
		int start = 0;
		for (Device device: devices) {
			device.updateAppVersion(app, newVersion);
			start++;
			if (start == n)
				break;
		}
	}
}
