package com.system.survey.repository.countries;

import com.system.survey.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCountriesUuid(String countriesUuid);

}
