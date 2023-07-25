package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Functional Test for Account")

class AccountTest {
	@DisplayName("creates an account object successfuly")
	@Test
	void createAccount() {
		// 1. Setup/Fixture
		// 2. Call exercise method
		Account acc = new Account("tr1", 10_000);
		// 3. verification
		assertEquals("tr1", acc.getIban());
		assertEquals(10_000, acc.getBalance());
		// 4. tear-down
		
	}

}
