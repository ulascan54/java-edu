package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// alt + shit + S : generate source code
public class Customer extends Object {// Class -> attribute, ii. behavior -> method
	private final String identity; // attribute/state/data
	private String fullname;
	private final int birthYear;
	private String email;
	private String sms;
	private List<Account> accounts = new ArrayList<>();

	// Constructor -> method -> initializes attributes
	public Customer(String identity, String fullname, int birthYear, String email, String sms) {
		this.identity = identity;
		this.fullname = fullname;
		this.birthYear = birthYear;
		this.email = email;
		this.sms = sms;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getIdentity() {
		return identity;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public int getNumberOfAccounts() {
		return accounts.size();
	}
	
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	
	public Optional<Account> getAccount(String iban) {
		for(Account acc: accounts) {//for-each syntax
			if(acc.getIban().equals(iban)) return Optional.of(acc);
		}
		return Optional.empty();
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + ", birthYear=" + birthYear + ", email="
				+ email + ", sms=" + sms + "]";
	}

}
