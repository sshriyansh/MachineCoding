package tasks;
import service.VersionManagementService;

public abstract class TaskExecuter {
	protected VersionManagementService versionManagementService;
	
	public TaskExecuter(final VersionManagementService versionManagementService) {
		this.versionManagementService = versionManagementService;
	}
	
	public abstract void execute(String task, String[] params);
}
