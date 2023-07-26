package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Functional Test for Account class")

class AccountTest {
	@DisplayName("creates an account object successfuly")
	@ParameterizedTest
	@CsvFileSource(resources = "/accounts.csv")
	void createAccount(String iban, double balance) {
		// 1. Setup/Fixture
		// 2. Call exercise method
		Account acc = new Account(iban, balance);
		// 3. verification
		assertEquals(iban, acc.getIban());
		assertEquals(balance, acc.getBalance());
		// 4. tear-down
	}

	@Test
	@DisplayName("with draw negative amount should return false")
	void withdrawNegativeAmountShouldReturnFalse() {
		Account account = new Account("tr1", 10_000);
		assertFalse(account.withdraw(-1.));
		assertEquals(10_000, account.getBalance());
	}
	@Test
	@DisplayName("withdraw amount greater than balance should return false")
	void withdrawOverBalanceShouldReturnFalse() {
		Account account = new Account("tr1", 10_000);
		assertFalse(account.withdraw(10_000.1));
		assertEquals(10_000, account.getBalance());
	}
	
	@Test
	@DisplayName("withdraw all balance should return true")
	void withdrawAllBalanceShouldReturnTrue() {
		Account account = new Account("tr1", 10_000);
		assertTrue(account.withdraw(10_000));
		assertEquals(0., account.getBalance());
	}
	
	@Test
	@DisplayName("deposit with negative amount should return false")
	void depositNegativeAmountShouldReturnFalse() {
		Account account = new Account("tr1", 10_000);
		assertFalse(account.deposit(-1));
		assertEquals(10_000, account.getBalance());
	}
	
	@Test
	@DisplayName("deposit positive amount should return true")
	void depositPositiveAmountShouldReturnTrue() {
		Account account = new Account("tr1", 10_000);
		assertTrue(account.deposit(1));
		assertEquals(10_001, account.getBalance());
	}
	
	@Test
	@DisplayName("toString() should contain Account")
	void toStringShouldContainAccount() {
		Account account = new Account("tr1", 10_000);
		assertTrue(account.toString().contains("Account"));
	}

}
