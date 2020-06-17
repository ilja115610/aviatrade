package com.aviatrade.repository;

import com.aviatrade.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Long> {

    Aircraft findByName(String name);

    @Query
    List<Aircraft> findAllByNameContainingIgnoreCase(String name);

    @Query
    List<Aircraft> findAllByOrderByAircraftIdAsc();

    @Query
    Aircraft findFirstByOrderByAircraftIdDesc();

    Aircraft saveAndFlush(Aircraft air);

}
