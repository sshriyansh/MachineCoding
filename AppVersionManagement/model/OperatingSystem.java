package model;

public class OperatingSystem {
	private OperatingSystemType operatingSystemType;
	private String version;
	
	public OperatingSystem(String version, OperatingSystemType osType) {
		this.version = version;
		this.operatingSystemType = osType;
	}
	
	public String getVersion() {
		return version;
	}
	
	public OperatingSystemType  getOSType() {
		return operatingSystemType;
	}
}
