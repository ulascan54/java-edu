package com.example.banking.app;

import com.example.banking.domain.Customer;

public class BankingApp {

	public static void main(String[] args) {
		Customer jack; // cmd opt o
		jack = new Customer("11111111110","jack bauer",1956,"jack@example.com","555 555");
		System.out.println(jack.getFullname());
		System.out.println(jack.getEmail());
		jack.setEmail("jack.deneme@examp.com");
		System.out.println(jack.getEmail());
		System.out.println(jack);
		System.out.println(jack.toString());
		System.out.println(jack.getClass());
		
	}
}
