package com.kh.updateBank;

public class BankDTO {

	private int ACCOUNT_ID;
	private double balance;

	public BankDTO() {
		
	}

	public BankDTO(int ACCOUNT_ID,double balance) {
	this.ACCOUNT_ID = ACCOUNT_ID;
	this.balance = balance;
	}
	public int getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public void setACCOUNT_ID(int aCCOUNT_ID) {
		ACCOUNT_ID = aCCOUNT_ID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	






}
