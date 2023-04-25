package model;
import java.util.*;

public class App {
	private String name;
	private List<AppVersion> versions;
	
	public App(String name) {
		this.name = name;
		this.versions = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<AppVersion> getVersions() {
		return versions;
	}
	
	public void addVersion(AppVersion version) {
		this.versions.add(version);
	}
}
