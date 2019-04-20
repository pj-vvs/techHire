package com.techhire.services;

import org.json.JSONArray;

import com.techhire.beans.Budget;
import com.techhire.beans.Expense;
import com.techhire.dao.DBOperations;

public class ServiceOperations {

	public void addBudget(Budget budget) {

		DBOperations dbOps = new DBOperations();
		dbOps.addBudgetDetails(budget);

	}

	public void addNewExpense(Expense expense) {

		DBOperations dbOps = new DBOperations();
		dbOps.addExpenseDetails(expense);

	}

	public JSONArray fetchAllExpenses() {

		DBOperations dbOps = new DBOperations();
		return dbOps.fetchAllExpenseDetails();

	}

	public JSONArray getCustomSummary(String startDateStr, String endDateStr) {

		DBOperations dbOps = new DBOperations();
		return dbOps.getCustomSummaryDetails(startDateStr, endDateStr);

	}

}
