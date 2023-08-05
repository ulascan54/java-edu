package com.example.exercises;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		//countryDao.getAllContinents().stream().map(continent -> continent.equals(countryDao.findCountriesByContinent(continent).stream()
		//		.map(country -> country.getCities().stream().mapToInt(city -> city.getPopulation()).max()))).forEach(System.out::println));

		//var countries = countryDao.findAllCountries();
		//var mostPopulatedCitiesInEachCountry = countries.stream().map(country -> country.getCities().stream()
		//		.mapToInt(city -> city.getPopulation()).max());
		//var continents = countryDao.getAllContinents();
		//var countriesByContinents = continents.stream().map(continent -> countryDao.findCountriesByContinent(continent)).toList();

		//countriesByContinents.stream().map(countries -> countries.stream().map(country -> country.getCities().stream()
		//		.collect(Collectors.groupingBy())
		//));



	}

}