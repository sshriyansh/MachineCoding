
package service;
import model.*;
import java.util.*;

public class GamingService {
	private Board board;
	private Queue<Player> players;
	
	public GamingService() {
		this.board = new Board();
		this.players = new LinkedList<Player>();
	}
	
	public void setSnakes(List<Snake> snakes) {
		board.addSnakes(snakes);
	}
	
	public void setLadders(List<Ladder> ladders) {
		board.addLadders(ladders);
	}
	
	public void setPlayers(List<Player> players) {
		Map<String, Integer> playerPieces = new HashMap();
		for (Player player : players ) {
			this.players.add(player);
			playerPieces.put(player.getId(), 0);
		}
		board.setPlayerPieces(playerPieces);
	}
	
	public void startGame() {
		while(players.size() > 1) {
			Player currentPlayer = players.poll();
			int val = SingleDiceService.rollDice();
			System.out.println("Player " + currentPlayer.getName() + " got a dice roll: " + val );
			updatePlayerPosition(val, currentPlayer);
			System.out.println("Player " + currentPlayer.getName() + " current position after dice roll: " + board.getPlayerPieces().get(currentPlayer.getId()));
			if (isPlayerWon(currentPlayer)) {
				System.out.println("Player " + currentPlayer.getName() + "has won");
				board.getPlayerPieces().remove(currentPlayer);
			} else {
				players.add(currentPlayer);
			}
		}
	}
	
	private void updatePlayerPosition(int val, Player player) {
		int position = board.getPlayerPieces().get(player.getId());
		int newPosition = position+val;
		if (newPosition > 100)
			return;
		
		// check for snakes
		for (Snake snake : board.getSnakes()) {
			if (snake.getStartPosition() == newPosition) {
				newPosition = snake.getEndPosition();
			}
		}
		
		// check for ladder
		for (Ladder ladder : board.getLadders()) {
			if (ladder.getStartPosition() == newPosition) {
				newPosition = ladder.getEndPosition();
			}
		}
		
		board.getPlayerPieces().put(player.getId(), newPosition);
	}
	
	private boolean isPlayerWon(Player player) {
		if (board.getPlayerPieces().get(player.getId()) == 100)
			return true;
		return false;
	}
}
