package com.techhire.beans;

public class Budget {
	
	int budgetAmt;
	String month;
	
	
	
	public Budget() {
		
	}
	
	public Budget(int budgetAmt, String month) {
		this.budgetAmt = budgetAmt;
		this.month = month;
	}
	
	
	public int getBudgetAmt() {
		return budgetAmt;
	}
	public void setBudgetAmt(int budgetAmt) {
		this.budgetAmt = budgetAmt;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	
	

}
