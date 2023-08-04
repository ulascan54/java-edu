package com.example.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.world.repository.CountryRepository;

@SpringBootApplication
public class WorldSpringDataMongodbApplication implements ApplicationRunner{
	@Autowired
	private CountryRepository countryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WorldSpringDataMongodbApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.err.println("Application is initialized.");
		countryRepository.getAllByPopulationBetweenAndContinent(10_000, 800_000_000, "Asia")
                         .forEach(System.out::println);
        countryRepository.getTopByOrderByPopulationDesc()
                         .ifPresent(System.out::println);
		
	}

}
