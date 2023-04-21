package service;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Snake;
import model.Ladder;
import model.Player;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfSnakes = scanner.nextInt();
		 
		List<Snake> snakes = new ArrayList<Snake>();
		List<Ladder> ladders = new ArrayList<Ladder>();
		List<Player> players = new ArrayList<Player>();
		
		for (int i=0; i < noOfSnakes; i++) {
			snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
		}
		
		int noOfLadders = scanner.nextInt();
		for (int i=0; i < noOfLadders; i++) {
			ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
		}
		
		int noOfPlayers = scanner.nextInt();
		
		for (int i=0; i < noOfPlayers; i++) {
			players.add(new Player(scanner.next()));
		}
		
		GamingService gamingService = new GamingService();
		gamingService.setLadders(ladders);
		gamingService.setSnakes(snakes);
		gamingService.setPlayers(players);
		gamingService.startGame();
	}
}
