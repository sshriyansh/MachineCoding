package model;

public class Snake {
	private int start;
	private int end;
	
	public Snake(int start, int end) {
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
