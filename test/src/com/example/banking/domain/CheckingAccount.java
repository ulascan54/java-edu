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
	public double withdraw(double amount) throws InsufficientBalanceException {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException("amount cannot be negative");
		// bussiness rule
		if (amount > (balance + overdraftAmount))
			throw new InsufficientBalanceException("amount cannot be negative", amount - balance - overdraftAmount);
		// bussiness logic
		balance = balance - amount;
		return balance;

	}

}
