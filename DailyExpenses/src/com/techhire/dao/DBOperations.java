package com.techhire.dao;

import java.util.Date;

import org.json.JSONArray;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.techhire.beans.Budget;
import com.techhire.beans.Expense;
import com.techhire.utils.Constants;

public class DBOperations {

	
	public void addBudgetDetails(Budget budget) {
		try {
			Mongo m = new Mongo(Constants.LOCALHOST, Constants.PORT);
			DBCollection dbColl = m.getDB(Constants.DAILY_EXPENSES_DB).getCollection(Constants.BUDGET2);

			BasicDBObject data = new BasicDBObject();
			data.put(Constants.BUDGET_AMT, budget.getBudgetAmt());
			data.put(Constants.MONTH, new Date(budget.getMonth()));
			dbColl.insert(data);
			/*
			 * DBCursor dbc = dbColl.find();
			 * 
			 * while (dbc.hasNext()) { System.out.println(dbc.next());
			 * 
			 * }
			 */
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void addExpenseDetails(Expense expense) {

		try {
			Mongo m = new Mongo(Constants.LOCALHOST, Constants.PORT);

			// DBCollection dbColl = m.getDB("tech_hire").getCollection("expenses");
			DBCollection dbColl = m.getDB(Constants.DAILY_EXPENSES_DB).getCollection(Constants.EXPENSES);

			BasicDBObject data = new BasicDBObject();

			data.put(Constants.CATEGORY, expense.getCategory());
			data.put(Constants.PAID_AMT, expense.getPaidAmt());
			data.put(Constants.DAY, new Date(expense.getDay()));

			dbColl.insert(data);
			DBCursor dbc = dbColl.find();

			while (dbc.hasNext()) {
				System.out.println(dbc.next());

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public JSONArray fetchAllExpenseDetails() {

		JSONArray jArray = new JSONArray();
		try {
			Mongo m = new Mongo(Constants.LOCALHOST, Constants.PORT);

			DBCollection dbColl = m.getDB(Constants.DAILY_EXPENSES_DB).getCollection(Constants.EXPENSES);

			DBCursor dbc = dbColl.find();

			DBObject dobj = null;
			while (dbc.hasNext()) {

				dobj = dbc.next();
				System.out.println(dobj);
				jArray.put(dobj);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return jArray;

	}

	public JSONArray getCustomSummaryDetails(String startDateStr, String endDateStr) {

		JSONArray JArray = new JSONArray();
		try {
			Mongo m = new Mongo(Constants.LOCALHOST, Constants.PORT);
			DBCollection dbColl = m.getDB(Constants.DAILY_EXPENSES_DB).getCollection(Constants.EXPENSES);

			BasicDBObject query = new BasicDBObject();
			BasicDBObject dates = new BasicDBObject();

			query.put(Constants.DAY,
					dates.append(Constants.$GTE, new Date(startDateStr)).append(Constants.$LTE, new Date(endDateStr)));

			DBCursor dbc = dbColl.find(query);

			while (dbc.hasNext()) {

				DBObject dobj = dbc.next();
				System.out.println(dobj);
				JArray.put(dobj);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return JArray;

	}

	public static void main(String[] args) {

		DBOperations d = new DBOperations();

		Date date = new Date("04/12/2019");
		System.out.println(date);

		try {
			Budget b = new Budget();
			b.setBudgetAmt(8000);
			b.setMonth("12/04/2019");
			d.addBudgetDetails(b);
		} catch (Exception e) {

			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * Expense exp = new Expense(); exp.setCategory("Entertainment");
		 * exp.setDay("12/14/2018"); exp.setPaidAmt(20000); d.addExpenseDetails(exp);
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */

		try {

			// d.fetchAllExpenseDetails();

			// d.getCustomSummaryDetails("1/24/2019", "12/4/2019");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
