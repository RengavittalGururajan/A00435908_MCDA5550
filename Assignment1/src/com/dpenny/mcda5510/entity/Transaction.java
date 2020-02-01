package com.dpenny.mcda5510.entity;

import java.sql.Date;

public class Transaction{

	private int ID;
	private String nameOnCard;
	private String cardNumber;
	private double unitprice;
	private int quantity;
	private double totalprice;
	private Date createdon;
	private String expdate;
	private String createdby;
	
	
	public Transaction() {
		super();
	}




	public Transaction(int iD, String nameOnCard, String cardNumber, double unitprice, int quantity, double totalprice,
			Date createdon, String expdate, String createdby) {
		super();
		ID = iD;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.unitprice = unitprice;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.createdon = createdon;
		this.expdate = expdate;
		this.createdby = createdby;
	}




	public int getID() {
		return ID;
	}




	public void setID(int iD) {
		ID = iD;
	}




	public String getNameOnCard() {
		return nameOnCard;
	}




	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}




	public String getCardNumber() {
		return cardNumber;
	}




	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}




	public double getUnitprice() {
		return unitprice;
	}




	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public double getTotalprice() {
		return totalprice;
	}




	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}




	public Date getCreatedon() {
		return createdon;
	}




	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}




	public String getExpdate() {
		return expdate;
	}




	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}




	public String getCreatedby() {
		return createdby;
	}




	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}




	@Override
	public String toString() {
		return "Transaction [ID=" + ID + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", unitprice="
				+ unitprice + ", quantity=" + quantity + ", totalprice=" + totalprice + ", createdon=" + createdon
				+ ", expdate=" + expdate + ", createdby=" + createdby + "]";
	}

	

	
	
}
