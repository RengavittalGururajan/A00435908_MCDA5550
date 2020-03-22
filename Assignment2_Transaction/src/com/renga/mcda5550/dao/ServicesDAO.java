package com.renga.mcda5550.dao;

import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;

import com.renga.mcda5550.bean.Transaction;
import com.renga.mcda5550.util.DatabaseUtil;






public class ServicesDAO 
{
	public boolean createTransactions(Transaction transaction) {
		Connection con = null;		
		PreparedStatement ps = null;
		
		con = DatabaseUtil.getConnection();
		int x=0;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = con.prepareStatement("INSERT INTO Transaction values(?,?,?,?,?,?,?,?,?)");
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
			//throw new DataLayerException("SQL Execution Failed! Kindly enter correct values.");
			e.printStackTrace();
		} finally {
			ps = null;
		}
		return x>0;

	}
	
	public Transaction getTransactionfromID( int id) {
		Connection con = null;		
		PreparedStatement ps = null;
		boolean flag=false;
		con = DatabaseUtil.getConnection();
		ResultSet resultSet = null;
		Transaction trxn = new Transaction();
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = con.prepareStatement("select * from Transaction where ID=?");
			ps.setInt(1,id);
			resultSet = ps.executeQuery();
			while(resultSet.next())
			{
				flag=true;
				trxn.setID(resultSet.getInt(1));
				trxn.setNameOnCard(resultSet.getString(2));
				trxn.setCardNumber(resultSet.getString(3));
				trxn.setUnitprice(resultSet.getDouble(4));
				trxn.setQuantity(resultSet.getInt(5));
				trxn.setTotalprice(resultSet.getDouble(6));
				trxn.setExpdate(resultSet.getString(7));
				trxn.setCreatedon(resultSet.getDate(8));
				trxn.setCreatedby(resultSet.getString(9));
				
			}

			if (resultSet != null) {
				resultSet.close();
			}

			if (ps != null) {
				ps.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps = null;
			resultSet = null;
		}
		if(flag==false)
		{
			return null;
		}
		return trxn;

	}
	public boolean deleteTransactions(int id) {
		Connection con = null;		
		PreparedStatement ps = null;
		con = DatabaseUtil.getConnection();
		int x=0;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = con.prepareStatement("DELETE from Transaction where ID=?");
			ps.setInt(1,id);
			 x =ps.executeUpdate();
			 
			

			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps = null;
		}
		return x>0;

	}
	public boolean updateTransaction(Transaction transaction) {
		// DO the update SQL here
		Connection con = null;		
		PreparedStatement ps = null;
		con = DatabaseUtil.getConnection();
		int x=0;
		// Result set get the result of the SQL query
		try {
			// Statements allow to issue SQL queries to the database
			ps = con.prepareStatement("UPDATE Transaction SET NameOnCard=?, CardNumber=?,UnitPrice=?, Quantity=?,TotalPrice=?,ExpDate=?,CreatedBy=? where ID=? ");
			
			ps.setString(1,transaction.getNameOnCard());
			ps.setString(2, transaction.getCardNumber());
			ps.setDouble(3,transaction.getUnitprice());
			ps.setInt(4, transaction.getQuantity());
			ps.setDouble(5,transaction.getTotalprice());
			ps.setString(6, transaction.getExpdate());
			ps.setString(7, transaction.getCreatedby());
			ps.setInt(8,transaction.getID());
			x =ps.executeUpdate();
			 
			

			if (ps != null) {
				ps.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps = null;
		}
		return x>0;
		
		
	}
}
