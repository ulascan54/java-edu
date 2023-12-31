package com.example.world;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.world.config.AppConfig;
import com.example.world.repository.CountryRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
		CountryRepository countryRepository = container.getBean(CountryRepository.class);
		countryRepository.findOne("TUR").ifPresent(System.out::println);
		countryRepository.findAll().forEach(System.out::println);
		countryRepository.getByContinent("Antractica").forEach(System.out::println);
		countryRepository.getContinents().forEach(System.out::println);
		container.close();
	}
}
