package tasks;
import java.util.*;
import service.VersionManagementService;

public class TaskExecuterFactory {
	private Map<String, TaskExecuter> tasks = new HashMap<>();
	
	public TaskExecuterFactory(final VersionManagementService versionManagementService) {
		tasks.put("UPLOAD_APP_VERSION", new UploadVersionTaskExecuter(versionManagementService));
		tasks.put("RELEASE_APP_VERSION", new UploadVersionTaskExecuter(versionManagementService));
		tasks.put("RELEASE_APP_VERSION", new UploadVersionTaskExecuter(versionManagementService));
	}
}
