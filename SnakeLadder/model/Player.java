package model;
import java.util.UUID;

public class Player {
	private int currentPosition = 0;
	private String name;
	private String id;
	
	public Player(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();;
	}
	
	public void setPosition(int position) {
		this.currentPosition = position;
	}
	
	public int getPosition() {
		return this.currentPosition;
	}
	
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
}
