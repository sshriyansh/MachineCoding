package model;

public class PercentSplit extends Split {
	double percent;
	
	public PercentSplit(User u, double d) {
		super(u);
		this.percent = d;
	}
	
	public double getPercent() {
		return this.percent;
	}
}
