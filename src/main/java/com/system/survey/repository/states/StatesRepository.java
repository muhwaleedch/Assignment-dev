package com.system.survey.repository.states;

import com.system.survey.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatesRepository extends JpaRepository<State, Long> {

    List<State> findByCountryUuid(String countryUuid);

    Optional<State> findByStatesUuid(String statesUuid);
}
