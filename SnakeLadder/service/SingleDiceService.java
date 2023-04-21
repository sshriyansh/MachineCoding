package service;
import java.util.Random;

public class SingleDiceService {
	public static int rollDice() {
		Random rand = new Random();
		   
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(6)+ 1;
        return rand_int1;
	}
}
