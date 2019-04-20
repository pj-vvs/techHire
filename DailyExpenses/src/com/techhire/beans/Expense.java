package com.techhire.beans;

public class Expense {
	
	String category;
	int paidAmt;
	String day;
	
	public Expense() {
		
	}
	
	public Expense(String category, int paidAmt, String day) {
		this.category = category;
		this.paidAmt = paidAmt;
		this.day = day;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPaidAmt() {
		return paidAmt;
	}
	public void setPaidAmt(int paidAmt) {
		this.paidAmt = paidAmt;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	

}
