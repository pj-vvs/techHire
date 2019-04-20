package com.techhire.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.techhire.beans.Budget;
import com.techhire.beans.Expense;
import com.techhire.services.ServiceOperations;
import com.techhire.utils.Constants;
import com.techhire.utils.UtilClass;

/**
 * This Controller class handles four actions 
 * 				setting up budget 
 * 				add expenses
 * 				fetch summary of expenses
 * 				summary expenses for custom dates
 * 
 * @author prasad
 *
 */
public class ServletController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter(Constants.ACTION2);

		try {

			if (action.equalsIgnoreCase(Constants.BUDGET2)) {

				int budgetAmt = Integer.parseInt(request.getParameter(Constants.BUDGET_AMT));
				String month = request.getParameter(Constants.MONTH2);
				Budget budget = new Budget();
				budget.setBudgetAmt(budgetAmt);
				budget.setMonth(month);
				ServiceOperations sop = new ServiceOperations();
				sop.addBudget(budget);
				UtilClass.write(response, Constants.MESSAGE);

			}

			if (action.equalsIgnoreCase(Constants.ADD_EXPENSE)) {

				String category = request.getParameter(Constants.CATEGORY2);
				int paidAmt = Integer.parseInt(request.getParameter(Constants.PAID_AMT));
				String day = request.getParameter(Constants.DAY2);
				Expense expense = new Expense();
				expense.setCategory(category);
				expense.setPaidAmt(paidAmt);
				expense.setDay(day);

				ServiceOperations sop = new ServiceOperations();
				sop.addNewExpense(expense);

				UtilClass.write(response, Constants.MESSAGE);

			}
			if (action.equalsIgnoreCase(Constants.SUMMARY)) {

				ServiceOperations sop = new ServiceOperations();
				JSONArray jArr = sop.fetchAllExpenses();
				UtilClass.write(response, jArr.toString());

			}
			if (action.equalsIgnoreCase(Constants.CUSTOM_SUMMARY)) {

				ServiceOperations sop = new ServiceOperations();
				String startDateStr = request.getParameter(Constants.CATEGORY2);
				String endDateStr = request.getParameter(Constants.CATEGORY2);
				JSONArray jArr = sop.getCustomSummary(startDateStr, endDateStr);

				UtilClass.write(response, jArr.toString());
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
