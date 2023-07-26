package com.example.banking.app;

import java.util.Optional;
import java.util.function.Consumer;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;

public class BankingApp {

	public static void main(String[] args) {
		Customer jack; // cmd opt o
		jack = new Customer("11111111110", "jack bauer", 1956, "jack@example.com", "555 555");
		System.out.println(jack.getFullname());
		System.out.println(jack.getEmail());
		jack.setEmail("jack.deneme@examp.com");
		System.out.println(jack.getEmail());
		System.out.println(jack);
		System.out.println(jack.toString());
		System.out.println(jack.getClass());
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new Account("tr2", 20_000));
		jack.addAccount(new Account("tr3", 30_000));
		System.out.println("Number of account is " + jack.getNumberOfAccounts());
		System.out.println(jack.getAccount(1));
		System.out.println(jack.getAccount("tr3"));
		jack.getAccount("tr4").ifPresent(account -> account.withdraw(1_000));
		// Lambda Expression   
		Consumer<Account> withdraw1k = account -> account.withdraw(1_000);
		Consumer<Account> printAccount = account -> System.out.println(account);
		// opt + cmd + l extract to local variable
		jack.getAccount("tr2").ifPresent(withdraw1k.andThen(printAccount));
		//old way
		Optional<Account>acc = jack.getAccount("tr2");
		if(acc.isPresent()) {
			acc.get().withdraw(1_000);
			System.out.println(acc.get());
		}
	
		System.out.println("Total balance:" +jack.getBalance());
		System.out.println("Total balance:" +jack.getBalance8());
	}
}
