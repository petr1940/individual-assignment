package com.example.individualassignment.repositories;

import com.example.individualassignment.entities.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    Candidate findCandidateByName(String name);
    boolean existsByName(String name);

}