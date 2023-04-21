package model;

import java.util.List;

public class Expense {
	private double amount;
	private ExpenseType expenseType;
	private User paidBy;
	private List<Split> splitFor;
	
	public Expense(double Amount, ExpenseType e, User paidBy, List<Split> splitFor) {
		this.amount = amount;
		this.expenseType = e;
		this.paidBy = paidBy;
		this.splitFor = splitFor;
	}
	
	public List<Split> getSplits() {
		return this.splitFor;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public User getPaidUser() {
		return this.paidBy;
	}
}
