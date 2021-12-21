package com.example.individualassignment.repositories;

import com.example.individualassignment.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    Party findPartyByName(String name);
    boolean existsByName(String name);

}