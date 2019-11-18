package com.guitar.db.repository;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    Location findFirstByStateLike(String stateName);

    List<Location> findTop5ByStateLike(String stateName);

    List<Location> findDistinctByStateLike(String stateName);

    List<Location> findByStateLike(String stateName);


    List<Location> findByStateAndCountry(String state, String country);

    List<Location> findByStateOrCountry(String state, String country);

    List<Location> findByStateEquals(String state);

    List<Location> findByStateNot(String state);

    List<Location> findByStateIs(String state);

    List<Location> findByStateIsNull(String state);
    List<Location> findByStateIsNotNull(String state);
    List<Location> findByStateNotNull(String state);

    List<Location> findByStateNotLike(String state);

    List<Location> findByStateStartingWith(String state);

    List<Location> findByStateIgnoreCaseStartingWith(String state);

    List<Location> findByStateEndingWith(String state);

    List<Location> findByStateContaining(String state);

    List<Location> findByStateOrderByCountryAsc(String state);

    List<Location> findByStateOrderByCountryDesc(String state);

}
