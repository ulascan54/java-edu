package com.example.world.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.world.entity.Country;

public interface CountryRepository extends MongoRepository<Country, String>{
	List<Country> getAllByContinent(String continent);
	Optional<Country> getTopByOrderByPopulationDesc();
	List<Country> getAllByPopulationBetweenAndContinent(long begin,long end,String continent);
	@Query("{}")
	List<Country> bulGetir(long begin,long end,String continent);
}
