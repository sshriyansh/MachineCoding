package model.rollout;
import java.util.List;
import model.App;
import model.AppVersion;
import model.Device;

public interface RolloutStrategy {
	void release(App app, AppVersion newVersion, List<Device> devices);
}
