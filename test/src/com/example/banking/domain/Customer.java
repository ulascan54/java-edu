package com.example.banking.domain;
// alt + shit + S : generate source code
public class Customer extends Object {// Class -> attribute, ii. behavior -> method
	private final String identity; //attribute/state/data
	private String fullname;
	private final int birthYear;
	private String email;
	private String sms;
	//Constructor -> method -> initializes attributes
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

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + ", birthYear=" + birthYear + ", email="
				+ email + ", sms=" + sms + "]";
	}
	
	
	
	
	
}
