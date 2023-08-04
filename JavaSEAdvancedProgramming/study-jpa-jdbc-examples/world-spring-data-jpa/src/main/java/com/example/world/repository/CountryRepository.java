package com.example.world.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.world.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String>{
	List<Country> getAllByContinent(String continent);
	Optional<Country> getTopByOrderByPopulationDesc();
	List<Country> getAllByPopulationBetweenAndContinent(long begin,long end,String continent);
	@Query(nativeQuery = false, value = "select c from Country c where c.population between :begin and :end and continent=:continent")
	List<Country> bulGetir(long begin,long end,String continent);
}
