package com.example.banking.domain;

// Entity
public class Account {
	private final String iban;
	// default permission , package private
	protected double balance; // information hiding principle

	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	// sadece getter yazdık çünkü değiştirmeleri setterdan yapmacağız bussines
	// methodları üzerinden yapıcaz

	public final double deposit(double amount) {
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException("amount cannot be negative");
		//business logic
		this.balance = this.balance + amount;
		return this.balance;
	}

	public double withdraw(double amount) {
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException("amount cannot be negative");
		// business rule
		if (amount > this.balance)
			throw new 	InsufficientBalanceException("amount cannot be negative",amount-this.balance);// Business Exception
		this.balance = this.balance - amount;
		return this.balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}
