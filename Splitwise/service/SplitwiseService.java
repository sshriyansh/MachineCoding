package service;
import java.util.*;

import model.Expense;
import model.User;
import model.Split;
import model.PercentSplit;
import model.ExpenseType;

public class SplitwiseService {
	
	Map<String, Map<String, Double>> usermapping;
	Map<String, User> userMap;
	List<Expense> expenses;
	
	public SplitwiseService() {
		this.usermapping = new HashMap<String, Map<String, Double>>();
		this.userMap = new HashMap<String, User>();
		expenses = new ArrayList<Expense>();
	}
	
	public void addUser(User user) {
		this.userMap.put(user.getUserId(), user);
		this.usermapping.put(user.getUserId(), new HashMap<String, Double>());
	}
	
	public User getUser(String userId) {
		return this.userMap.get(userId);
	}
	
	public void addExpense(String paidUser, List<Split>splits, ExpenseType et, double amount) {
		
		Expense expense = getExpense(amount, et, userMap.get(paidUser), splits);
		expenses.add(expense);
		
		List<Split> splitS = expense.getSplits();
		for(Split split : splitS) {
			 String paidFor = split.getUser().getUserId();
			 Map<String, Double> currentBalance = usermapping.get(paidUser);
			 
			 if (!currentBalance.containsKey(paidFor)) {
				 currentBalance.put(paidFor, 0.0);
			 }
			 
			 currentBalance.put(paidFor, currentBalance.get(paidFor) + split.getAmount());
			 
			 currentBalance = usermapping.get(paidFor);
			 if (!currentBalance.containsKey(paidUser)) {
				 currentBalance.put(paidUser, 0.0);
			 }
			 
			 currentBalance.put(paidUser, currentBalance.get(paidUser) - split.getAmount());
		}
	}
	
	private Expense getExpense(double amount, ExpenseType et, User u, List<Split>splits) {
		switch(et) {
		case EQUAL:
			double amountPerHead = (double)Math.round(amount *100/splits.size())/100;
			for (Split split: splits) {
				split.setAmount(amountPerHead);
			}
			break;
		case EXACT:
			break;
		case PERCENT:
			for (Split split : splits) {
				PercentSplit p = (PercentSplit) split;
				split.setAmount(amount * p.getPercent()/100.0);			
			}
			break;
		}
		
		return new Expense(amount, et, u, splits);
	}
	
	public void showUserBalances(String userId) {
		Map<String, Double> balance = usermapping.get(userId);
		boolean isEmpty = true;
		for (Map.Entry<String, Double> entry : balance.entrySet()) {
			String userPaidFor = entry.getKey();
			double amount = entry.getValue();
			if (amount != 0) {
				isEmpty = false;
				printBalance(userId, userPaidFor, amount);
			}
		}
		
		if (isEmpty) {
			System.out.println("No balances");
		}
	}
	
	private void printBalance(String userId, String userPaidFor, double balance) {
		String userName1 = userMap.get(userId).getName();
		String userName2 = userMap.get(userPaidFor).getName();
		if (balance < 0) {
			System.out.println("User " + userName1 + " owes " + "user " + userName2 + ": " + Math.abs(balance));
		} else {
			System.out.println("User " + userName2 + " owes " + "user " + userName1 + ": " + Math.abs(balance));
		}
	}
	
	public void showAllBalances() {
		boolean isEmpty = true;
		for (Map.Entry<String, Map<String, Double>> balance : usermapping.entrySet()) {
			for (Map.Entry<String, Double> entry : balance.getValue().entrySet()) {
				String userPaidFor = entry.getKey();
				double amount = entry.getValue();
				if (amount != 0) {
					isEmpty = false;
					printBalance(balance.getKey(), userPaidFor, amount);
				}
			}
		}

		if (isEmpty) {
			System.out.println("No balances");
		}
	}
}
