package com.example.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.world.repository.CountryRepository;

@SpringBootApplication
public class WorldSpringDataJpaApplication implements ApplicationRunner {
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(WorldSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		countryRepository.bulGetir(10_000_000, 80_000_000, "Asia")
		                 .forEach(System.out::println);
		countryRepository.getTopByOrderByPopulationDesc()
			             .ifPresent(System.out::println);
	}

}
