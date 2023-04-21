package model;

public class Ladder {
	private int start;
	private int end;
	
	public Ladder(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStartPosition() {
		return this.start;
	}
	
	public int getEndPosition() {
		return this.end;
	}
}
