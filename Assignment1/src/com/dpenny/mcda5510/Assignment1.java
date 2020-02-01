package com.dpenny.mcda5510;

import java.io.File;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import com.dpenny.mcda5510.connect.ConnectionFactory;
import com.dpenny.mcda5510.connect.MySQLJDBCConnection;
import com.dpenny.mcda5510.dao.MySQLAccess;
import com.dpenny.mcda5510.entity.Transaction;

public class Assignment1 {

	public static Connection single_instance;

	public static Connection getInstance() {
		if (single_instance == null) {
			MySQLJDBCConnection dbConnection = new MySQLJDBCConnection();
			single_instance = dbConnection.setupConnection();
		}

		return single_instance;
	}

	public static void main(String[] args) {
		MySQLAccess dao = new MySQLAccess();
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger("My Log");
		FileHandler fh;
		try {
			fh=new FileHandler("C:/SMU/Logs/MyLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			 //Connection connection = getInstance();

			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.getConnection("mySQLJDBC");

			//Connection connection = factory.getConnection("fake");
			
			
			//Transaction object to insert to db
			Transaction transaction= new Transaction(9, "Harish", "455555555", 5.0, 5, 10.0, Date.valueOf(LocalDate.now()), "01/2023", "Renga");
			
			
			//Transaction object to update in db
			Transaction updatetransaction= new Transaction(6, "XXXXXXXXXXX", "455555555", 5.0, 5, 10.0, Date.valueOf(LocalDate.now()), "01/2023", "Renga");
			
			//To obtain Transaction by giving ID
			Collection<Transaction> transactionfromid=dao.getTransactionfromID(connection, 9);
			
			if(transactionfromid.size()==0)
			{
				System.out.println("Transaction for the given ID does not exist!");
				logger.info("Transaction for the given ID does not exist!");
			}
			else
			{
				for(Transaction trans:transactionfromid)
				{
					System.out.println(trans.toString());
				}
			}
			
			//Insert Transaction
			Collection<Transaction> checktrans=dao.getTransactionfromID(connection, transaction.getID());
			if(checktrans.size()>0)
			{
				System.out.println("Mentioned ID already exists, Kindly enter correct ID!");
				logger.info("Mentioned ID already exists, Kindly enter correct ID!");
			}
			else
			{
			boolean success=dao.createTransactions(transaction, connection);
			if(success==true) { System.out.println("Record Inserted Successfully");
			logger.info("Record Inserted Successfully");
			}
			  else { System.out.println("Insert Failed");
			  logger.info("Insert Failed");
			  }
			}
			
			//Updating a transaction
			boolean updatesuccess=dao.updateTransaction(connection,updatetransaction);
			if(updatesuccess==true) { System.out.println("Record Updated Successfully"); 
			logger.info("Record Updated Successfully");
			}
			  else { System.out.println("Update Failed");
			  logger.info("Update Failed");
			  }
			
			//Delete Transaction
			boolean deletesuccess=dao.deleteTransactions(2, connection);
			if(deletesuccess==true) { System.out.println("Record Deleted Successfully"); 
			logger.info("Record Deleted Successfully");
			}
			  else { System.out.println("Delete Failed"); 
			  logger.info("Delete Failed");
			  }
			
			//Printing all Transactions
			Collection<Transaction> trxns = dao.getAllTransactions(connection);  
			for (Transaction trxn : trxns) { 
			  
			  System.out.println(trxn.toString()); }
			 

			if (connection != null) {
				connection.close();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
