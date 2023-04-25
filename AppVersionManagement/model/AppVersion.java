package model;

public class AppVersion {
	private int versionCode;
	private String versionName;
	private String fileName;
	private String minSupportedOS;
	
	public AppVersion(int versionCode, String versionName, String fileName, String minSupportedOS) {
		this.versionCode = versionCode;
		this.versionName = versionName;
		this.fileName = fileName;
		this.minSupportedOS = minSupportedOS;
	}
	
	public int getVersionCode() {
		return versionCode;
	}
	
	public String getVersionName() {
		return versionName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getMinSupportedOS() {
		return minSupportedOS;
	}
}
