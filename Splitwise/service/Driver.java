package service;
import java.util.Scanner;
import java.util.*;

import model.User;
import model.Expense;
import model.ExpenseType;
import model.PercentSplit;
import model.Split;
import model.EqualSplit;
import model.ExactSplit;

public class Driver {
	public static void main(String[] args) {
		SplitwiseService sw = new SplitwiseService();
		
		sw.addUser(new User("u1", "Shriyansh", "ssthegrt@gmail.com", "9494045480"));
		sw.addUser(new User("u2", "Nishant", "ssthegrt1@gmail.com", "9494045480"));
		sw.addUser(new User("u3", "Dhruv", "ssthegrt2@gmail.com", "9494045480"));
		sw.addUser(new User("u4", "Gaurav", "ssthegrt3@gmail.com", "9494045480"));
		
		Scanner scanner = new Scanner(System.in);
		
		 while (true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            
            switch(commandType) {
        	case "SHOW": 
        		if (commands.length == 1)
        			sw.showAllBalances();
        		else {
        			sw.showUserBalances(commands[1]);
        		}
        		break;
        	case "EXPENSE":
        		String paidUser = commands[1];
        		Double amount = Double.parseDouble(commands[2]);
        		int noOfUsers = Integer.parseInt(commands[3]);
        		String expenseType = commands[4 + noOfUsers];
        		List<Split> splits = new ArrayList<>();
        		switch(expenseType) {
    			case "EQUAL":
    				for (int i=1; i <= noOfUsers; i++) {
        				splits.add(new EqualSplit(sw.getUser(commands[3+i])));
    				}
    				sw.addExpense(paidUser, splits, ExpenseType.EQUAL, amount);
    			break;
    			case "EXACT":
    				for (int i=1; i <= noOfUsers; i++) {
        				splits.add(new ExactSplit(sw.getUser(commands[3+i]), Double.parseDouble(commands[4 + noOfUsers + i])));
    				}
    				sw.addExpense(paidUser, splits, ExpenseType.EXACT, amount);
    			break;
    			case "PERCENT":
    				for (int i = 0; i < noOfUsers; i++) {
                        splits.add(new PercentSplit(sw.getUser(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                    }
                    sw.addExpense(paidUser, splits, ExpenseType.PERCENT, amount);
                    break;
        		}
        		break;
            }
 		 }
	}
}
