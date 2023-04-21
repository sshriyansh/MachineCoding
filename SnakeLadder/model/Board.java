package model;

import java.util.Map;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Board {
	List<Snake> snakes; // these can be made as objects;
	List<Ladder> ladders;
	Map<String, Integer> playerPieces;
	
	int boardSize = 100;
	public Board() {
		snakes = new ArrayList<Snake>();
		ladders = new ArrayList<Ladder>();
		playerPieces = new HashMap();
	}
	
	public void addSnakes(List<Snake>snakes) {
		this.snakes = snakes;
	}
	
	public void addLadders(List<Ladder>ladders) {
		this.ladders = ladders;
	}
	
	public List<Ladder> getLadders() {
		return this.ladders;
	}
	
	public List<Snake> getSnakes() {
		return this.snakes;
	}
	
	public Map<String, Integer> getPlayerPieces() {
		return this.playerPieces;
	}
	
	
	public void setPlayerPieces(Map<String, Integer> pieces) {
		this.playerPieces = pieces;
	}
}
