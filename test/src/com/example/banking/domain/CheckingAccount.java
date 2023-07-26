package com.example.banking.domain;

// Account -> super class/ base class
// CheckingAccount > sub-class/ derived class
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public boolean withdraw(double amount) {
		// validation
		if (amount <= 0)
			return false;
		// bussiness rule
		if (amount > (balance + overdraftAmount))
			return false;
		// bussiness logic
		balance = balance - amount;
		return true;

	}

}
