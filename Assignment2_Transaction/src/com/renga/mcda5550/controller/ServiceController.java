package com.renga.mcda5550.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.renga.mcda5550.bean.Transaction;
import com.renga.mcda5550.dao.ServicesDAO;




public class ServiceController extends HttpServlet 
{
	
	ServicesDAO dao=new ServicesDAO();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String action=req.getParameter("action");
		
		//HttpSession session=req.getSession();
		
		if(action==null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("JSP/HomePage.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("home"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("JSP/HomePage.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("insert"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("JSP/Insert_Transaction.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("retrieve"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("JSP/Retrieve_Transaction.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("update"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("JSP/Update_Transaction.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("delete"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("JSP/Delete_Transaction.jsp");
			rd.forward(req, resp);
		}
		if(action.equals("addtransaction"))
		{
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String cardnumber=req.getParameter("cardnumber");
			double unitprice=Double.parseDouble(req.getParameter("unitprice"));
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			double totalprice=Double.parseDouble(req.getParameter("totalprice"));
			String expdate=req.getParameter("expiry");
			String createdby=req.getParameter("createdby");
			
			Transaction transaction=new Transaction(id, name, cardnumber, unitprice, quantity, totalprice, java.sql.Date.valueOf(LocalDate.now()), expdate, createdby);
			
			boolean success=dao.createTransactions(transaction);
			
			if(success==true)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Success_Transaction.jsp");
				req.setAttribute("message","Transaction Created Successfully!");
				rd.forward(req, resp);
		
			}
		}
		if(action.equals("DeleteTransaction"))
		{
			int id=Integer.parseInt(req.getParameter("id"));
			
			if(dao.getTransactionfromID(id)==null)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Delete_Transaction.jsp");
				req.setAttribute("message","Sorry!The ID given is not found!");
				rd.forward(req, resp);
			}
			boolean deletesuccess=dao.deleteTransactions(id);
			if(deletesuccess==true)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Success_Transaction.jsp");
				req.setAttribute("message","Transaction of ID " + id + " deleted successfully!");
				rd.forward(req, resp);
			}
			if(deletesuccess==false)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Delete_Transaction.jsp");
				req.setAttribute("message","Some problem occured. Please try again!");
				rd.forward(req, resp);
			}
			
		}
		if(action.equals("RetrieveTransaction"))
		{
			int id=Integer.parseInt(req.getParameter("id"));
			
			if(dao.getTransactionfromID(id)==null)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Retrieve_Transaction.jsp");
				req.setAttribute("message","Sorry!The ID given is not found!");
				rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Display_Transaction.jsp");
				Transaction transaction = dao.getTransactionfromID(id);
				req.setAttribute("transaction", transaction);
				rd.forward(req, resp);
				
			}
			
		}
		if(action.equals("UpdateTransaction"))
		{
			int id=Integer.parseInt(req.getParameter("id"));
			
			if(dao.getTransactionfromID(id)==null)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Update_Transaction.jsp");
				req.setAttribute("message","Sorry!The ID given is not found!");
				rd.forward(req, resp);
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Update_Details.jsp");
				Transaction transaction = dao.getTransactionfromID(id);
				req.setAttribute("transaction", transaction);
				rd.forward(req, resp);
				
			}
			
		}
		if(action.equals("updatedetails"))
		{
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String cardnumber=req.getParameter("cardnumber");
			double unitprice=Double.parseDouble(req.getParameter("unitprice"));
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			double totalprice=Double.parseDouble(req.getParameter("totalprice"));
			String expdate=req.getParameter("expiry");
			String createdby=req.getParameter("createdby");
			
			Transaction transaction=new Transaction(id, name, cardnumber, unitprice, quantity, totalprice, expdate, createdby);
			
			boolean success= dao.updateTransaction(transaction);
			
			if(success ==true)
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Update_Success_Transaction.jsp");
				req.setAttribute("message", "Transaction of ID " + id + " updated successfully!");
				req.setAttribute("transaction", dao.getTransactionfromID(id));
				rd.forward(req, resp);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("JSP/Update_Transaction.jsp");
				req.setAttribute("message","Sorry!Some problem occured. Try again with correct details!");
				rd.forward(req, resp);
			}
		}
	}

}
