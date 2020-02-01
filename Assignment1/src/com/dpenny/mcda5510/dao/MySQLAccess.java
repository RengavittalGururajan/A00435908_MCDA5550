package com.dpenny.mcda5510.dao;

/**
 * Original source code from 
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * 
**/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.dpenny.mcda5510.Exception.DataLayerException;
import com.dpenny.mcda5510.entity.Transaction;

public class MySQLAccess {



	public Collection<Transaction> getAllTransactions(Connection connection) {
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Transaction> results = new ArrayList<Transaction>();
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from mcda5550.Transaction");
			results = createTrxns(resultSet);

			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			statement = null;
			resultSet = null;
		}
		return results;

	}
	public Collection<Transaction> getTransactionfromID(Connection connection, int id) {
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Transaction> results = new ArrayList<Transaction>();
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			String query="select * from mcda5550.Transaction where ID=" + id;
			resultSet = statement.executeQuery(query);
			results = createTrxns(resultSet);

			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			statement = null;
			resultSet = null;
		}
		return results;

	}
	private Collection<Transaction> createTrxns(ResultSet resultSet) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();

		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			Transaction trxn = new Transaction();
			trxn.setID(resultSet.getInt(1));
			trxn.setNameOnCard(resultSet.getString(2));
			trxn.setCardNumber(resultSet.getString(3));
			trxn.setUnitprice(resultSet.getDouble(4));
			trxn.setQuantity(resultSet.getInt(5));
			trxn.setTotalprice(resultSet.getDouble(6));
			trxn.setExpdate(resultSet.getString(7));
			trxn.setCreatedon(resultSet.getDate(8));
			trxn.setCreatedby(resultSet.getString(9));
			results.add(trxn);

			// TODO
			/*
			 * String ID = resultSet.getString("ID"); String ExpDate =
			 * resultSet.getString("ExpDate"); String UnitPrice =
			 * resultSet.getString("UnitPrice"); Integer qty =
			 * resultSet.getInt("Quantity"); String totalPrice =
			 * resultSet.getString("TotalPrice"); Date createdOn =
			 * resultSet.getDate("CreatedOn"); String createdBy =
			 * resultSet.getString("CreatedBy");
			 */

		}

		return results;

	}
	
	
	public boolean createTransactions(Transaction transaction,Connection connection) throws DataLayerException {
		Statement statement = null;
		//ResultSet resultSet = null;
		PreparedStatement ps=null;
		int x=0;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = connection.prepareStatement("INSERT INTO Transaction values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,transaction.getID());
			ps.setString(2,transaction.getNameOnCard());
			ps.setString(3, transaction.getCardNumber());
			ps.setDouble(4,transaction.getUnitprice());
			ps.setInt(5, transaction.getQuantity());
			ps.setDouble(6,transaction.getTotalprice());
			ps.setString(7, transaction.getExpdate());
			ps.setDate(8, transaction.getCreatedon());
			ps.setString(9, transaction.getCreatedby());
			 x =ps.executeUpdate();
			 
			

			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataLayerException("SQL Execution Failed! Kindly enter correct values.");
		} finally {
			statement = null;
		}
		return x>0;

	}

	public boolean updateTransaction(Connection connection,Transaction transaction) throws DataLayerException {
		// DO the update SQL here
		Statement statement = null;
		//ResultSet resultSet = null;
		PreparedStatement ps=null;
		int x=0;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = connection.prepareStatement("UPDATE Transaction SET NameOnCard=?, CardNumber=?,UnitPrice=?, Quantity=?,TotalPrice=?,ExpDate=?,CreatedOn=?,CreatedBy=? where ID=? ");
			
			ps.setString(1,transaction.getNameOnCard());
			ps.setString(2, transaction.getCardNumber());
			ps.setDouble(3,transaction.getUnitprice());
			ps.setInt(4, transaction.getQuantity());
			ps.setDouble(5,transaction.getTotalprice());
			ps.setString(6, transaction.getExpdate());
			ps.setDate(7, transaction.getCreatedon());
			ps.setString(8, transaction.getCreatedby());
			ps.setInt(9,transaction.getID());
			x =ps.executeUpdate();
			 
			

			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataLayerException("SQL Execution Failed! Kindly enter correct ID!");
		} finally {
			statement = null;
		}
		return x>0;
		
		
	}
	public boolean deleteTransactions(int id,Connection connection) throws DataLayerException {
		Statement statement = null;
		//ResultSet resultSet = null;
		PreparedStatement ps=null;
		int x=0;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = connection.prepareStatement("DELETE from Transaction where ID=?");
			ps.setInt(1,id);
			 x =ps.executeUpdate();
			 
			

			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DataLayerException("SQL Execution Failed! Kindly enter correct ID!");
		} finally {
			statement = null;
		}
		return x>0;

	}
}
