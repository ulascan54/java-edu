package com.example.exercises;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise10 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
		
	public static void main(String[] args) {
		// Find the richest country of each continent with respect to their GNP (Gross National Product) values.
		worldDao.findAllCountries().stream().max(Comparator.comparing (Country::getGnp)).ifPresent(System.out::println);
		worldDao.findAllCountries().stream().max(Comparator.comparing (Country::getPopulation)).ifPresent(System.out::println);
		worldDao.findAllCountries().stream().filter(country -> country.getContinent().equals("Asia")).map(Country::getName).forEach(System.out::println);
		List<Country> asiaCountries = worldDao.findAllCountries().stream().filter(country -> country.getContinent().equals("Asia")).collect(Collectors.toList());
		asiaCountries.stream().sorted(Comparator.comparing(Country::getPopulation).reversed()).forEach(System.out::println);
		
		// code böyle temizleye biliriz:
		
		Comparator<Country> compareByGnp = comparing(Country::getGnp);
		Comparator<Country> compareByPopulation = comparing(Country::getPopulation);
		var compareByPopulationDesc = compareByPopulation.reversed();
		Consumer<Country> printCountry = System.out::println;
		Predicate<Country> asian = country -> "Asia".equals(country.getContinent());
		var allCountries = worldDao.findAllCountries();
		allCountries.stream().max(compareByGnp).ifPresent(printCountry);
		allCountries.stream().max(compareByPopulation).ifPresent(printCountry);
		var asianCountries = allCountries.stream().filter(asian).collect(toList());
		asianCountries.stream().sorted(compareByPopulationDesc).forEach(printCountry);
	}

}
